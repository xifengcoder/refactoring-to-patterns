package com.yxf.refactoring.patterns.chapter8;

public class SDSession {
    public SDQuery createQuery(int openForQuery) {
        return new SDQuery();
    }
}
