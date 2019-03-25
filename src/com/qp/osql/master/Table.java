package com.qp.osql.master;

import java.util.List;

public class Table {
    String name;
    List<Column> columns;

    public Table(String name, List<Column> columns) {
        this.name = name;
        this.columns = columns;

    }

    public String getName() {
        return name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
