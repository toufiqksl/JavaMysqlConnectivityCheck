/**
 * 
 */
package com.example.client;

/**
 * @author user11
 *
 */
import com.example.dbclass.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
 
public class JDBCSampleExample {
 
	public static void main(String[] argv) {
 
			try {
				selectRecordsFromDbUserTable();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
	}
 
	private static void selectRecordsFromDbUserTable() throws SQLException {
 
		DBConnection connection = new DBConnection();
 
		ResultSet result = null;
		String query = "SELECT * FROM PERSON ORDER BY ID";
		result = connection.executeQuery(query);
		 
		while (result.next()) {

			String id = result.getString("ID");
			String clientName = result.getString("CLIENTNAME");

			System.out.println("id : " + id);
			System.out.println("clientName : " + clientName);

		}
 
	}
 
}
