package org.graphlib.exception;

public class NoSuchVertexException extends Exception {
    public NoSuchVertexException() {
    }

    public NoSuchVertexException(String message) {
        super(message);
    }

    public NoSuchVertexException(String message, Throwable cause) {
        super(message, cause);
    }
}
