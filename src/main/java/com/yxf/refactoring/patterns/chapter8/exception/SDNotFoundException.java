package com.yxf.refactoring.patterns.chapter8.exception;

public class SDNotFoundException extends BaseException {
    public SDNotFoundException(Throwable cause) {
        super(cause);
    }

    public SDNotFoundException(String message) {
        super(message);
    }

    public SDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
