package mavendemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertDemo {

	public static void main(String[] args) {
		
		Connection conn = null; // always initialize your local variables 
		try {
			//step 1 - Load the driver
			Class.forName("org.postgresql.Driver");
			
			//step 2 - Establish connection to the DB
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root");
			
			//Step 3 - Create a Statement
			Statement stmt = conn.createStatement();
			
			//Step 4 - Execute the statement
			int sId = 105;
			String sName = "Will";
			String sAddress = "Atlanta";
			int sMark = 60;
			
			String query = "insert into student_details values("+sId+",'"+sName+"','"+sAddress+"',"+sMark+")";	
			System.out.println(query);
			int rowsAffected = stmt.executeUpdate(query);
			System.out.println(rowsAffected + " inserted....");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
