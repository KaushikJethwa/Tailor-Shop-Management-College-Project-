package com.admin;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailBlouseServlet
 */
@WebServlet("/EmailBlouseServlet")
public class EmailBlouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String host = "smtp.gmail.com";
		String username = "jethwakaushik4@gmail.com";
		String password = "uqtetdpghzsfcwyx";
		String email = request.getParameter("email");
		String name= request.getParameter("username");
		EmailSender emailSender= new EmailSender();
	


		Properties props = System.getProperties();
		props.setProperty(host, host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Create a Session object
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a new MimeMessage
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(username));
			// Set the recipient email address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

			// Set the subject
			message.setSubject("Bill");

			// Create the HTML content with the dynamically generated table
			
				String htmlContent=emailSender.createBlouseHtmlTable(name);
				message.setContent(htmlContent, "text/html");
			
			

			// Send the email
			Transport.send(message);

			System.out.println("Email sent successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
		dispatcher.forward(request, response);

	}

}
