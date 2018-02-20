package com.trms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private final static Logger logger = Logger.getLogger(LogoutServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("doGet() : ENTERED");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		logger.info("doGet() : session == " + session.getAttribute("empid"));
		session.invalidate();

	
		// response.sendRedirect("../index.html");

		out.println("<head> <meta http-equiv='Refresh' content='2;url=index.html'>" + "</head>");
		out.print("You have been logged out");

		out.close();
		return;
		
		/*RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
		//rd.forward(request, response);
		if(rd == null) {
			logger.warn("doGet() : the requestDispatcher is null");
		}*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}