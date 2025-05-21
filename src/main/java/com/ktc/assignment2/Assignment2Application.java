package com.ktc.assignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class Assignment2Application {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		SpringApplication.run(Assignment2Application.class, args);

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
