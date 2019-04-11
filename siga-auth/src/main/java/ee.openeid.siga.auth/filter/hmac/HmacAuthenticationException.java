package ee.openeid.siga.auth.filter.hmac;

import org.springframework.security.core.AuthenticationException;

class HmacAuthenticationException extends AuthenticationException {

    public HmacAuthenticationException(String msg) {
        super(msg);
    }

}