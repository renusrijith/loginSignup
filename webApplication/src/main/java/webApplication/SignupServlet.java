package webApplication;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/signup.do")
public class SignupServlet  extends HttpServlet{
	
	
	
	
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			  	throws ServletException, java.io.IOException{
		
		  
		  
		 // PrintWriter out = response.getWriter();
//		 
//		  
		  
//		  String name =request.getParameter("name");
//		  String password =request.getParameter("password");
//		  request.setAttribute("name", name);
//		  request.setAttribute("password", password);
		  request.getRequestDispatcher("WEB-INF/Views/Signup.jsp").forward(request	, response);
		  

	  }
	  
	  
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			  	throws ServletException, java.io.IOException{
		 
		  String name =request.getParameter("name");
		  String password =request.getParameter("password");
		  String password1 =request.getParameter("password2");
		  
		 
		  if(password1.equals(password)){
			  //check whether the username already present
			  request.setAttribute("name", name);
			  request.setAttribute("password", password);
			  
			  DataServiceImpl service = new DataServiceImpl();
			  if(service.isUserNameAvailable(name)){
				  System.out.print("inside is user name ");
				  User user =new User(name,password);
				  if(service.addUser(user))
					  System.out.print("inside adduser ");
					request.getRequestDispatcher("WEB-INF/Views/Welcome.jsp").forward(request	, response);
			  }
			  else 
			  {
				  
				  request.setAttribute("errorMessage", "User name Unavailable");
				  request.getRequestDispatcher("WEB-INF/Views/Signup.jsp").forward(request	, response);
			  }
			  
		  }
		  else 
		  {
			  request.setAttribute("errorMessage", "Password mismatch");
			  request.getRequestDispatcher("WEB-INF/Views/Signup.jsp").forward(request	, response);
		  }
		  
		  
	  }
		
		  
		  

}
