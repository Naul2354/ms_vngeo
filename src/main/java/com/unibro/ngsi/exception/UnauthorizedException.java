package com.unibro.ngsi.exception;

import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException {

    public static final int ACCESS_DENY = 401;
    private static final long serialVersionUID = 3219196785816059012L;

    public UnauthorizedException(String message) {
        super(message);
    }
}
