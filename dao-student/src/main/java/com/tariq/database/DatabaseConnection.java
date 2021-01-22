package com.tariq.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static Connection dbConnection() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental", "postgres", "");
			return conn;
		}  catch (SQLException e) {
	        System.out.println("Connection failure.");
	        e.printStackTrace();
	    }
		return null;
	}
}
