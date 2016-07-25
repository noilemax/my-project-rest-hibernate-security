package ivanitsya.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by Администратор on 13.07.2016.
 */

public class TokenAuthenticationHeaderNotFound extends AuthenticationException {

    public TokenAuthenticationHeaderNotFound(String msg, Throwable t) {
        super(msg, t);
    }

}