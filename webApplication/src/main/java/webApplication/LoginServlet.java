package webApplication;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/login.do")
public class LoginServlet  extends HttpServlet{
	
	
	
	
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			  	throws ServletException, java.io.IOException{
		
		  
		  
		 // PrintWriter out = response.getWriter();
//		 
//		  
		  
//		  String name =request.getParameter("name");
//		  String password =request.getParameter("password");
//		  request.setAttribute("name", name);
//		  request.setAttribute("password", password);
		  request.getRequestDispatcher("WEB-INF/Views/Login.jsp").forward(request	, response);
		  

	  }
	  
	  
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			  	throws ServletException, java.io.IOException{
//		 UserValidationService service = new UserValidationService();
//		  String name =request.getParameter("name");
//		  String password =request.getParameter("password");
//		  
//		  if(service.isValidUser(name, password)){
//			  request.setAttribute("name", name);
//			  request.setAttribute("password", password);
//			  request.getRequestDispatcher("WEB-INF/Views/Welcome.jsp").forward(request	, response);
//		  }
		  
		  
		  DataServiceImpl service= new DataServiceImpl();
		  String name =request.getParameter("name");
		  String password =request.getParameter("password");
		  
		  User user=service.loginUser(name, password);
		  if(user!=null)
		  {
			  request.setAttribute("name", user.getUsername());
			  request.getRequestDispatcher("WEB-INF/Views/Welcome.jsp").forward(request	, response);
			  
		  }
		  
		  else 
		  {
			  request.setAttribute("errorMessage", "Invalid credentials");
			  request.getRequestDispatcher("WEB-INF/Views/Login.jsp").forward(request	, response);
		  }
	  }
		  
		  
}
