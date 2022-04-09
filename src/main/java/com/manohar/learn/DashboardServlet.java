package com.manohar.learn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out =response.getWriter();
		HttpSession session =request.getSession(false);
		
		response.setContentType("text/html");
		out.print("<title>Dash board</title>");
		if(session!=null) {
			String userid=(String) session.getAttribute("key");
			String password=(String) session.getAttribute("key2");
			
			if(userid!=null&&password!=null) {
				out.print("Login successfully :"+userid);
				out.print("<a href='logout'>Logout</a>");
				 }
		}
		else {
			out.print("Kindly Login First");
		}

	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}