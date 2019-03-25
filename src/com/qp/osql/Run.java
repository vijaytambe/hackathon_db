package com.qp.osql;

import com.qp.osql.exception.QueryException;
import com.qp.osql.logic.QueryParser;


public class Run {

    public static void runCommand(String command) throws QueryException {
        try {
            new QueryParser(command).myMain();
        }catch (Throwable t){
            throw new QueryException("oops, something went wrong...");
        }
    }

}