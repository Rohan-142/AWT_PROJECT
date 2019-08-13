package com.maren.DemosecB.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterCtrl
 */
@WebServlet("/ParameterCtrl")
public class ParameterCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieve request parameter
		String name=request.getParameter("txtName");  //getting the name from the html
		String pass=request.getParameter("pass");     //getting the password from the html
		PrintWriter out=response.getWriter();
		out.print("<b> Name <b> :"+ name);        //printing the name
		out.print("<br>");
		out.print("<b> Password <b> :"+ pass);	  //printing the password
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
