package com.maren.DemosecB.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestCtrl
 */
@WebServlet("/TestCtrl")
public class ScopeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("REQ" , "Request Scope");  //creating the request scope
		request.getSession().setAttribute("SES" , "Session Scope");  //creating the session scope
		getServletContext().setAttribute("APP", "Application Scope"); //creating the application scope
		request.getRequestDispatcher("/ScopeCtrl2").forward(request , response); //redirecting to a servlet using RequestDispatcher
		}

}
