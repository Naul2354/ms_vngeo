package com.unibro.ngsi.exception;

import lombok.Getter;

/**
 * @author ThoND
 */
@Getter
public class StorageException extends RuntimeException {

    private static final long serialVersionUID = -3464778545184881406L;
    private final int status;

    public StorageException(String message) {
        super(message);
        this.status = GeneralException.GENERAL_STORAGE_EXCEPTION;
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
        this.status = GeneralException.GENERAL_STORAGE_EXCEPTION;
    }

    public StorageException(int status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public StorageException(int status, String message) {
        super(message);
        this.status = status;
    }
}
