package mavendemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDeleteDemo {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
			
			Statement stmt = conn.createStatement();
		
			int sId = 105;
			String query = "delete from student_details where stud_id="+sId;
			int rowsAffected = stmt.executeUpdate(query);
			System.out.println(rowsAffected + " deleted....");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
