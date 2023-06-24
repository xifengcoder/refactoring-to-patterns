package com.yxf.refactoring.patterns.chapter8.exception;

public class QueryException extends RuntimeException {

    public static final int LOGIN_FAILED = 0x01;

    public QueryException(String message) {
        super(message);
    }

    public QueryException(String message, BaseException cause) {
        super(message, cause);
    }

    public QueryException(int errorCode, String message, BaseException cause) {
        super(String.format("%s(%d)", message, errorCode), cause);
    }

    public QueryException(BaseException cause) {
        super(cause);
    }
}
