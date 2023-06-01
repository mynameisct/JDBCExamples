package com.rapportsoft.co;

// STEP 1 - IMPORT STATEMENT
import java.sql.*;

public class JDBCMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost/student1";
		String uname = "root";
		String pass = "root";
		
		String query = "SELECT * FROM student1";
		
		// STEP 2 - LOADING AND REGISTRATING DRIVERS
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		// STEP 3 - ESTABLISH THE CONNECTION
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// STEP 4 - CREATE THE STATEMENT OBJECT
		Statement st = con.createStatement();
		
		// STEP 5 - EXECUTE THE QUERY
		ResultSet rs = st.executeQuery(query);
		
		String userdata = " ";
		
		// STEP 6 - PROCESS RESULT
		while(rs.next())
		{
			userdata = rs.getInt(1) + " "+ rs.getString(2);
            System.out.println(userdata);
		}
		
		st.close();
		
		con.close();
	
	}
 }
