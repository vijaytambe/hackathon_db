package com.qp.osql.common;

import java.util.Arrays;
import java.util.List;

public enum Operation {
    HELP(0, "HELP"),
    CREATE(1, "CREATE TABLE"),
    //    INSERT(2, "INSERT"),
//    UPDATE(3, "UPDATE"),
//    DELETE(4, "DELETE"),
    CREATE_DB(5, "CREATE DATABASE"),
    //    ALTER_DB(6, "ALTER DATABASE"),
//    DROP_DB(7, "DROP DATABASE"),
    SHOW_DB(8, "SHOW DATABASES"),
    USE_DB(9, "USE DATABASE"),
    SHOW_TABLE(10, "SHOW TABLES");

    private int id;
    private String name;

    Operation(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<Operation> getAll() {
        return Arrays.asList(values());
    }

    public static Operation getByID(long ID) {
        return getAll().stream().filter(
                var -> var.getId() == ID).findFirst().orElse(HELP);
    }

    public static Operation getByName(String name) {
        return getAll().stream().filter(
                var -> var.getName().equals(name)).findFirst().orElse(HELP);
    }

    public static Operation getByQuery(String query) {
        return getAll().stream().filter(
                var -> query.startsWith(var.getName())).findFirst().orElse(HELP);
    }
}
