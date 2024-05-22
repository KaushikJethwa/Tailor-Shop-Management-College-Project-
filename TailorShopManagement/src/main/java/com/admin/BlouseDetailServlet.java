package com.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BlouseDetail
 */
@WebServlet("/BlouseDetailServlet")
public class BlouseDetailServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String shoulder = request.getParameter("shoulder");
		String lengthofblouse = request.getParameter("lengthofblouse");
		String lengthofhand = request.getParameter("lengthofhand");
		String chest = request.getParameter("chest");
		String neck = request.getParameter("neck");
		String waist = request.getParameter("waist");
		String description = request.getParameter("description");
		String datetime = request.getParameter("dateTime");
		String aster = request.getParameter("aster");
		System.out.println(datetime);
		String pattern = request.getParameter("pattern");
		AdminDao adminDao = new AdminDao();
		int price = 350;
		int patternPrice = adminDao.getPatternPrice(pattern);
		int asterPrice= adminDao.getAsterPrice(aster);
		int result = adminDao.blouseDetails(name, shoulder, lengthofblouse, lengthofhand, chest, neck, waist,
				description, price + patternPrice+asterPrice, datetime, pattern,aster);

		RequestDispatcher dispatcher = request.getRequestDispatcher("BlouseBill.jsp?username=" + name);
		dispatcher.forward(request, response);

	}

}
