package com.unibro.ngsi.exception;

import lombok.Getter;

/**
 * NotfoundException.
 *
 * @author ThoND
 */
@Getter
public class NotfoundException extends RuntimeException {

    private static final long serialVersionUID = 3440626081585753988L;

    public NotfoundException(final String message) {
        super(message);
    }

}
