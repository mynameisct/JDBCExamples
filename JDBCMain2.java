package com.rapportsoft.co;

// STEP 1 - IMPORT STATEMENT
import java.sql.*;

public class JDBCMain2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/student1";
		String uname = "root";
		String pass = "root";
		
		int roll_no = 106;
		String name = "Atharva";
		
		String query = "INSERT INTO student1(roll_no,name) VALUES("+roll_no+",'"+name+ " ')";
		
		// STEP 2 - LOADING AND REGISTRATING DRIVERS
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// STEP 3 - ESTABLISH THE CONNECTION
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// STEP 4 - CREATE THE STATEMENT OBJECT
		Statement st = con.createStatement();
		
		// STEP 5 - EXECUTE THE QUERY
		int count = st.executeUpdate(query);
		
		// STEP 6 - PROCESS RESULT
		System.out.println(count+":Row/s Affected");
		
		st.close();
		
		con.close();

	}
}
