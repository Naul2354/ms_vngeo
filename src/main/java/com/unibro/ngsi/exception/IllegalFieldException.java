package com.unibro.ngsi.exception;

import lombok.Getter;

@Getter
public class IllegalFieldException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IllegalFieldException(String s) {
        super(s);
    }

}
