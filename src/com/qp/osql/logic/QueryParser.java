package com.qp.osql.logic;

import com.qp.osql.common.Constant;
import com.qp.osql.exception.QueryException;

import java.util.Arrays;
import java.util.List;

public class QueryParser {

    public void parseQuery(String userQuery) {


    }

    public void databaseCreationQueryValidator(String userQuery) throws QueryException {
        List<String> queryString = Arrays.asList(userQuery.split(" "));
        isDatabaseQueryValid(userQuery, queryString);
        System.out.println("Validated!!!!");
        System.out.println(queryString.get(0));
        System.out.println(queryString.get(1));
        System.out.println(queryString.get(2));
        // createDatabase(queryString.get(2),null);
    }

    private void isDatabaseQueryValid(String userQuery, List<String> queryString) throws QueryException {
        if (queryString.size() != 3 || !queryString.get(0).equalsIgnoreCase("create")
                || !queryString.get(1).equalsIgnoreCase("database")) {
            throw new QueryException("Create Database query is invalid");
        }
    }

    public void tableCreationQueryValidator(String userQuery) throws QueryException {
//        List<String> queryString = Arrays.asList(userQuery.split(" "));
        isCreateTableQueryValid(userQuery, queryString);

        // createTable(queryString.get(2),null);
    }

    private void isCreateTableQueryValid(String userQuery) {
        List<String> queryString = Arrays.asList(userQuery.split(" "));
    }

    public void selectTableQueryValidator(String userQuery) throws QueryException {
//        isQueryValid(userQuery);
    }

    public String queryValidator(String userQuery) {
        return null;

    }

    public void extractQueryType(String userQuery) throws QueryException {
        if (userQuery.toUpperCase().startsWith(Constant.DATABASE_CREATION)) {
            databaseCreationQueryValidator(userQuery);
        } else if (userQuery.toUpperCase().startsWith(Constant.TABLE_CREATION)) {
            tableCreationQueryValidator(userQuery);
        } else if (userQuery.toUpperCase().startsWith(Constant.SELECTION_FROM_TABLE)) {
            selectTableQueryValidator(userQuery);
        } else if (userQuery.toUpperCase().startsWith(Constant.INSERTION_INTO_TABLE)) {
            queryValidator(userQuery);
        }
    }

    public void createTableStructure(String operationName) {

    }


    public static void main(String[] args) {
        String query = "Create Database OurSQL";
        QueryParser qp = new QueryParser();
        try {
            qp.extractQueryType(query.strip());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
