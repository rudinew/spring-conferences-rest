package com.study.springboot.exception.talk;

//400
public class NullTalkException extends RuntimeException {
    public NullTalkException() {
    }

    public NullTalkException(String message) {
        super(message);
    }

    public NullTalkException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullTalkException(Throwable cause) {
        super(cause);
    }

    public NullTalkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
