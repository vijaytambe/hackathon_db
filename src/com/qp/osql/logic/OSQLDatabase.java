package com.qp.osql.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OSQLDatabase {

    private static final OSQLDatabase databaseObject = new OSQLDatabase();
    private Map<String, List<OSQLDatabase>> databases = new HashMap<>();

    private OSQLDatabase() {}

    public static OSQLDatabase getDatabaseObj() {
        return databaseObject;
    }

    public Map<String, List<OSQLDatabase>> getDatabases() {
        return databases;
    }

    public void setDatabases(Map<String, List<OSQLDatabase>> databases) {
        this.databases = databases;
    }


}
