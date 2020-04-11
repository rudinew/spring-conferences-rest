package com.study.springboot.exception.talk;

//400
public class TooLateApplyTalkException extends RuntimeException {
    public TooLateApplyTalkException() {
    }

    public TooLateApplyTalkException(String message) {
        super(message);
    }

    public TooLateApplyTalkException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooLateApplyTalkException(Throwable cause) {
        super(cause);
    }

    public TooLateApplyTalkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
