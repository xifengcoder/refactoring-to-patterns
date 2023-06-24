package com.yxf.refactoring.patterns.chapter8;

import com.yxf.refactoring.patterns.chapter8.exception.QueryException;

public class Client {
    private Query query;

    public static void main(String[] args) {
        Client client = new Client();
        client.loginToDatabase("user.db", "user", "123");
    }

    public void loginToDatabase(String db, String user, String password) {
        try {
            if (usingSDVersion52()) {
                query = new Query();
                query.login(db, user, password, getSD52ConfigFileName());  // Login to SD 5.2
            } else {
                query = new QuerySD51();
                query.login(db, user, password); // Login to SD 5.1
            }
        } catch (QueryException qe) {
            qe.printStackTrace();
        }
    }

    private String getSD52ConfigFileName() {
        return "sd52_config";
    }

    private boolean usingSDVersion52() {
        return true;
    }
}
