package com.yxf.refactoring.patterns.chapter8;

public class SDLogin {
    public SDSession loginSession(String server, String user, String password) {
        return new SDSession();
    }
}
