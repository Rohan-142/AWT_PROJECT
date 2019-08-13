package com.maren.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/PreparedStatement")
public class Login extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		
		// Connect to mysql and verify username password-142
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 // loading the driver-142
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3360/test", "root", "root");
		java.sql.PreparedStatement ps= c.prepareStatement("select username,pass from student where userName=? and pass=?");
		 ps.setString(1, un);
		 ps.setString(2, pw);
		
		ResultSet rs =  ps.executeQuery();
		 
		while (rs.next()) {
			response.sendRedirect("success.jsp");
			return;
		}
		response.sendRedirect("error.jsp");
		
		return; 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
