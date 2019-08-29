package ee.openeid.siga.service.signature.mobileid;

public enum MidStatus {

    OUTSTANDING_TRANSACTION,
    SIGNATURE,
    EXPIRED_TRANSACTION,
    USER_CANCEL,
    MID_NOT_READY,
    INTERNAL_ERROR,
    NOT_VALID,
    SENDING_ERROR,
    SIM_ERROR,
    PHONE_ABSENT,
    ;

}