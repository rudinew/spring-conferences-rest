package com.study.springboot.exception.talk;

//400
public class EmptyFieldTalkException extends RuntimeException {
    public EmptyFieldTalkException() {
    }

    public EmptyFieldTalkException(String message) {
        super(message);
    }

    public EmptyFieldTalkException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyFieldTalkException(Throwable cause) {
        super(cause);
    }

    public EmptyFieldTalkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
