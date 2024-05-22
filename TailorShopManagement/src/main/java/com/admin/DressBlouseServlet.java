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
		String dresspattern = request.getParameter("dresspattern");
		String blouseshoulder = request.getParameter("shoulder");
		String blouselengthofblouse = request.getParameter("lengthofblouse");
		String blouselengthofhand = request.getParameter("lengthofblousehand");
		String blousechest = request.getParameter("chest");
		String blouseneck = request.getParameter("neck");
		String blousewaist = request.getParameter("waist");
		String description = request.getParameter("description");
		String blousepattern = request.getParameter("blousepattern");
		String datetime = request.getParameter("dateTime");
		String dressAster=request.getParameter("dressAster");
		String blouseAster = request.getParameter("blouseAster");
		AdminDao adminDao = new AdminDao();
		int dressprice = adminDao.getDressPrice(dresstype);
		int dressPatternPrice = adminDao.getPatternPrice(dresspattern);
		int blouseprice = 350;
		int dressAsterPrice = adminDao.getAsterPrice(dressAster);
		int blouseAsterPrice = adminDao.getAsterPrice(blouseAster);
		int blousePatternPrice = adminDao.getPatternPrice(blousepattern);
		int result = adminDao.dressBlouseBoth(name, dresstype, dressshoulder, dresslengthofhand, dresslengthoftop,
				dresschest, dressneck, dresswaist, dresslengthoflower, dresslengthofbottom, dressprice+dressPatternPrice+dressAsterPrice, dresspattern,
				blouseshoulder, blousechest, blousewaist, blouseneck, blouselengthofblouse, blouselengthofhand,
				blouseprice+blousePatternPrice+blouseAsterPrice, blousepattern, datetime, description,dressAster,blouseAster);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dressblousebill.jsp?username=" + name);
		dispatcher.forward(request, response);
	}

}
