package com.study.springboot.exception.talk;
//409
public class TalkNameAlreadyExistsException extends RuntimeException {
    public TalkNameAlreadyExistsException() {
    }

    public TalkNameAlreadyExistsException(String message) {
        super(message);
    }

    public TalkNameAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TalkNameAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public TalkNameAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
