package com.ktc.assignment2.database;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootTest
public class DatabaseConnTest {

    @Test
    @DisplayName("db 연결 테스트")
    void test1() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost/ktc";

        Connection conn = DriverManager.getConnection(url, "root", "");
    }

    @Test
    @DisplayName("테이블 생성 쿼리 테스트")
    void test2() throws SQLException, ClassNotFoundException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost/ktc";

        Connection conn = DriverManager.getConnection(url, "root", "");

        Statement statement = conn.createStatement();
        BufferedReader reader = new BufferedReader(new FileReader("schedule.sql"));

        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        String[] queries = sb.toString().split(";");

        for (int i = 0; i < queries.length - 1; i++) {
            statement.execute(queries[i]);
        }
    }
}
