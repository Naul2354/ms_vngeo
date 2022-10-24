package com.unibro.ngsi.exception;

import lombok.Getter;

@Getter
public class OptimisticLockException extends RuntimeException {

    public static final int OPTIMISTIC_LOCK = 601;
    private static final long serialVersionUID = 2L;

    public OptimisticLockException(String s) {
        super(s);
    }

}
