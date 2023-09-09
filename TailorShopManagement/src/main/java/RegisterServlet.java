

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password= request.getParameter("password");
		String name=request.getParameter("name");
		String contact=request.getParameter("contactno");
		
		LoginDao dao1= new LoginDao();
		if(!dao1.isUsernameExists(username)) {
			int register= dao1.register(username, password, name, contact);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("Error.jsp");
		}
	}

}
