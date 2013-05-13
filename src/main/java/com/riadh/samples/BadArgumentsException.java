package com.riadh.samples;

/**
 * @author Riadh MNASRI
 * 
 */
public class BadArgumentsException extends Exception {

    public BadArgumentsException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public BadArgumentsException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public BadArgumentsException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public BadArgumentsException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

}
