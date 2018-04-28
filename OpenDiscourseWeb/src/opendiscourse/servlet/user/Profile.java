package opendiscourse.servlet.user;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opendiscourse.servlet.common.Home;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {

	private static final long serialVersionUID = -6980155939102067260L;
	private static final Logger LOGGER = Logger.getLogger(Home.class.getName());
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/WEB-INF/Profile.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.log(Level.WARNING, "Could not display the profile page.", e);
			try {
				response.sendRedirect(request.getContextPath() + "/");
			} catch (IOException e1) {
				LOGGER.log(Level.SEVERE, "Could not redirect to: " + request.getContextPath() + "/", e);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
