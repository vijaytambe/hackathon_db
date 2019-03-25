package com.qp.osql.logic;

import com.qp.osql.common.Constant;
import com.qp.osql.common.MemoryCache;
import com.qp.osql.common.Operation;
import com.qp.osql.exception.QueryException;
import com.qp.osql.master.Column;
import com.qp.osql.master.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryParser {
    private String userQuery;
    private List<Column> columnNameList = new ArrayList<>(5);

    public QueryParser(String userQuery) {
        this.userQuery = userQuery;
    }

    public void parseQuery(String userQuery) {


    }

    public void databaseCreationQueryValidator() throws QueryException {
        List<String> queryString = Arrays.asList(userQuery.split(" "));
        isDatabaseQueryValid(queryString);
        System.out.println("Validated!!!!");
        System.out.println(queryString.get(0));
        System.out.println(queryString.get(1));
        System.out.println(queryString.get(2));
    }

    private void isDatabaseQueryValid(List<String> queryString) throws QueryException {
        if (queryString.size() != 3 || !queryString.get(0).equalsIgnoreCase("create")
                || !queryString.get(1).equalsIgnoreCase("database")) {
            throw new QueryException("Create Database query is invalid");
        }
    }

    private void isCreateTableQueryValid() {
        List<String> queryString = Arrays.asList(userQuery.split(" "));
    }

    public void selectTableQueryValidator() {
//        isQueryValid(userQuery);
    }

    public String queryValidator() {
        return null;

    }

    public int extractQueryType() {
        try {
            return Integer.parseInt(userQuery);
        } catch (Exception pe) {
            return Operation.getByQuery(userQuery).getId();
        }
    }


    public void createTableStructure() {

    }


    public void myMain() {
        if (userQuery != null && !userQuery.isBlank() && !userQuery.isEmpty()) {
            try {

                int operation = new QueryParser(userQuery.strip().toUpperCase()).extractQueryType();
                switch (operation) {
                    case 1:
                        createTableQueryProcessor();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        createDB();
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        showAllDB();
                        break;
                    case 9:
                        useDB();
                        break;
                    case 10:
                        showAllTable();
                        break;
                    default:
                        showHelp();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // invalid sql
        }


    }

    private void showHelp() {
        Operation.getAll().forEach(operation -> System.out.println(operation.getName()));
    }


    private void useDB() {
        Database databasByName = MemoryCache.getDatabasByName(getDBNameFromUse());
        if (databasByName != null) {
            MemoryCache.setActiveDB(databasByName);
            System.out.println(Constant.DB_USE + MemoryCache.getActiveDB().getName());
        } else
            System.out.println(getDBNameFromUse() + Constant.DB_NOT_EXISTS);

    }

    private void createDB() {

        try {
            createDatabaseQueryValidator();
            List<String> queryString = Arrays.asList(userQuery.split(" "));
            System.out.println(DatabaseOperations.createDatabase(queryString.get(2)));
        } catch (QueryException e) {
            e.printStackTrace();
        }
    }

    private static void showAllDB() {
        System.out.println(MemoryCache.getDatabases());
    }

    private void showAllTable() {
        MemoryCache.getTablesFromActiveDB();
    }

    public void createDatabaseQueryValidator() throws QueryException {
        List<String> queryString = Arrays.asList(userQuery.split(" "));
        isDatabaseQueryValid(queryString);
    }

    public String getDBNameFromUse() {
        List<String> queryString = Arrays.asList(userQuery.split(" "));
        return queryString.get(2);
    }

    public void createTableQueryProcessor() {
        List<String> queryString = Arrays.asList(userQuery.split(","));
        List<String> toGetTableName = Arrays.asList(queryString.get(0).split("\\("));
        List<String> toGetDBName = Arrays.asList(toGetTableName.get(0).split(" "));
        String tableName = Arrays.asList(toGetDBName.get(toGetDBName.size() - 1).split("\\.")).get(1);
        for (int i = 1; i < queryString.size(); i++) {
            List<String> colFormatList = Arrays.asList(queryString.get(i).strip().split(" "));
            columnNameList.add(new Column(colFormatList.get(0), null));
        }
        System.out.println(DatabaseOperations.createTable(tableName, columnNameList));
    }
}
