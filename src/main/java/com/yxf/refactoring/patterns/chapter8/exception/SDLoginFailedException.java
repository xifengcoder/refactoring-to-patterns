package com.yxf.refactoring.patterns.chapter8.exception;

public class SDLoginFailedException extends BaseException{
    public SDLoginFailedException(String message) {
        super(message);
    }

    public SDLoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SDLoginFailedException(Throwable cause) {
        super(cause);
    }
}
