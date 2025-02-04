package ee.openeid.siga.service.signature.container.hashcode;

import ee.openeid.siga.common.auth.SigaUserDetails;
import ee.openeid.siga.common.exception.DuplicateDataFileException;
import ee.openeid.siga.common.exception.InvalidSessionDataException;
import ee.openeid.siga.common.exception.ResourceNotFoundException;
import ee.openeid.siga.common.model.HashcodeDataFile;
import ee.openeid.siga.common.model.Result;
import ee.openeid.siga.common.model.Signature;
import ee.openeid.siga.common.session.HashcodeContainerSessionHolder;
import ee.openeid.siga.service.signature.test.RequestUtil;
import ee.openeid.siga.service.signature.test.TestUtil;
import ee.openeid.siga.session.SessionService;
import eu.europa.esig.dss.model.MimeType;
import org.apache.commons.lang3.StringUtils;
import org.digidoc4j.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ee.openeid.siga.service.signature.test.RequestUtil.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class HashcodeContainerServiceTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @InjectMocks
    HashcodeContainerService containerService;

    @Mock
    private SessionService sessionService;

    @Before
    public void setUp() {
        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authentication.getPrincipal()).thenReturn(SigaUserDetails.builder()
                .clientName("client1")
                .serviceName("Testimine")
                .serviceUuid("a7fd7728-a3ea-4975-bfab-f240a67e894f").build());

        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        containerService.setConfiguration(Configuration.of(Configuration.Mode.TEST));
    }

    @Test
    public void successfulCreateContainer() {
        List<HashcodeDataFile> hashcodeDataFiles = RequestUtil.createHashcodeDataFiles();
        String containerId = containerService.createContainer(hashcodeDataFiles);
        Assert.assertFalse(StringUtils.isBlank(containerId));

        verifySessionServiceUpdateCalled(containerId, session -> {
            Assert.assertNotNull(session.getDataFiles());
            Assert.assertEquals(hashcodeDataFiles.size(), session.getDataFiles().size());
            for (int i = 0; i < hashcodeDataFiles.size(); ++i) {
                Assert.assertEquals(MimeType.fromFileName(hashcodeDataFiles.get(i).getFileName()).getMimeTypeString(), session.getDataFiles().get(i).getMimeType());
            }
        });
    }

    @Test
    public void successfulCreateContainerFromDataFileWithUnknownExtension() {
        List<HashcodeDataFile> hashcodeDataFiles = RequestUtil.createHashcodeDataFiles().stream().limit(1)
                .peek(dataFile -> dataFile.setFileName("filename.unknown")).collect(Collectors.toList());
        String containerId = containerService.createContainer(hashcodeDataFiles);
        Assert.assertFalse(StringUtils.isBlank(containerId));

        verifySessionServiceUpdateCalled(containerId, session -> {
            Assert.assertEquals(MimeType.BINARY.getMimeTypeString(), session.getDataFiles().get(0).getMimeType());
        });
    }

    @Test
    public void successfulUploadContainer() throws IOException, URISyntaxException {
        String container = new String(Base64.getEncoder().encode(TestUtil.getFileInputStream(SIGNED_HASHCODE).readAllBytes()));
        String containerId = containerService.uploadContainer(container);
        Assert.assertFalse(StringUtils.isBlank(containerId));
    }

    @Test
    public void successfulGetContainer() throws IOException, URISyntaxException {
        Mockito.when(sessionService.getContainer(any())).thenReturn(RequestUtil.createHashcodeSessionHolder());
        String container = containerService.getContainer(CONTAINER_ID);
        Assert.assertFalse(StringUtils.isBlank(container));
    }

    @Test
    public void successfulGetDataFiles() throws IOException, URISyntaxException {
        Mockito.when(sessionService.getContainer(any())).thenReturn(RequestUtil.createHashcodeSessionHolder());
        List<HashcodeDataFile> dataFiles = containerService.getDataFiles(CONTAINER_ID);
        Assert.assertEquals("test.txt", dataFiles.get(0).getFileName());
        Assert.assertEquals(Integer.valueOf(10), dataFiles.get(0).getFileSize());
        Assert.assertEquals("D0Zzjr7TcMXFLuCtlt7I9Fn7kBwspOKFIR7d+QO/FZg", dataFiles.get(0).getFileHashSha256());
        Assert.assertEquals("gRKArS6jBsPLF1VP7aQ8VZ7BA5QA66hj/ntmNcxONZG5899w2VFHg9psyEH4Scg7rPSJQEYf65BGAscMztSXsA", dataFiles.get(0).getFileHashSha512());
    }

    @Test
    public void successfulGetSignatures() throws IOException, URISyntaxException {
        Mockito.when(sessionService.getContainer(any())).thenReturn(RequestUtil.createHashcodeSessionHolder());
        List<Signature> signatures = containerService.getSignatures(CONTAINER_ID);
        Assert.assertEquals("id-a9fae00496ae203a6a8b92adbe762bd3", signatures.get(0).getId());
        Assert.assertEquals("LT", signatures.get(0).getSignatureProfile());
        Assert.assertFalse(StringUtils.isBlank(signatures.get(0).getGeneratedSignatureId()));
        Assert.assertEquals("SERIALNUMBER=PNOEE-38001085718, GIVENNAME=JAAK-KRISTJAN, SURNAME=JÕEORG, CN=\"JÕEORG,JAAK-KRISTJAN,38001085718\", C=EE", signatures.get(0).getSignerInfo());
    }

    @Test
    public void successfulGetSignature() throws IOException, URISyntaxException {
        HashcodeContainerSessionHolder session = createHashcodeSessionHolder();
        Mockito.when(sessionService.getContainer(any())).thenReturn(session);
        org.digidoc4j.Signature signature = containerService.getSignature(CONTAINER_ID, session.getSignatures().get(0).getGeneratedSignatureId());
        Assert.assertEquals("id-a9fae00496ae203a6a8b92adbe762bd3", signature.getId());
    }

    @Test
    public void addDataFileButSignatureExists() throws IOException, URISyntaxException {
        exceptionRule.expect(InvalidSessionDataException.class);
        exceptionRule.expectMessage("Unable to add/remove data file. Container contains signature(s)");
        Mockito.when(sessionService.getContainer(any())).thenReturn(RequestUtil.createHashcodeSessionHolder());
        containerService.addDataFiles(CONTAINER_ID, createHashcodeDataFileListWithOneFile());
    }

    @Test
    public void successfulAddDataFile() throws IOException, URISyntaxException {
        HashcodeContainerSessionHolder session = createHashcodeSessionHolder();

        session.getSignatures().clear();
        Mockito.when(sessionService.getContainer(any())).thenReturn(session);

        Result result = containerService.addDataFiles(CONTAINER_ID, createHashcodeDataFileListWithOneFile("test1.txt"));
        Assert.assertEquals(Result.OK, result);
    }

    @Test
    public void successfulRemoveDataFile() throws IOException, URISyntaxException {
        HashcodeContainerSessionHolder session = createHashcodeSessionHolder();

        session.getSignatures().clear();
        Mockito.when(sessionService.getContainer(any())).thenReturn(session);

        Result result = containerService.removeDataFile(CONTAINER_ID, "test.txt");
        Assert.assertEquals(Result.OK, result);
    }

    @Test
    public void removeDataFileNoDataFile() throws IOException, URISyntaxException {
        exceptionRule.expect(ResourceNotFoundException.class);
        exceptionRule.expectMessage("Data file named test.xml not found");

        HashcodeContainerSessionHolder session = createHashcodeSessionHolder();

        session.getSignatures().clear();
        Mockito.when(sessionService.getContainer(any())).thenReturn(session);

        Result result = containerService.removeDataFile(CONTAINER_ID, "test.xml");
        Assert.assertEquals(Result.OK, result);
    }

    @Test
    public void successfulCloseSession() {
        Result result = containerService.closeSession(CONTAINER_ID);
        Assert.assertEquals(Result.OK, result);
    }

    @Test
    public void uploadContainerWithDuplicateDataFilesThrows() throws IOException, URISyntaxException {
        exceptionRule.expect(DuplicateDataFileException.class);
        exceptionRule.expectMessage("Hashcodes data file contains duplicate entry: test1.txt");
        String container = new String(Base64.getEncoder().encode(getFile("hashcode_duplicate_data_files.asice")));
        containerService.uploadContainer(container);
    }

    @Test
    public void uploadContainerWithDuplicateDataFileInManifestThrows() throws IOException, URISyntaxException {
        exceptionRule.expect(DuplicateDataFileException.class);
        exceptionRule.expectMessage("duplicate entry in manifest file: test.txt");
        String container = new String(Base64.getEncoder().encode(getFile("hashcode_duplicate_data_files_in_manifest.asice")));
        containerService.uploadContainer(container);
    }

    @Test
    public void uploadContainerWithDuplicateDataFilesInSignatureThrows() throws IOException, URISyntaxException {
        exceptionRule.expect(DuplicateDataFileException.class);
        exceptionRule.expectMessage("Signature contains duplicate data file: test1.txt");
        String container = new String(Base64.getEncoder().encode(getFile("hashcode_duplicate_data_files_in_signature.asice")));
        containerService.uploadContainer(container);
    }

    @Test
    public void addDuplicateDataFileThrows() throws IOException, URISyntaxException {
        exceptionRule.expect(DuplicateDataFileException.class);
        exceptionRule.expectMessage("Duplicate data files not allowed: test.txt");

        HashcodeContainerSessionHolder session = createHashcodeSessionHolder();
        session.getSignatures().clear();
        Mockito.when(sessionService.getContainer(any())).thenReturn(session);
        containerService.addDataFiles(CONTAINER_ID, createHashcodeDataFileListWithOneFile());
    }

    private void verifySessionServiceUpdateCalled(String expectedSessionId, Consumer<HashcodeContainerSessionHolder> sessionValidator) {
        ArgumentCaptor<HashcodeContainerSessionHolder> sessionCaptor = ArgumentCaptor.forClass(HashcodeContainerSessionHolder.class);
        Mockito.verify(sessionService, Mockito.times(1)).update(Mockito.eq(expectedSessionId), sessionCaptor.capture());
        Mockito.verifyNoMoreInteractions(sessionService);

        sessionValidator.accept(sessionCaptor.getValue());
    }

    private byte[] getFile(String fileName) throws IOException, URISyntaxException {
        return TestUtil.getFileInputStream(fileName).readAllBytes();
    }

}
