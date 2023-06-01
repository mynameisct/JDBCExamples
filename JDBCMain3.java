// EXAMPLE -1 OF PREPAREDSTATEMENT INTERFACE THAT INSERTS THE RECORD

package com.rapportsoft.co;

// STEP 1 - IMPORT STATEMENT
import java.sql.*;

public class JDBCMain3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/student1";
		String uname = "root";
		String pass = "root";
		
		int roll_no = 107;
		String name = "Sanket";
		
		String query = "INSERT INTO student1(roll_no,name) VALUES (?,?)";
		
		
		// STEP 2 - LOADING AND REGISTRATING DRIVERS
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// STEP 3 - ESTABLISH THE CONNECTION
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// STEP 4 - CREATE THE STATEMENT OBJECT
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,roll_no);
		pst.setString(2,name);
		
		// STEP 5 - EXECUTE THE QUERY
		int count = pst.executeUpdate();
		
		// STEP 6 - PROCESS RESULT
		System.out.println(count+":Row/s Affected");
		
		pst.close();
		
		con.close();

	}

}
