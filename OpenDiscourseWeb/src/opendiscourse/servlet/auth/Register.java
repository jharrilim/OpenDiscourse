package opendiscourse.servlet.auth;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opendiscourse.dao.TopicService;
import opendiscourse.entity.User;
import opendiscourse.servlet.topics.AddTopic;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Auth/Register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 6502265981579364510L;
	private static final Logger LOGGER = Logger.getLogger(AddTopic.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			LOGGER.log(Level.INFO, ()-> "Serving Registration Page.");
			request.getRequestDispatcher("/WEB-INF/Registration.jsp").forward(request, response);
		} catch (IOException | ServletException e) {
			LOGGER.log(Level.SEVERE, "Could not get registration page.", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String password = request.getParameter("password");
		if (!password.equals(request.getParameter("confirmPassword"))) {
			request.setAttribute("error", "Passwords do not match.");
			doGet(request, response);
			return;
		}

		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(password);
		user.setEmail(request.getParameter("email"));
		TopicService.registerUser(user);
		request.getSession().setAttribute("user", user);
		try {
			response.sendRedirect(request.getRequestURI());	
		}
		catch(IOException e) {
			LOGGER.log(Level.SEVERE, () -> "Could not redirect to: " + request.getRequestURI());
		}
	}

}
