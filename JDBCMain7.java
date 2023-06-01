// EXAMPLE OF PREPAREDSTATEMENT TO INSERT RECORDS USING CALLABLE STATEMENT

package com.rapportsoft.co;

// STEP 1 - IMPORT STATEMENT
import java.sql.*;

public class JDBCMain7 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/for_stored";
		String uname = "root";
		String pass = "root";
		
		// STEP 2 - LOADING AND REGISTRATING DRIVERS
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// STEP 3 - ESTABLISH THE CONNECTION
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// STEP 4 - CREATING THE STATEMENT OBJECT
		CallableStatement cst = con.prepareCall("{CALL A}");
		
		// STEP 5 - EXECUTE THE QUERY
		ResultSet rs = cst.executeQuery();
		
		// STEP 6 - PROCESS RESULT
		while(rs.next())
		{
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
		
		cst.close();
		
		con.close();
	}
}
