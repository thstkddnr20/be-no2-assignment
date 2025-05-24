package com.ktc.assignment2.common;

import java.sql.*;

public class DBUtils {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/ktc";

        return DriverManager.getConnection(url, "root", "");
    }

    public static void closeConnection(ResultSet rs, PreparedStatement pstmt, Connection connection) {
        if (rs != null) try { rs.close(); } catch (SQLException e) {}
        if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
        if (connection != null) try { connection.close(); } catch (SQLException e) {}
    }
}
