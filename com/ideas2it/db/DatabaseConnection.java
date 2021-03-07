package com.ideas2it.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used to connect with database 
 */
public class DatabaseConnection {
    static Connection connection = null;

    /**
     * getConnection is used to establish connection with the database
     * @return connection
     */ 
    public static Connection getConnection() {
        if (null == connection) {
            try {
                return DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/EmployeeManagement",
                        "root","root123");
            } catch (SQLException exception) {
                throw new RuntimeException("Unable to connect to the database",
                        exception);
            }
        }
        return connection;
    }
}