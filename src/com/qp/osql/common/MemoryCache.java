package com.qp.osql.common;

import com.qp.osql.master.Database;
import com.qp.osql.master.Table;

import javax.xml.crypto.Data;
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

    public static Database getActiveDB() {
        return activeDB;
    }
}