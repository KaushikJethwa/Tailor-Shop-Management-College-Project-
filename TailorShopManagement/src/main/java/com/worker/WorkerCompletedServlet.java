package com.worker;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WorkerCompletedServlet
 */
@WebServlet("/WorkerCompletedServlet")
public class WorkerCompletedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private WorkerDAO dao;
    
    @Override
    	public void init() throws ServletException {
    		dao = new WorkerDAO();
    		super.init();
    	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dateTime = request.getParameter("dateTime");
		String action = request.getParameter("action");
		Timestamp time = Timestamp.valueOf(dateTime);
		
		if(action.equals("dress")) {
			int result = dao.completeDress(time);
		}else if(action.equals("blouse")) {
			int result = dao.completeBlouse(time);
		}else if(action.equals("both")) {
			int result = dao.completeBoth(time);
		}
		
		response.sendRedirect("login.jsp");
	}

}
