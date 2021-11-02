package mavendemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertedPreparedDemo {

	public static void main(String[] args) {
		Connection conn = null; // always initialize your local variables 
		try {
			//step 1 - Load the driver
			Class.forName("org.postgresql.Driver");
			
			//step 2 - Establish connection to the DB
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root");
			
			//Step 3 - Create a PreparedStatement
			//Statement stmt = conn.createStatement();
			String query = "insert into student_details values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			//Step 4 - Execute the statement
			int sId = 109;
			String sName = "Will";
			String sAddress = "Atlanta";
			int sMark = 60;
			
			pstmt.setInt(1, sId);
			pstmt.setString(2, sName);
			pstmt.setString(3, sAddress);
			pstmt.setInt(4, sMark);
			
			int rowsAffected = pstmt.executeUpdate();
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
