package com.qp.osql.master;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private String name;
    private List<Table> tables = new ArrayList<>();

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

    public List<Table> getTables() {
        return tables;
    }

    @Override
    public String toString() {
        return name;
    }
}
