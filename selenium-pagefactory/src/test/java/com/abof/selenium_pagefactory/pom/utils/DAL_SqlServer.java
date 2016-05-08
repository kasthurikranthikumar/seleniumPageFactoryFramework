package com.abof.selenium_pagefactory.pom.utils;

import java.sql.*;

public class DAL_SqlServer {

	public static void connect() throws SQLException {
		String connectinString = "jdbc:sqlserver://localhost:1433;databaseName=COMPNAME;user=admin;password=admin";
		// com.microsoft.sqlserver.jdbc.SQLServerDriver
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(connectinString);
			System.out.println(connection.isClosed());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
