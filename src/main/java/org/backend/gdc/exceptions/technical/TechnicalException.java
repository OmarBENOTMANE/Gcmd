package org.backend.gdc.exceptions.technical;

public class TechnicalException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }
}
