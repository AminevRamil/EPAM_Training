package com.epam.aminev;

import lombok.extern.slf4j.Slf4j;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class with JDBC demo that demonstrates understanding of how JDBC works.
 *
 * @author Aminev Ramil
 */
@Slf4j
public class Main {
    /**
     * Main entry point to demo that was did during lesson 17.
     *
     * @param args - input arguments. Not used.
     */
    public static void main(String[] args) {
        Service service = Service.getInstance();
        Scanner scanner = new Scanner(System.in);
        printHelp();
        boolean needToExit = false;
        while (!needToExit) {
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        service.printAllProducts();
                        break;
                    case 2:
                        service.searchByTitle();
                        break;
                    case 3:
                        service.updateTitle();
                        break;
                    case 4:
                        service.deleteRow();
                        break;
                    case 5:
                        service.insertRow();
                        break;
                    case 9:
                        printHelp();
                        break;
                    case 0:
                        needToExit = true;
                        break;
                    default:
                        log.error("There's no such option!");
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
                needToExit = true;
            }
        }
    }

    private static void printHelp() {
        log.info("Chose option:\n" +
                "1 - Show all rows from products\n" +
                "2 - Search row by title (using SQL search option like %_\n" +
                "3 - Update title by prod_id\n" +
                "4 - Delete row by prod_id\n" +
                "5 - Insert row\n" +
                "9 - Show this option set\n" +
                "0 - Exit\n" +
                "NOTE: all changes or new rows will be in the end of first option's output");
    }
}
