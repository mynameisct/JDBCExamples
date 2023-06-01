//EXAMPLE OF PREPAREDSTATEMENT TO INSERT RECORDS FROM USER INPUT VIA CONSOLE USING BUFFEREDREADER CLASS METHODS

package com.rapportsoft.co;

import java.io.*;

// STEP 1 - IMPORT STATEMENT
import java.sql.*;

public class JDBCMain6 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		
		String url = "jdbc:mysql://localhost:3306/student1";
		String uname = "root";
		String pass = "root";
		
		String query = "INSERT INTO student1(roll_no,name) VALUES(?,?)";
		
		//  STEP 2 - LOADING AND REGISTRATING DRIVERS
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// STEP 3 - ESTABLISH THE CONNECTION
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// STEP 4 - CREATE THE STATEMENT OBJECT
		PreparedStatement pst = con.prepareStatement(query);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the Roll Number: ");
		int roll_no = Integer.parseInt(br.readLine());
		
		System.out.println("Enter Name: ");
		String name = br.readLine();
		
		pst.setInt(1, roll_no);
		pst.setString(2, name);
		
		// STEP 5 - EXECUTE THE QUERY
		int count = pst.executeUpdate();
		
		// STEP 6 - PROCESS RESULT
		System.out.println(count+":Row/s Affected");
		
		pst.close();
		
		con.close();

	}

}
