package com.qp.osql.logic;

import exception.InvalidQueryException;

import java.util.Arrays;
import java.util.List;

public class QueryParser {

    public void parseQuery(String userQuery){


    }

    public void databaseCreationQueryValidator(String userQuery) throws InvalidQueryException {
        List<String> queryString = Arrays.asList(userQuery.split(" "));
        isDatabaseQueryValid(userQuery, queryString);
        System.out.println("Validated!!!!");
        System.out.println(queryString.get(0));
        System.out.println(queryString.get(1));
        System.out.println(queryString.get(2));
        // createDatabase(queryString.get(2),null);
    }

    private void isDatabaseQueryValid(String userQuery, List<String> queryString) throws InvalidQueryException {
        if(queryString.size() != 3 || !queryString.get(0).equalsIgnoreCase("create") || !queryString.get(1).equalsIgnoreCase("database")){
            throw new InvalidQueryException("Create Database query is invalid");
        }
    }

    public void tableCreationQueryValidator(String userQuery) throws InvalidQueryException {
//        List<String> queryString = Arrays.asList(userQuery.split(" "));
        isCreateTableQueryValid(userQuery, queryString);

        // createTable(queryString.get(2),null);
    }

    private void isCreateTableQueryValid(String userQuery) {
        List<String> queryString = Arrays.asList(userQuery.split(" "));
    }

    public void selectTableQueryValidator(String userQuery) throws InvalidQueryException {
//        isQueryValid(userQuery);
    }

    public String queryValidator(String userQuery){
    return null;

    }

    public void extractQueryType(String userQuery) throws InvalidQueryException {
        if(userQuery.toUpperCase().startsWith(Consts.DATABASE_CREATION)){
            databaseCreationQueryValidator(userQuery);
        }else if (userQuery.toUpperCase().startsWith(Consts.TABLE_CREATION)){
            tableCreationQueryValidator(userQuery);
        }else if(userQuery.toUpperCase().startsWith(Consts.SELECTION_FROM_TABLE)){
            selectTableQueryValidator(userQuery);
        }else if (userQuery.toUpperCase().startsWith(Consts.INSERTION_INTO_TABLE)){
            queryValidator( userQuery);
        }
    }

    public void createTableStructure(String operationName){

    }


    public static void main(String[] args) {
        String query = "Create Database OurSQL";
        QueryParser qp = new QueryParser();
        try {
            qp.extractQueryType(query.strip());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
