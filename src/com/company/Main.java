package com.company;

import com.qp.osql.Run;

import java.util.Scanner;

public class Main {

    private static String command;
    public static void main(String[] args) {

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
        System.out.println("Executing command --> " + command);
    }

    private static void printInro() {
        System.out.println("Welcome to OSQL!");
        System.out.println("Press Help for commands");
    }

    static private void takeCommand() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String command = myObj.nextLine();
        Main.command = command;
        Run.runCommand(command);
    }
}
