package com.qp.osql.master;

import java.util.ArrayList;
import java.util.List;

public class Table {
    String name;
    List<Column> columns = new ArrayList<Column>();

    public Table(String name, List<Column> columns) {
        this.name = name;
        this.columns = columns;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
