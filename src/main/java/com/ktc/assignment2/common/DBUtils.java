package com.ktc.assignment2.common;

import java.sql.*;

public class DBUtils {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/ktc";

        return DriverManager.getConnection(url, "root", "");
    }
}
