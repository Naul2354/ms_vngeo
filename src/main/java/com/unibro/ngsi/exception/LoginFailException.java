package com.unibro.ngsi.exception;

import lombok.Getter;

@Getter
public class LoginFailException extends RuntimeException {

    private static final long serialVersionUID = 1814511417970471051L;

    public LoginFailException(String message) {
        super(message);
    }
}
