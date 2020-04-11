package com.study.springboot.exception.talk;

//400
public class TooManyTalksPerParticipantException extends RuntimeException {
    public TooManyTalksPerParticipantException() {
    }

    public TooManyTalksPerParticipantException(String message) {
        super(message);
    }

    public TooManyTalksPerParticipantException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooManyTalksPerParticipantException(Throwable cause) {
        super(cause);
    }

    public TooManyTalksPerParticipantException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
