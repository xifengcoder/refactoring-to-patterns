package com.yxf.refactoring.patterns.chapter8;

public class SDLoginSession {
    public SDLoginSession(String sdConfigFileName, boolean b) {
    }

    public void loginSession(String server, String user, String password) {
    }

    public SDQuery createQuery(int openForQuery) {
        return new SDQuery();
    }
}
