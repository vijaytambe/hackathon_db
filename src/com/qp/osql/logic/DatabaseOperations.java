package com.qp.osql.logic;

import POJO.Column;
import POJO.Database;
import POJO.Table;
import com.qp.osql.master.Table;
import oSQl.OSQLDatabase;

import java.util.List;
import java.util.Map;

public class DatabaseOperations {

    OSQLDatabase databaseObject = OSQLDatabase.getDatabaseObj();

    public String createDatabase(String name, List<Table> tables) {
        Map<String, List<OSQLDatabase>> databases = databaseObject.getDatabases();

        if(databases.containsKey(name)){
            return "DB already exists with this name";
        }

        databases.put(name, null);
        databaseObject.setDatabases(databases);

        return "DB successfully created";

    }

    public String createTable(String DBName, String tableName, List<Column> columns) {
        Map<String, List<OSQLDatabase>> databases = databaseObject.getDatabases();

        if(databases.containsKey(DBName)) {
            Database db = (Database)databases.get(DBName);
            if(db.getTables().containsKey(tableName)) {
                return "table with this name already exists";
            }
            Map<String, List<Column>> tables = db.getTables();
            tables.put(tableName, columns);
            db.setTables(tables);
            /*databases.put(DBName, db);*/

        }else {
            return "No DB exists with this name";
        }

    }
}
