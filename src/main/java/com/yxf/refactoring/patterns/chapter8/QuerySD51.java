package com.yxf.refactoring.patterns.chapter8;

import com.yxf.refactoring.patterns.chapter8.exception.QueryException;
import com.yxf.refactoring.patterns.chapter8.exception.SDLoginFailedException;
import com.yxf.refactoring.patterns.chapter8.exception.SDSocketInitFailedException;

public class QuerySD51 extends AbstractQuery {
    private SDLogin sdLogin; // needed for SD version 5.1
    private SDSession sdSession; // needed for SD version 5.1

    public QuerySD51() {
        super();
        sdLogin = new SDLogin();
    }

    @Override
    public void login(String server, String user, String password) throws QueryException {
        System.out.println("[QuerySD51] login");
        try {
            sdSession = sdLogin.loginSession(server, user, password);
        } catch (SDLoginFailedException lfe) {
            throw new QueryException(QueryException.LOGIN_FAILED,
                    "Login failure\n" + lfe, lfe);
        } catch (SDSocketInitFailedException ife) {
            throw new QueryException(QueryException.LOGIN_FAILED,
                    "Socket fail\n" + ife, ife);
        }
    }

    @Override
    public SDQuery createQuery() {
        return sdSession.createQuery(SDQuery.OPEN_FOR_QUERY);
    }
}
