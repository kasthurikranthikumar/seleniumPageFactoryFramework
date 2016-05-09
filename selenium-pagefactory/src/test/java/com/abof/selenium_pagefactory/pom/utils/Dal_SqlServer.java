package com.abof.selenium_pagefactory.pom.utils;
import java.sql.*;
public class Dal_SqlServer {

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

	public void dbConn(String url, String userName, String Passwd) {

		// Load the postgres driver dynamically

		Connection conn;
		Statement stmt;
		ResultSet rs = null;

		try {

			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, userName, Passwd);
			// System.out.println("Connected to database");

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from property");

			while (rs.next()) {
				String sqlrs = rs.getString(1);
				System.out.println(sqlrs);
			}
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Connection closed");
	}

	public ResultSet DBConnection_WhereClause(String Server, String DataBase, String UserName, String Password,
			String Query, String WhereClause) {
		ResultSet rs = null;
		try {
			// Loading the required JDBC Driver class
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Creating a connection to the database
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://" + Server + ";database=" + DataBase + ";",
					UserName, Password);
			// Executing SQL query and fetching the result
			PreparedStatement pt = conn.prepareStatement(Query);
			pt.setString(1, WhereClause);
			pt.execute();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return rs;
	}
}
