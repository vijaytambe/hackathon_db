package com.qp.osql.master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    String name;
    Map<String, List<Column>> tables = new HashMap<>();

    public Map<String, List<Column>> getTables() {
        return tables;
    }

    public void setTables(Map<String, List<Column>> tables) {
        this.tables = tables;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
