package com.qp.osql.logic;

import com.qp.osql.master.Column;
import com.qp.osql.master.Database;
import com.qp.osql.master.Table;

import java.util.List;
import java.util.Map;

public class DatabaseOperations {

    OSQLDatabase databaseConnection = OSQLDatabase.getDatabaseConnection();

    public String createDatabase(String name, List<Table> tables) {
        Map<String, Database> databases = databaseConnection.getDatabases();

        if (databases.containsKey(name)) {
            return "DB already exists with this name";
        }

        databases.put(name, null);
        databaseConnection.setDatabases(databases);

        return "DB successfully created";

    }

    public String createTable(String DBName, String tableName, List<Column> columns) {
        Map<String, Database> databases = databaseConnection.getDatabases();

        if(databases.containsKey(DBName)) {
            Database db = (Database)databases.get(DBName);
            if(db.getTables().containsKey(tableName)) {
                return "table with this name already exists";
            }
            Map<String, List<Column>> tables = db.getTables();
            tables.put(tableName, columns);
            db.setTables(tables);
            databases.put(DBName, db);
            return "Table "+tableName+" successfully created inside DB "+DBName;

        }else {
            return "No DB exists with this name";
        }
    }

    public String insertRow(String DBname, String tableName, List<Column> columns) {

        return "";

    }


    public Database getDBWithName(String DBName) {
        Map<String, Database> databases = databaseConnection.getDatabases();
        return databases.get(DBName);
    }
}
