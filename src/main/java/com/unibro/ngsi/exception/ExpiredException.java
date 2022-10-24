package com.unibro.ngsi.exception;

import lombok.Getter;

@Getter
public class ExpiredException extends RuntimeException {

    private static final long serialVersionUID = 3219196785816059012L;

    public ExpiredException(String message) {
        super(message);
    }
}
