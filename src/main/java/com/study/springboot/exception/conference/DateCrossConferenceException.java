package com.study.springboot.exception.conference;

//400
public class DateCrossConferenceException extends RuntimeException {
    public DateCrossConferenceException() {
    }

    public DateCrossConferenceException(String message) {
        super(message);
    }

    public DateCrossConferenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateCrossConferenceException(Throwable cause) {
        super(cause);
    }

    public DateCrossConferenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
