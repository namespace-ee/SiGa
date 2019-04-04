package ee.openeid.siga.service.signature;


import ee.openeid.siga.common.HashcodeDataFile;
import ee.openeid.siga.common.MobileIdInformation;
import ee.openeid.siga.common.SignatureWrapper;
import ee.openeid.siga.common.SigningType;
import ee.openeid.siga.common.event.SigaEvent;
import ee.openeid.siga.common.event.SigaEventLogger;
import ee.openeid.siga.common.exception.InvalidSessionDataException;
import ee.openeid.siga.common.session.DetachedDataFileContainerSessionHolder;
import ee.openeid.siga.mobileid.client.DigiDocService;
import ee.openeid.siga.mobileid.client.MobileIdService;
import ee.openeid.siga.mobileid.model.mid.GetMobileSignHashStatusResponse;
import ee.openeid.siga.mobileid.model.mid.MobileSignHashResponse;
import ee.openeid.siga.mobileid.model.mid.ProcessStatusType;
import ee.openeid.siga.service.signature.hashcode.SignatureDataFilesParser;
import ee.openeid.siga.service.signature.session.SessionIdGenerator;
import ee.openeid.siga.service.signature.util.ContainerUtil;
import ee.openeid.siga.session.SessionResult;
import ee.openeid.siga.session.SessionService;
import eu.europa.esig.dss.DSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.digidoc4j.*;
import org.digidoc4j.exceptions.TechnicalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static ee.openeid.siga.common.event.SigaEvent.EventResultType.EXCEPTION;
import static ee.openeid.siga.common.event.SigaEventName.ErrorCode.SIGNATURE_FINALIZING_ERROR;
import static ee.openeid.siga.common.event.SigaEventName.ErrorCode.SIGNATURE_FINALIZING_REQUEST_ERROR;
import static ee.openeid.siga.common.event.SigaEventName.OCSP;

@Slf4j
@Service
public class DetachedDataFileContainerSigningService implements DetachedDataFileSessionHolder {

    private static final String OK_RESPONSE = "OK";
    @Autowired
    private DigiDocService digiDocService;
    @Autowired
    private MobileIdService mobileIdService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private SigaEventLogger sigaEventLogger;

    private Configuration configuration;

    public DataToSign createDataToSign(String containerId, SignatureParameters signatureParameters) {
        DetachedDataFileContainerSessionHolder sessionHolder = getSession(containerId);
        verifyDataFileExistence(sessionHolder);
        DataToSign dataToSign = buildDetachedXadesSignatureBuilder(sessionHolder.getDataFiles(), signatureParameters).buildDataToSign();
        sessionHolder.setDataToSign(dataToSign);
        sessionHolder.setSigningType(SigningType.REMOTE);
        sessionService.update(containerId, sessionHolder);
        return dataToSign;
    }

    public String finalizeSigning(String containerId, String signatureValue) {
        DetachedDataFileContainerSessionHolder sessionHolder = getSession(containerId);
        validateRemoteSession(sessionHolder);
        DataToSign dataToSign = sessionHolder.getDataToSign();

        byte[] base64Decoded = Base64.getDecoder().decode(signatureValue.getBytes());
        Signature signature = finalizeSignature(dataToSign, base64Decoded);
        SignatureWrapper signatureWrapper = createSignatureWrapper(signature.getAdESSignature());

        sessionHolder.getSignatures().add(signatureWrapper);
        sessionHolder.clearSigning();
        sessionService.update(containerId, sessionHolder);
        return SessionResult.OK.name();
    }

    public String startMobileIdSigning(String containerId, MobileIdInformation mobileIdInformation, SignatureParameters signatureParameters) {
        DetachedDataFileContainerSessionHolder sessionHolder = getSession(containerId);
        verifyDataFileExistence(sessionHolder);
        X509Certificate signingCertificate = digiDocService.getMobileX509Certificate(mobileIdInformation.getPersonIdentifier(), mobileIdInformation.getCountry(), mobileIdInformation.getPhoneNo());
        signatureParameters.setSigningCertificate(signingCertificate);
        DataToSign dataToSign = buildDetachedXadesSignatureBuilder(sessionHolder.getDataFiles(), signatureParameters).buildDataToSign();
        byte[] digest = DSSUtils.digest(dataToSign.getDigestAlgorithm().getDssDigestAlgorithm(), dataToSign.getDataToSign());
        MobileSignHashResponse response = mobileIdService.initMobileSignHash(mobileIdInformation, dataToSign.getDigestAlgorithm().name(), Hex.encodeHexString(digest));
        if (!OK_RESPONSE.equals(response.getStatus())) {
            throw new IllegalStateException("Invalid DigiDocService response");
        }
        sessionHolder.setDataToSign(dataToSign);
        sessionHolder.setSigningType(SigningType.MOBILE_ID);
        sessionHolder.setSessionCode(response.getSesscode());
        sessionService.update(containerId, sessionHolder);
        return response.getChallengeID();
    }

    public String processMobileStatus(String containerId) {
        DetachedDataFileContainerSessionHolder sessionHolder = getSession(containerId);
        validateMobileIdSession(sessionHolder);
        GetMobileSignHashStatusResponse getMobileSignHashStatusResponse = mobileIdService.getMobileSignHashStatus(sessionHolder.getSessionCode());
        ProcessStatusType status = getMobileSignHashStatusResponse.getStatus();
        if (ProcessStatusType.SIGNATURE == status) {
            DataToSign dataToSign = sessionHolder.getDataToSign();
            Signature signature = finalizeSignature(dataToSign, getMobileSignHashStatusResponse.getSignature());
            SignatureWrapper signatureWrapper = createSignatureWrapper(signature.getAdESSignature());
            sessionHolder.getSignatures().add(signatureWrapper);
            sessionHolder.clearSigning();
            sessionService.update(containerId, sessionHolder);
        }
        return status.name();
    }

    private DetachedXadesSignatureBuilder buildDetachedXadesSignatureBuilder(List<HashcodeDataFile> dataFiles, SignatureParameters signatureParameters) {
        DetachedXadesSignatureBuilder builder = DetachedXadesSignatureBuilder.withConfiguration(configuration)
                .withSigningCertificate(signatureParameters.getSigningCertificate())
                .withSignatureProfile(signatureParameters.getSignatureProfile())
                .withSignatureDigestAlgorithm(DigestAlgorithm.SHA512)
                .withCountry(signatureParameters.getCountry())
                .withStateOrProvince(signatureParameters.getStateOrProvince())
                .withCity(signatureParameters.getCity())
                .withPostalCode(signatureParameters.getPostalCode());

        for (HashcodeDataFile hashcodeDataFile : dataFiles) {
            builder = builder.withDataFile(convertDataFile(hashcodeDataFile));
        }
        if (signatureParameters.getRoles() != null && !signatureParameters.getRoles().isEmpty()) {
            String[] roles = new String[signatureParameters.getRoles().size()];
            builder = builder.withRoles(signatureParameters.getRoles().toArray(roles));
        }
        return builder;
    }

    private SignatureWrapper createSignatureWrapper(byte[] signature) {
        SignatureWrapper signatureWrapper = new SignatureWrapper();
        SignatureDataFilesParser parser = new SignatureDataFilesParser(signature);
        Map<String, String> dataFiles = parser.getEntries();
        signatureWrapper.setGeneratedSignatureId(SessionIdGenerator.generateSessionId());
        signatureWrapper.setSignature(signature);
        ContainerUtil.addSignatureDataFilesEntries(signatureWrapper, dataFiles);
        return signatureWrapper;
    }

    /**
     * TSP/OCSP request events are currently generated by intercepting logging events from
     * digidoc4j library. Jira task DD4J-415 will introduce new features to observe
     * requests made to TSP/OCSP providers.
     *
     * @see <a href="https://jira.ria.ee/browse/DD4J-415">Jira task DD4J-415</a>
     */
    private Signature finalizeSignature(DataToSign dataToSign, byte[] base64Decoded) {
        SigaEvent ocspStartEvent = sigaEventLogger.logStartEvent(OCSP);
        try {
            Signature signature = dataToSign.finalize(base64Decoded);
            sigaEventLogger.logEndEventFor(ocspStartEvent);
            return signature;
        } catch (TechnicalException e) {
            log.error("Unable to finalize signature", e);
            logExceptionEventFor(ocspStartEvent, e);
            throw new ee.openeid.siga.common.exception.TechnicalException("Unable to finalize signature");
        }
    }

    private void logExceptionEventFor(SigaEvent ocspStartEvent, TechnicalException e) {
        String errorMessage = e.getCause() != null ? e.getCause().getMessage() : e.getMessage();
        if (StringUtils.contains(errorMessage, "Unable to process GET call for url")) {
            String errorUrl = StringUtils.substringBetween(e.getCause().getMessage(), "'", "'");
            sigaEventLogger.logExceptionEventFor(ocspStartEvent, SIGNATURE_FINALIZING_REQUEST_ERROR, errorMessage);
            Predicate<SigaEvent> predicate = event -> event.containsParameterWithValue(errorUrl);
            sigaEventLogger.getFirstMachingEventAfter(ocspStartEvent, predicate).ifPresent(requestEventFromDigidoc -> {
                requestEventFromDigidoc.setErrorCode(SIGNATURE_FINALIZING_REQUEST_ERROR);
                requestEventFromDigidoc.setErrorMessage(errorMessage);
                requestEventFromDigidoc.setResultType(EXCEPTION);
            });
        } else {
            sigaEventLogger.logExceptionEventForIntermediateEvents(ocspStartEvent, SIGNATURE_FINALIZING_ERROR, errorMessage);
        }
    }

    private DigestDataFile convertDataFile(HashcodeDataFile hashcodeDataFile) {
        String fileName = hashcodeDataFile.getFileName();
        DigestAlgorithm digestAlgorithm = DigestAlgorithm.SHA512;
        if (StringUtils.isBlank(hashcodeDataFile.getFileHashSha512())) {
            throw new TechnicalException("Unable to create signature. Unable to read file hash");
        }
        byte[] digest = Base64.getDecoder().decode(hashcodeDataFile.getFileHashSha512().getBytes());
        return new DigestDataFile(fileName, digestAlgorithm, digest);
    }

    private void verifyDataFileExistence(DetachedDataFileContainerSessionHolder sessionHolder) {
        if (sessionHolder.getDataFiles().size() < 1) {
            throw new InvalidSessionDataException("Unable to create signature. Data files must be added to container");
        }
    }

    private void validateRemoteSession(DetachedDataFileContainerSessionHolder sessionHolder) {
        if (sessionHolder.getDataToSign() == null) {
            throw new InvalidSessionDataException("Unable to finalize signature. Invalid session found");
        }
        if (SigningType.REMOTE != sessionHolder.getSigningType()) {
            throw new InvalidSessionDataException("Unable to finalize signature");
        }
    }

    private void validateMobileIdSession(DetachedDataFileContainerSessionHolder sessionHolder) {
        if (sessionHolder.getDataToSign() == null) {
            throw new InvalidSessionDataException("Unable to finalize signature. Invalid session found");
        }
        if (StringUtils.isBlank(sessionHolder.getSessionCode())) {
            throw new InvalidSessionDataException("Unable to finalize signature. Session code not found");
        }
        if (SigningType.MOBILE_ID != sessionHolder.getSigningType()) {
            throw new InvalidSessionDataException("Unable to finalize signature");
        }
    }

    @Override
    public SessionService getSessionService() {
        return sessionService;
    }

    @Autowired
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
