package com.qp.osql.master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    String name;
    List<Table> tables = new ArrayList<>();

    public Database(String name) {
        this.name = name;
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public String getName() {
        return name;
    }

    public boolean hasTable(String name) {
        return tables.stream().anyMatch(t -> t.getName().equals(name));
    }

    @Override
    public String toString() {
        return  name;
    }
}
