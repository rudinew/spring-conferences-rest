package com.study.springboot.exception.conference;

//400
public class NullConferenceException extends RuntimeException {
    public NullConferenceException() {
    }

    public NullConferenceException(String message) {
        super(message);
    }

    public NullConferenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullConferenceException(Throwable cause) {
        super(cause);
    }

    public NullConferenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
