
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		LoginDao dao = new LoginDao();
		String type = dao.login(username, pass);
		if (type.equals("admin")) {
			request.getSession().setAttribute("username", username);
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
			dispatcher.forward(request, response);
		} else if(type.equals("worker")){
			request.getSession().setAttribute("username", username);
			RequestDispatcher dispatcher = request.getRequestDispatcher("worker.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("Error.jsp");
		}

	}
}