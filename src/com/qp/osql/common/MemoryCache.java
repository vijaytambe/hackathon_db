package com.qp.osql.common;

import com.qp.osql.master.Database;
import com.qp.osql.master.Table;

import java.util.ArrayList;
import java.util.List;

public class MemoryCache {

    private static List<Database> databases = new ArrayList<>();
    private static Database activeDB;

    public static Database addNewDatabase(Database database) {
        databases.add(database);
        return database;
    }

    public static void addNewTableToDatabase(Table table) {

    }

    public static void setActiveDB(Database db) {
        activeDB = db;
    }

    public static List<Database> getDatabases() {
        return databases;
    }

    public static Database getDatabasByName(String dbName) {
        return getDatabases().stream().filter(
                var -> var.getName().equalsIgnoreCase(dbName)).findFirst().orElse(null);
    }

    public static Database getActiveDB() {
        return activeDB;
    }

    public static void getTablesFromActiveDB() {
        System.out.println((getActiveDB() != null) ? getActiveDB().getTables() : Constant.NO_DB_SELECTED);
    }
}
