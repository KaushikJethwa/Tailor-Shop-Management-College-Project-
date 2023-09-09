package com.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DressBlouseServlet
 */
@WebServlet("/DressBlouseServlet")
public class DressBlouseServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String dresstype = request.getParameter("dresstype");
		String dressshoulder = request.getParameter("shoulder");
		String dresslengthoftop = request.getParameter("lengthoftop");
		String dresslengthofhand = request.getParameter("lengthofdresshand");
		String dresschest = request.getParameter("chest");
		String dressneck = request.getParameter("neck");
		String dresswaist = request.getParameter("waist");
		String dresslengthoflower = request.getParameter("lengthoflower");
		String dresslengthofbottom = request.getParameter("lengthofbottom");
		String dressdescription = request.getParameter("description");
		String dresspattern = request.getParameter("dresspattern");
		String blouseshoulder = request.getParameter("shoulder");
		String blouselengthofblouse = request.getParameter("lengthofblouse");
		String blouselengthofhand = request.getParameter("lengthofblousehand");
		String blousechest = request.getParameter("chest");
		String blouseneck = request.getParameter("neck");
		String blousewaist = request.getParameter("waist");
		String blousedescription = request.getParameter("description");
		String blousepattern = request.getParameter("blousepattern");
		String datetime = request.getParameter("dateTime");
		AdminDao adminDao = new AdminDao();
		int dressprice = adminDao.getDressPrice(dresstype);
		int dressPatternPrice = adminDao.getPatternPrice(dresspattern);
		int blouseprice = 350;
		int blousePatternPrice = adminDao.getPatternPrice(blousepattern);
		int result = adminDao.dressBlouseBoth(name, dresstype, dressshoulder, dresslengthofhand, dresslengthoftop,
				dresschest, dressneck, dresswaist, dresslengthoflower, dresslengthofbottom, dressprice+dressPatternPrice, dresspattern,
				blouseshoulder, blousechest, blousewaist, blouseneck, blouselengthofblouse, blouselengthofblouse,
				blouseprice+blousePatternPrice, blousepattern, datetime, blousedescription);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dressblousebill.jsp?username=" + name);
		dispatcher.forward(request, response);
	}

}
