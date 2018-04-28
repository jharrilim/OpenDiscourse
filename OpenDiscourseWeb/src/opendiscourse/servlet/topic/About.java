package opendiscourse.servlet.topic;

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
 * Servlet implementation class MostRecent
 */
@WebServlet("/About")
public class About extends HttpServlet {

	private static final long serialVersionUID = -8890719371893643775L;
	private static final Logger LOGGER = Logger.getLogger(Home.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/WEB-INF/About.jsp").forward(request, response);

		} catch (ServletException | IOException e) {
			try {
				response.sendRedirect(request.getContextPath() + "/");
			} catch (IOException e1) {
				LOGGER.log(Level.SEVERE, "Malformed Response", e1);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
