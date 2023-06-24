package com.yxf.refactoring.patterns.chapter8;

import com.yxf.refactoring.patterns.chapter8.exception.QueryException;

public class Client {
    private AbstractQuery query;

    public static void main(String[] args) {
        Client client = new Client();
        client.query();
    }

    public void query() {
        loginToDatabase("user.db", "user", "123");
        doQuery();
    }

    public void loginToDatabase(String db, String user, String password) {
        if (usingSDVersion52()) {
            query = new QuerySD52(getSD52ConfigFileName());
        } else {
            query = new QuerySD51();
        }
        try {
            query.login(db, user, password);
        } catch (QueryException qe) {
            qe.printStackTrace();
        }
    }

    private String getSD52ConfigFileName() {
        return "sd52_config";
    }

    private boolean usingSDVersion52() {
        return false;
    }

    public void doQuery() {
        query.doQuery();
    }
}
