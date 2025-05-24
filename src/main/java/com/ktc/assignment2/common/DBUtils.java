package com.ktc.assignment2.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/ktc";

        return DriverManager.getConnection(url, "root", "");
    }
}
