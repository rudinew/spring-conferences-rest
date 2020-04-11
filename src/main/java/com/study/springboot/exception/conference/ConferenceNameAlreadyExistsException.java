package com.study.springboot.exception.conference;
//409
public class ConferenceNameAlreadyExistsException extends RuntimeException {
    public ConferenceNameAlreadyExistsException() {
    }

    public ConferenceNameAlreadyExistsException(String message) {
        super(message);
    }

    public ConferenceNameAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConferenceNameAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public ConferenceNameAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
