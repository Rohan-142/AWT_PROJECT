import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
	
public class Login extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email"); //getting parameter-142
        String pass = request.getParameter("pass");   //getting parameter-142
        
        if(Validate.checkUser(email , pass)) //checking parameter through validate class-142
        {
            RequestDispatcher rs142 = request.getRequestDispatcher("Welcome");
            rs142.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs142 = request.getRequestDispatcher("index.html");
           rs142.include(request, response);
        }
    }  
}	