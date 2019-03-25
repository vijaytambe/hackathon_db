package com.qp.osql.logic;

import com.qp.osql.common.Constant;
import com.qp.osql.common.Operation;
import com.qp.osql.exception.QueryException;

import java.util.Arrays;
import java.util.List;

public class QueryParser {
    private String userQuery;

    public QueryParser(String userQuery) {
        this.userQuery = userQuery;
    }

    public void parseQuery(String userQuery) {


    }

    public void databaseCreationQueryValidator( ) throws QueryException {
        List<String> queryString = Arrays.asList(userQuery.split(" "));
        isDatabaseQueryValid(queryString);
        System.out.println("Validated!!!!");
        System.out.println(queryString.get(0));
        System.out.println(queryString.get(1));
        System.out.println(queryString.get(2));
    }

    private void isDatabaseQueryValid( List<String> queryString) throws QueryException {
        if (queryString.size() != 3 || !queryString.get(0).equalsIgnoreCase("create")
                || !queryString.get(1).equalsIgnoreCase("database")) {
            throw new QueryException("Create Database query is invalid");
        }
    }

    public void tableCreationQueryValidator( ) throws QueryException {


        List<String> queryString = Arrays.asList(userQuery.split(","));
        List<String> toGetTableName = Arrays.asList(queryString.get(0).split("\\("));
        List<String> toGetDBName = Arrays.asList(toGetTableName.get(0).split(" "));
        String dbName = Arrays.asList(toGetDBName.get(toGetDBName.size()-1).split("\\.")).get(0);
        String tableName = Arrays.asList(toGetDBName.get(toGetDBName.size()-1).split("\\.")).get(1);
        System.out.println(dbName + "  " + tableName);

    }

    private void isCreateTableQueryValid( ) {
        List<String> queryString = Arrays.asList(userQuery.split(" "));
    }

    public void selectTableQueryValidator( ) throws QueryException {
//        isQueryValid(userQuery);
    }

    public String queryValidator( ) {
        return null;

    }

    public int extractQueryType( ) throws QueryException {
        return Operation.getByQuery(userQuery).getId();
    }


    public void createTableStructure( ) {

    }


    public static void myMain(String query){
        if(query != null && !query.isBlank() && !query.isEmpty() ){
            try {
                new QueryParser(query).extractQueryType();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            // invalid sql
        }


    }
}
