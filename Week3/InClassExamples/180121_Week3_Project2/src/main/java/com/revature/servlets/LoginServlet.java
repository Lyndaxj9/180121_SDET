package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.ValidateLogin;
import com.revature.util.HtmlTemplates;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		if(!session.isNew()){
			out.println("<h1>Stop being weird.</h1>");
		}
		else if(ValidateLogin.validate(username, password)){
			session.setAttribute("username", username);
			RequestDispatcher rd = request.getRequestDispatcher("user/userhome.html");
			rd.forward(request, response);
		}else{
			session.invalidate();
			
			out.print("<h1>INVALID CREDENTIALS</h1>");
			HtmlTemplates.goBackButton(out);
			
		}
		
	}

}
