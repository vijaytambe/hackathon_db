package com.company;

import com.qp.osql.Run;
import com.qp.osql.exception.QueryException;

import java.util.Scanner;

public class Main {

    private static String command;

    public static void main(String[] args) throws QueryException {

        do {

            if (commandIsNotNullOREmpty(command == null, command == "")) {
                printInro();
            }

            takeCommand();


            if (commandIsNotNullOREmpty(command != null, !command.equals(""))) {
                if (checkAndExecuteCommand()) break;
            }

        } while (true);
    }

    private static boolean commandIsNotNullOREmpty(boolean b, boolean b2) {
        return b || b2;
    }

    private static boolean checkAndExecuteCommand() {
        if ("exit".equals(command)) {
            return true;
        } else {
            executeCommand();
        }
        return false;
    }

    private static void executeCommand() {
        System.out.print("oSQL--> ");
    }

    private static void printInro() {
        System.out.println("Welcome to OSQL!");
        System.out.println("Press Help for commands");
        System.out.println("Press Select for show all DB");
    }

    static private void takeCommand() throws QueryException {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String command = myObj.nextLine();
        Main.command = command;
        Run.runCommand(command);
//        Run.runCommand("create database qp_db");
    }
}
