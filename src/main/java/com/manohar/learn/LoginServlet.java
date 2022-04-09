package com.manohar.learn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		String token= request.getParameter("userid");
		String token1=request.getParameter("password");
		
		///Add user in session once the login is done
		if(token.length()!=0&&token1.length()!=0) {
		HttpSession session = request.getSession();
		session.setAttribute("key", token);
		session.setAttribute("key2", token1);
		response.sendRedirect("dashboard");
		}
		else 
			out.print("Error while login");
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}