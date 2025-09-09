package org.transportadora.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    private static final String URL = "jdbc:mysql://localhost:3306/transportadora?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "mysqlPW";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

}