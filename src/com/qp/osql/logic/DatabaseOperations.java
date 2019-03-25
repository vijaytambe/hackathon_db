package com.qp.osql.logic;

import com.qp.osql.common.MemoryCache;
import com.qp.osql.master.Column;
import com.qp.osql.master.Database;
import com.qp.osql.master.Table;

import java.util.List;
import java.util.Map;

public class DatabaseOperations {


    public static String createDatabase(String name) {

        List<Database> databases = MemoryCache.getDatabases();
        if (databases.stream().anyMatch(d -> d.getName().equals(name))) {
            return "DB already exist with this name";
        }
        Database db = MemoryCache.addNewDatabase(new Database(name));
        MemoryCache.setActiveDB(db);

        return "DB successfully created";

    }

    public static String createTable(String tableName, List<Column> columns) {
        Database activeDB = MemoryCache.getActiveDB();

        if (activeDB.hasTable(tableName)) {
            return "Table name already present";
        }
        Table table = new Table(tableName, columns);
        activeDB.addTable(table);
        return "Table Added Successfully";

    }
}
