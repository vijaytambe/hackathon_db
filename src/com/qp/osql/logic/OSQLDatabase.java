package com.qp.osql.logic;

import com.qp.osql.master.Database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OSQLDatabase {

    private static final OSQLDatabase databaseConnection = new OSQLDatabase();
    private Map<String, Database> databases = new HashMap<>();

    public Map<String, Database> getDatabases() {
        return databases;
    }

    public void setDatabases(Map<String, Database> databases) {
        this.databases = databases;
    }

    private OSQLDatabase() {}

    public static OSQLDatabase getDatabaseConnection() {
        return databaseConnection;
    }


}
