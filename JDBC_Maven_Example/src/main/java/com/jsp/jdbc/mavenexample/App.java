package com.jsp.jdbc.mavenexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args )
    {
    	try {
			//step1: load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step:2 Establish the Connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_dbs2", "root", "root");
			
			//Step:3 create statement3
			
			Statement st = conn.createStatement();
			
			//step4: Execute a query
			
			// int rowsInserted =st.executeUpdate("insert into student values(2, 'Tom', 70, 'cs')");
			 
			//int rowsUpdated=st.executeUpdate("update student set studentName='jerry' where studentId=1 ");
			
			int rowsDeleted=st.executeUpdate("");
			//step:5 process the result
			
			
			//System.out.println(rowsInserted);
			
			
			//System.out.println(rowsUpdated);
			
			System.out.println(rowsDeleted);
			
			//step:6 close the connection
			
			conn.close(); 
			
		} 
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
