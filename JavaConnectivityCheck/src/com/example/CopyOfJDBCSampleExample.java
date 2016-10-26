/**
 * 
 */
package com.example;

/**
 * @author user11
 *
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class CopyOfJDBCSampleExample {
 
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:sampleDB";
	private static final String DB_USER = "DBSNMP";
	private static final String DB_PASSWORD = "admin";
 
	public static void main(String[] argv) {
 
		try {
 
			selectRecordsFromDbUserTable();
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
	}
 
	private static void selectRecordsFromDbUserTable() throws SQLException {
 
		Connection dbConnection = null;
		Statement statement = null;
 
		String selectTableSQL = "SELECT ID, CLIENTNAME from PERSON";
 
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
 
			System.out.println(selectTableSQL);
 
			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);
 
			while (rs.next()) {
 
				String id = rs.getString("ID");
				String clientName = rs.getString("CLIENTNAME");
 
				System.out.println("id : " + id);
				System.out.println("clientName : " + clientName);
 
			}
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (statement != null) {
				statement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
 
	}
 
	private static Connection getDBConnection() {
 
		Connection dbConnection = null;
 
		try {
 
			Class.forName(DB_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
 
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 
	}
 
}
