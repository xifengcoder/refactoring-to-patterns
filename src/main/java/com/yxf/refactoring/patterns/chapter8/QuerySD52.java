package com.yxf.refactoring.patterns.chapter8;

import com.yxf.refactoring.patterns.chapter8.exception.QueryException;
import com.yxf.refactoring.patterns.chapter8.exception.SDLoginFailedException;
import com.yxf.refactoring.patterns.chapter8.exception.SDNotFoundException;
import com.yxf.refactoring.patterns.chapter8.exception.SDSocketInitFailedException;

public class QuerySD52 extends AbstractQuery {
    private SDLoginSession sdLoginSession; // needed for SD version 5.2
    private String sdConfigFileName;

    public QuerySD52(String sdConfigFileName) {
        super();
        this.sdConfigFileName = sdConfigFileName;
    }

    @Override
    public SDQuery createQuery() {
        return sdLoginSession.createQuery(SDQuery.OPEN_FOR_QUERY);
    }

    @Override
    public void login(String server, String user, String password) throws QueryException {
        System.out.println("SD52 login to " + server + ", user: " + user + ", password: " + password);
        sdLoginSession = new SDLoginSession(sdConfigFileName, false);
        try {
            sdLoginSession.loginSession(server, user, password);
        } catch (SDLoginFailedException lfe) {
            throw new QueryException(QueryException.LOGIN_FAILED,
                    "Login failure\n" + lfe, lfe);
        } catch (SDSocketInitFailedException ife) {
            throw new QueryException(QueryException.LOGIN_FAILED,
                    "Socket fail\n" + ife, ife);
        } catch (SDNotFoundException nfe) {
            throw new QueryException(QueryException.LOGIN_FAILED,
                    "Not found exception\n" + nfe, nfe);
        }
    }
}
