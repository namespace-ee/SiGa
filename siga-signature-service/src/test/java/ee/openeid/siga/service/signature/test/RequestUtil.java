package ee.openeid.siga.service.signature.test;


import ee.openeid.siga.common.model.DataFile;
import ee.openeid.siga.common.model.HashcodeDataFile;
import ee.openeid.siga.common.model.HashcodeSignatureWrapper;
import ee.openeid.siga.common.model.MobileIdInformation;
import ee.openeid.siga.common.model.RelyingPartyInfo;
import ee.openeid.siga.common.model.SmartIdInformation;
import ee.openeid.siga.common.session.AsicContainerSessionHolder;
import ee.openeid.siga.common.session.HashcodeContainerSessionHolder;
import ee.openeid.siga.common.util.UUIDGenerator;
import ee.openeid.siga.service.signature.client.ValidationReport;
import ee.openeid.siga.service.signature.client.ValidationResponse;
import ee.openeid.siga.service.signature.hashcode.HashcodeContainer;
import ee.openeid.siga.webapp.json.ValidationConclusion;
import eu.europa.esig.dss.model.MimeType;
import org.apache.commons.codec.digest.DigestUtils;
import org.digidoc4j.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.digidoc4j.Container.DocumentType.ASICE;

public class RequestUtil {
    public static final String SERVICE_UUID = "a7fd7728-a3ea-4975-bfab-f240a67e894f";
    public static final String CLIENT_NAME = "client1";
    public static final String SERVICE_NAME = "Testimine";
    public static final String SIGNED_HASHCODE = "hashcode.asice";
    public static final String VALID_ASICE = "test.asice";
    public static final String DOCUMENT_NUMBER = "PNOEE-123456789-QWER";
    public static final String CONTAINER_ID = "23423423-234234234-324234-4234";
    public static final String SMART_ID_SESSION_ID = "23423423-234234234-324234-1111";
    public static final String CERTIFICATE_ID = "23423423-234234234-324234-1111";

    public static List<HashcodeDataFile> createHashcodeDataFileListWithOneFile() {
        return createHashcodeDataFileListWithOneFile("test.txt");
    }

    public static List<HashcodeDataFile> createHashcodeDataFileListWithOneFile(String fileName) {
        List<HashcodeDataFile> hashcodeDataFiles = new ArrayList<>();
        HashcodeDataFile dataFile = new HashcodeDataFile();
        dataFile.setFileName(fileName);
        dataFile.setFileHashSha256("D0Zzjr7TcMXFLuCtlt7I9Fn7kBwspOKFIR7d+QO/FZg");
        dataFile.setFileSize(10);
        dataFile.setFileHashSha512("gRKArS6jBsPLF1VP7aQ8VZ7BA5QA66hj/ntmNcxONZG5899w2VFHg9psyEH4Scg7rPSJQEYf65BGAscMztSXsA");
        dataFile.setMimeType(MimeType.TEXT.getMimeTypeString());
        hashcodeDataFiles.add(dataFile);
        return hashcodeDataFiles;
    }

    public static List<DataFile> createDataFileListWithOneFile() {
        List<DataFile> dataFiles = new ArrayList<>();
        DataFile dataFile = new DataFile();
        dataFile.setFileName("test.txt");
        dataFile.setContent("D0Zzjr7TcMXFLuCtlt7I9Fn7kBwspOKFIR7d+QO/FZg");
        dataFiles.add(dataFile);
        return dataFiles;
    }

    public static List<HashcodeSignatureWrapper> createSignatureWrapper() throws IOException, URISyntaxException {

        HashcodeContainer hashcodeContainer = new HashcodeContainer();
        hashcodeContainer.open(TestUtil.getFile(SIGNED_HASHCODE));
        return hashcodeContainer.getSignatures();
    }

    public static ValidationResponse createValidationResponse() {
        ValidationResponse response = new ValidationResponse();
        ValidationReport validationReport = new ValidationReport();
        ValidationConclusion validationConclusion = new ValidationConclusion();
        validationConclusion.setValidSignaturesCount(1);
        validationConclusion.setSignaturesCount(1);
        validationReport.setValidationConclusion(validationConclusion);
        response.setValidationReport(validationReport);
        return response;
    }

    public static List<HashcodeDataFile> createHashcodeDataFiles() {
        List<HashcodeDataFile> hashcodeDataFiles = new ArrayList<>();
        HashcodeDataFile dataFile1 = new HashcodeDataFile();
        dataFile1.setFileHashSha256("SGotKr7DQfmpUTMp4p6jhumLKigNONEqC0pTySrYsms");
        dataFile1.setFileHashSha512("8dvW2xdYgT9ZEJBTibWXsP9H3LTOToBaQ6McE3BoPHjRnXvVOc/REszydaAMG4Pizt9RdsdKHbd94wO/E4Kfyw");
        dataFile1.setFileSize(10);
        dataFile1.setFileName("first datafile.txt");
        hashcodeDataFiles.add(dataFile1);
        HashcodeDataFile dataFile2 = new HashcodeDataFile();
        dataFile2.setFileHashSha256("SGotKr7DQfmpUTMp4p6jhumLKigNONEqC0pTySrYsms");
        dataFile2.setFileHashSha512("8dvW2xdYgT9ZEJBTibWXsP9H3LTOToBaQ6McE3BoPHjRnXvVOc/REszydaAMG4Pizt9RdsdKHbd94wO/E4Kfyw");
        dataFile2.setFileSize(10);
        dataFile2.setFileName("second datafile.txt");
        hashcodeDataFiles.add(dataFile2);
        return hashcodeDataFiles;
    }

    public static HashcodeDataFile createHashcodeDataFileFrom(String name, String mimetype, byte... content) {
        HashcodeDataFile hashcodeDataFile = new HashcodeDataFile();
        hashcodeDataFile.setFileHashSha256(org.apache.commons.codec.binary.Base64.encodeBase64String(DigestUtils.sha256(content)));
        hashcodeDataFile.setFileHashSha512(org.apache.commons.codec.binary.Base64.encodeBase64String(DigestUtils.sha512(content)));
        hashcodeDataFile.setFileSize(content.length);
        hashcodeDataFile.setMimeType(mimetype);
        hashcodeDataFile.setFileName(name);
        return hashcodeDataFile;
    }

    public static HashcodeContainerSessionHolder createHashcodeSessionHolder() throws IOException, URISyntaxException {
        List<HashcodeSignatureWrapper> signatureWrappers = new ArrayList<>();
        signatureWrappers.add(RequestUtil.createSignatureWrapper().get(0));
        Map<String, String> certificateSessions = new HashMap<>();
        certificateSessions.put(CERTIFICATE_ID, "123");
        return HashcodeContainerSessionHolder.builder()
                .sessionId(CONTAINER_ID)
                .clientName(CLIENT_NAME)
                .serviceName(SERVICE_NAME)
                .serviceUuid(SERVICE_UUID)
                .certificateSessionHolder(certificateSessions)
                .signatures(signatureWrappers)
                .dataFiles(RequestUtil.createHashcodeDataFileListWithOneFile()).build();
    }

    public static AsicContainerSessionHolder createAsicSessionHolder() throws IOException, URISyntaxException {
        String base64container = new String(Base64.getEncoder().encode(TestUtil.getFileInputStream(VALID_ASICE).readAllBytes()));
        InputStream inputStream = new ByteArrayInputStream(Base64.getDecoder().decode(base64container.getBytes()));
        Container container = ContainerBuilder.aContainer(ASICE).withConfiguration(Configuration.of(Configuration.Mode.TEST)).fromStream(inputStream).build();
        Map<String, String> certificateSessions = new HashMap<>();
        certificateSessions.put(CERTIFICATE_ID, "123");
        Map<String, Integer> signatureIdHolder = new HashMap<>();
        signatureIdHolder.put(UUIDGenerator.generateUUID(), Arrays.hashCode(container.getSignatures().get(0).getAdESSignature()));
        return AsicContainerSessionHolder.builder()
                .sessionId(CONTAINER_ID)
                .clientName(CLIENT_NAME)
                .serviceName(SERVICE_NAME)
                .serviceUuid(SERVICE_UUID)
                .certificateSessionHolder(certificateSessions)
                .signatureIdHolder(signatureIdHolder)
                .containerName("test.asice")
                .container(Base64.getDecoder().decode(base64container.getBytes()))
                .build();
    }

    public static SignatureParameters createSignatureParameters(X509Certificate certificate) {
        return createSignatureParameters(certificate, SignatureProfile.LT);
    }

    public static SignatureParameters createSignatureParameters(X509Certificate certificate, SignatureProfile signatureProfile) {
        SignatureParameters signatureParameters = new SignatureParameters();
        signatureParameters.setSigningCertificate(certificate);
        signatureParameters.setSignatureProfile(signatureProfile);
        signatureParameters.setDataFileDigestAlgorithm(DigestAlgorithm.SHA512);
        signatureParameters.setCountry("Estonia");
        signatureParameters.setStateOrProvince("Harjumaa");
        signatureParameters.setCity("Tallinn");
        signatureParameters.setPostalCode("34234");
        signatureParameters.setRoles(Collections.singletonList("Engineer"));
        return signatureParameters;
    }

    public static MobileIdInformation createMobileInformation() {
        MobileIdInformation mobileIdInformation = MobileIdInformation.builder()
                .phoneNo("+37253410832")
                .personIdentifier("3489348234")
                .language("EST")
                .messageToDisplay("Random display").build();
        return mobileIdInformation;
    }

    public static RelyingPartyInfo createRPInfoForMid() {
        return RelyingPartyInfo.builder()
                .name("Testimiseks")
                .build();
    }

    public static SmartIdInformation createSmartIdInformation() {
        SmartIdInformation smartIdInformation = SmartIdInformation.builder()
                .personIdentifier("30303039914")
                .country("EE")
                .documentNumber(DOCUMENT_NUMBER)
                .build();
        return smartIdInformation;
    }

    public static RelyingPartyInfo createRPInfoForSmartId() {
        return RelyingPartyInfo.builder()
                .name("DEMO")
                .uuid("00000000-0000-0000-0000-000000000000")
                .build();
    }
}
