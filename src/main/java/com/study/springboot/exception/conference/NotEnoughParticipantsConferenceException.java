package com.study.springboot.exception.conference;
//400
public class NotEnoughParticipantsConferenceException extends RuntimeException {
    public NotEnoughParticipantsConferenceException() {
    }

    public NotEnoughParticipantsConferenceException(String message) {
        super(message);
    }

    public NotEnoughParticipantsConferenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughParticipantsConferenceException(Throwable cause) {
        super(cause);
    }

    public NotEnoughParticipantsConferenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
