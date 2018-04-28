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
import opendiscourse.servlet.common.Home;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Auth/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 6085682488301638703L;
	private static final Logger LOGGER = Logger.getLogger(Home.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
			
		} catch (ServletException | IOException e) {
			try {
				response.getWriter().append("500: Server error;\n" + e.getMessage());
			} catch (IOException e1) {
				LOGGER.log(Level.SEVERE, "Malformed Response", e1);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info(()-> "Attempting to authenticate user.");
		User user = TopicService.authenticateUser(
				request.getParameter("username"), 
				request.getParameter("password"));
		if (user != null) {
			LOGGER.info(()-> "Successfully authenticated user.");
			request.getSession().setAttribute("user", user);
			try {
				response.sendRedirect(request.getContextPath() + "/");
				//request.getRequestDispatcher("/WEB-INF/MostRecent.jsp").forward(request, response);
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "Could not send user back to home page after login.", e);
			}
		}
		else {
			LOGGER.info(()-> "Could not authenticate user.");
			request.setAttribute("error", "Invalid login. Please try again.");
			doGet(request, response);
		}
	}

}
