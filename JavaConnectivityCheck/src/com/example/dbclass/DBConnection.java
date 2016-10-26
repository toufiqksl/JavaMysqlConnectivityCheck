package com.example.dbclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

	Connection connection = null;
	Statement statement = null;

	public DBConnection() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:sampleDB","DBSNMP","admin");
			statement = connection.createStatement();
		} catch (Exception ex) {
			System.out.println("Execption is=" + ex);
		}
	}

	public ResultSet executeQuery(String query) {
		ResultSet result = null;
		try {
			result = statement.executeQuery(query);
		} catch (Exception ex) {

		}
		return result;
	}
}
