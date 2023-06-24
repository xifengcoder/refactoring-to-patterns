package com.yxf.refactoring.patterns.chapter8.exception;

public class SDSocketInitFailedException extends BaseException{

    public SDSocketInitFailedException(String message) {
        super(message);
    }

    public SDSocketInitFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SDSocketInitFailedException(Throwable cause) {
        super(cause);
    }
}
