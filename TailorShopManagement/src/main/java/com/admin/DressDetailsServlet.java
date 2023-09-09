package com.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DressDetailsServlet
 */
@WebServlet("/DressDetailsServlet")
public class DressDetailsServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String dresstype = request.getParameter("dresstype");
		String shoulder = request.getParameter("shoulder");
		String lengthoftop = request.getParameter("lengthoftop");
		String lengthofhand = request.getParameter("lengthofhand");
		String chest = request.getParameter("chest");
		String neck = request.getParameter("neck");
		String waist = request.getParameter("waist");
		String lengthoflower = request.getParameter("lengthoflower");
		String lengthofbottom = request.getParameter("lengthofbottom");
		String description = request.getParameter("description");
		String pattern = request.getParameter("dresspattern");
		String datetime = request.getParameter("dateTime");
		
		AdminDao adminDao = new AdminDao();
		int price = adminDao.getDressPrice(dresstype);
		int patternPrice = adminDao.getPatternPrice(pattern);
		System.out.println(price);
		int result = adminDao.dressDetails(name, dresstype, shoulder, lengthoftop, lengthofhand, chest, neck, waist,
				lengthoflower, lengthofbottom, description, price+patternPrice, datetime, pattern);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DressBill.jsp?username=" + name);
		dispatcher.forward(request, response);

	}

}
