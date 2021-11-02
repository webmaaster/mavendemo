package mavendemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//step 1 - Load the driver in the memory
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver is Loaded.... ");
			
			//step 2 - Establish connection to the database,  
			// connection url - protocol, ipaddress, portnumber
			// username of DB
			// password of DB
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
			if(conn != null) {
				System.out.println("Established connection to DB....");
			}
			//step 3 - Create a Statement
			Statement stmt = conn.createStatement();
			
			//step 4 - Execute the statement
			String query = "select * from student_details";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println("Student Id:" + rs.getInt(1));
				System.out.println("Student Name:" + rs.getString(2));
				System.out.println("Student Address:" + rs.getString(3));
				System.out.println("Student Mark:" + rs.getInt(4));
				System.out.println("---------------------------------");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
