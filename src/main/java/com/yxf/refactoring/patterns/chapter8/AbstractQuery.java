package com.yxf.refactoring.patterns.chapter8;

import com.yxf.refactoring.patterns.chapter8.exception.QueryException;

public abstract class AbstractQuery implements Query {
    protected SDQuery sdQuery; // this is needed for SD versions 5.1 & 5.2

    public AbstractQuery() {
        //sdLoginSession = new SDLoginSession("sd52_config", true);
    }

    public void doQuery() throws QueryException {     // a Template Method [DP]
        if (sdQuery != null)
            sdQuery.clearResultSet();
        sdQuery = createQuery();                    // call to the Factory Method
        executeQuery();
    }

    protected void executeQuery() {
    }
}
