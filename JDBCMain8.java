// PROGRAM TO STORING IMAGE IN TABLE IN MYSQL
package com.rapportsoft.co;

// STEP 1 - IMPORT STATEMENTS
import java.sql.*;
import java.io.*;

public class JDBCMain8 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
	
	String url="jdbc:mysql://localhost:3306/student1";
	String uname="root";
	String pass="root";
	
	
	String query="insert into pictures3(id,images) values(?,?)";
	
	// STEP 2 - LOADING AND REGISTRATING DRIVERS
	Class.forName("com.mysql.cj.jdbc.Driver");//Loading and register Driver Class

	// STEP 3 - ESTABLISH THE CONNECTION
	Connection con=DriverManager.getConnection(url,uname,pass);
	
	// STEP 4 - CREATE STATEMENT OBJECT
	PreparedStatement pst=con.prepareStatement(query);

	FileInputStream fis=new FileInputStream("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");
	pst.setInt(1,1);
	pst.setBlob(2, fis,fis.available());

	// STEP 5 - EXECUTE THE QUERY
	pst.executeUpdate();

	// STEP 6 - PROCESS RESULT
	System.out.println("image added");

	pst.close(); 
	
	con.close();
	}
}