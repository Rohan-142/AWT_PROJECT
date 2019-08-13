package com.maren.DemosecB.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class configCtrl
 */
@WebServlet(
		urlPatterns = { "/configCtrl" }, 
		initParams = { 
				@WebInitParam(name = "UNIV", value = "CUTM"), //creating the parameter1
				@WebInitParam(name = "LOC", value = "BHUBANESWAR") //creating the parameter2
		})
public class configCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String univ = config.getInitParameter("UNIV"); //getting the parameter1
		String loc = config.getInitParameter("LOC");  //getting the parameter2
		response.getWriter().append("University is:" + univ + "At:"+loc); //printing the parameter and the values
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
	}

//}
