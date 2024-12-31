package com.jsp.servlet.employeedb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateEmployeeServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int employeeId=Integer.parseInt(req.getParameter("employeeId"));
		String employeeName=req.getParameter("employeeName");
		
		//JDBC logic
		
		Connection conn = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_employeedb","root","root"); //conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_employeedb"?user=root&password=root);
		
		PreparedStatement pst=conn.prepareStatement("update employee set employeeName=? where employeeId=?");
		
		
		pst.setString(1, employeeName);
		pst.setInt(2,employeeId);
		
		
		int rowsUpdated=pst.executeUpdate();
		
		PrintWriter pw=res.getWriter();
		
		if(rowsUpdated>0) {
			pw.print("<h1>" +rowsUpdated+" data updated </h1>");
		} else {
			pw.print("<h1> data not updated</h1>");
		}
		
	} catch (ClassNotFoundException |SQLException e) {
		e.printStackTrace();
	}finally { 
	if(conn!=null) {
		try {
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	}

	}

}
