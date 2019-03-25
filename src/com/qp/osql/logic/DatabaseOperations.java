package com.qp.osql.logic;

import com.qp.osql.common.Constant;
import com.qp.osql.common.MemoryCache;
import com.qp.osql.master.Column;
import com.qp.osql.master.Database;
import com.qp.osql.master.Table;

import java.util.List;

public class DatabaseOperations {


    public static String createDatabase(String name) {

        List<Database> databases = MemoryCache.getDatabases();
        if (databases.stream().anyMatch(d -> d.getName().equals(name))) {
            return Constant.DB_DUPLICATE;
        }
        Database db = MemoryCache.addNewDatabase(new Database(name));
        MemoryCache.setActiveDB(db);

        return Constant.DB_SUCCESS;

    }

    public static String createTable(String tableName, List<Column> columns) {
        Database activeDB = MemoryCache.getActiveDB();

        if (activeDB.hasTable(tableName)) {
            return tableName + Constant.TABLE_DUPLICATE;
        }
        Table table = new Table(tableName, columns);
        activeDB.addTable(table);
        return tableName + Constant.TABLE_ADDED;

    }
}
