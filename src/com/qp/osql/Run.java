package com.qp.osql;

import com.qp.osql.logic.QueryParser;


public class Run {

    public static void runCommand(String command) {
        new QueryParser(command).myMain();
    }

}