package com.yxf.refactoring.patterns.chapter8;

import com.yxf.refactoring.patterns.chapter8.exception.QueryException;

public interface Query {
    SDQuery createQuery(); // a Factory Method [DP]

    void login(String server, String user, String password) throws QueryException;
}
