package com.unibro.ngsi.exception;

import lombok.Getter;

/**
 * AlreadyExistsException.
 *
 * @author ThoND
 */
@Getter
public class AlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 3440626081585753988L;

    //    private int status;
    public AlreadyExistException(String message) {
        super(message);
    }
}
