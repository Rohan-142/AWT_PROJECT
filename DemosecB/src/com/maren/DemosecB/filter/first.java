package com.maren.DemosecB.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class first extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
     {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        out.println("Wellcome " + user);
     }
}