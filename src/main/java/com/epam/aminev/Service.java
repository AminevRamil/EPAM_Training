package com.epam.aminev;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.Scanner;

/**
 * A singleton {@code Service} class that perform connection to database
 * and execute queries which user chose in Main class.
 *
 * @author Aminev Ramil
 */
@Slf4j
public class Service {
    private static Service instance;
    private Connection connection;
    private Scanner scanner;

    private PreparedStatement gelAllQuery;
    private PreparedStatement searchByTitleQuery;
    private PreparedStatement updateTitleQuery;
    private PreparedStatement deleteRowQuery;
    private PreparedStatement insertRowQuery;

    /**
     * Create new Service instance of {@code Service} with RDBMS connection
     * using JDBC and precompiled statements.
     */
    private Service() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dell-store",
                    "postgres",
                    "957321");
            gelAllQuery = connection.prepareStatement("select * from products;");
            searchByTitleQuery = connection.prepareStatement("select * from products where title like ?;");
            updateTitleQuery = connection.prepareStatement("update products set title=? where prod_id=?;");
            deleteRowQuery = connection.prepareStatement("delete from products where prod_id=?;");
            insertRowQuery = connection.prepareStatement("insert into products " +
                    "values (nextval('products_prod_id_seq'::regclass), ?, ?, ?, ?, ?, ?);");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        scanner = new Scanner(System.in);
    }

    /**
     * Create instance of Service if necessary.
     *
     * @return instance of Service
     */
    public static Service getInstance() {
        if (instance == null) instance = new Service();
        return instance;
    }

    /**
     * Executes statement that gives all rows in products table.
     */
    public void printAllProducts() {
        try {
            ResultSet rs = gelAllQuery.executeQuery();
            printResults(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Executes statement that search specified title in product table.
     */
    public void searchByTitle() {
        log.info("Input title to search:");
        String title = scanner.nextLine();
        try {
            searchByTitleQuery.setString(1, title);
            ResultSet rs = searchByTitleQuery.executeQuery();
            printResults(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Execute statement that update row with specified prod_id in product table.
     */
    public void updateTitle() {
        log.info("Input id to replace title field:");
        int id = scanner.nextInt();

        // Дебильная специфика работы на которую я потратил около часа
        // https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
        scanner.nextLine();

        log.info("Input new title:");
        String title = scanner.nextLine();
        try {
            updateTitleQuery.setString(1, title);
            updateTitleQuery.setInt(2, id);
            updateTitleQuery.execute();
            log.info("Title updated successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Execute statement that delete row with specified prod_id in product table.
     */
    public void deleteRow() {
        log.info("Input id of row to delete:");
        int id = scanner.nextInt();
        try {
            deleteRowQuery.setInt(1, id);
            deleteRowQuery.execute();
            log.info("Row deleted successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Execute statement that inserts new row in product table.
     */
    public void insertRow() {
        try {
            log.info("Input category for row to insert:");
            int category = Integer.parseInt(scanner.nextLine());
            log.info("Input title for row to insert:");
            String title = scanner.nextLine();
            log.info("Input actor for row to insert:");
            String actor = scanner.nextLine();
            log.info("Input price for row to insert:");
            int price = Integer.parseInt(scanner.nextLine());
            log.info("Input special for row to insert:");
            int special = Integer.parseInt(scanner.nextLine());
            log.info("Input common_prod_id for row to insert:");
            int common_prod_id = Integer.parseInt(scanner.nextLine());
            insertRowQuery.setInt(1, category);
            insertRowQuery.setString(2, title);
            insertRowQuery.setString(3, actor);
            insertRowQuery.setInt(4, price);
            insertRowQuery.setInt(5, special);
            insertRowQuery.setInt(6, common_prod_id);
            insertRowQuery.execute();
            log.info("Row inserted successful");
        } catch (SQLException | NumberFormatException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Prints result fetch into logs
     *
     * @param rs is a ResultSet given by RDBMS
     * @throws SQLException if a database access error occurs
     */
    private void printResults(ResultSet rs) throws SQLException {
        int rowCounter = 0;
        log.info("prod_id|category|       title       |       actor       | price |special|common_prod_id");
        while (rs.next()) {
            rowCounter++;
            log.info(String.format("%-7d|%-8d|%-19s|%-19s|%-7.2f|%-7d|%d",
                    rs.getInt("prod_id"),
                    rs.getInt("category"),
                    rs.getString("title"),
                    rs.getString("actor"),
                    rs.getBigDecimal("price"),
                    rs.getShort("special"),
                    rs.getInt("common_prod_id")));
        }
        // Немного костыльный способ, но другого способа
        // проверить наличие записей в выборке я не нашёл.
        if (rowCounter == 0) {
            log.info("No rows found");
        }
    }
}
