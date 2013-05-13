package com.riadh.samples;

/**
 * @author Riadh MNASRI
 * 
 */
public class MyCustomIOException extends Exception {

    private static final long serialVersionUID = 1L;

    public MyCustomIOException() {
    }

    /**
     * @param message
     */
    public MyCustomIOException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public MyCustomIOException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public MyCustomIOException(String message, Throwable cause) {
        super(message, cause);
    }

}
