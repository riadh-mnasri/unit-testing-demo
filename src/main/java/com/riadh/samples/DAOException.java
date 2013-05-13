package com.riadh.samples;

/**
 * @author Riadh MNASRI
 * 
 */
public class DAOException extends Exception {

    private static final long serialVersionUID = 1L;

    public DAOException() {
    }

    /**
     * @param message
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public DAOException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

}
