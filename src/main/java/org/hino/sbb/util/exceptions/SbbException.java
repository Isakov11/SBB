package org.hino.sbb.util.exceptions;

public class SbbException extends Exception {

    public SbbException() {
        }

    public SbbException(String message) {
            super(message);
        }

    public SbbException(String message, Throwable cause) {
            super(message, cause);
        }

    public SbbException(Throwable cause) {
            super(cause);
        }

    public SbbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
}
