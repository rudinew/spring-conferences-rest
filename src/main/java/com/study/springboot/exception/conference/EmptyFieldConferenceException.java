package com.study.springboot.exception.conference;

//400
public class EmptyFieldConferenceException extends RuntimeException {
    public EmptyFieldConferenceException() {
    }

    public EmptyFieldConferenceException(String message) {
        super(message);
    }

    public EmptyFieldConferenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyFieldConferenceException(Throwable cause) {
        super(cause);
    }

    public EmptyFieldConferenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
