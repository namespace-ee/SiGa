package ee.openeid.siga.mobileid.client;

import ee.openeid.siga.common.exception.ClientException;
import ee.openeid.siga.common.exception.MidException;
import ee.openeid.siga.common.exception.SigaApiException;
import org.springframework.ws.soap.client.SoapFaultClientException;

import java.util.Map;

public final class SoapFaultHandlingUtil {

    private static final String NOT_ACTIVE_FAULT = "NOT_ACTIVE";

    private SoapFaultHandlingUtil() {
        throw new IllegalStateException("Utility class");
    }

    private static final Map<String, String> FAULT_MAPPINGS = Map.of(
            "300", "GENERAL_ERROR",
            "301", "NOT_FOUND",
            "302", NOT_ACTIVE_FAULT,
            "303", NOT_ACTIVE_FAULT,
            "304", NOT_ACTIVE_FAULT,
            "305", NOT_ACTIVE_FAULT
    );

    public static SigaApiException handleSoapFaultClientException(SoapFaultClientException e) {
        String status = FAULT_MAPPINGS.get(e.getFaultStringOrReason());
        if (status != null) {
            return new MidException(status, e);
        }
        return new ClientException("Mobile-ID service error", e);
    }

}
