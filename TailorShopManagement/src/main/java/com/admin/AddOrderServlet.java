package com.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name=request.getParameter("name");
		String contact = request.getParameter("contact");
		String address= request.getParameter("address");
		String email= request.getParameter("email");
		String worker= request.getParameter("workertype");
		String cloth= request.getParameter("cloth");
		String datetime= request.getParameter("dateTime");
		AdminDao adminDao = new AdminDao();
		int detail=adminDao.addOrder(name, contact, address, email, worker, cloth,datetime);
		System.out.println("order added successfully");
		if(cloth.equals("dress")) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("dressdetails.jsp?username=" +name+ "&dateTime=" +datetime);
			dispatcher.forward(request, response);
		}
		else if(cloth.equals("blouse")) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("blousedetails.jsp?username="+name+ "&dateTime=" +datetime);
			dispatcher.forward(request, response);
		}
		else if(cloth.equals("both")){
			RequestDispatcher dispatcher=request.getRequestDispatcher("dressblousedetails.jsp?username=" +name+ "&dateTime=" +datetime);
			dispatcher.forward(request, response);
		}
	}

}
