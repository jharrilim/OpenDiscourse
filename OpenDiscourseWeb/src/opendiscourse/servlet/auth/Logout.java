package opendiscourse.servlet.auth;

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
 * Servlet implementation class Logout
 */
@WebServlet("/Auth/Logout")
public class Logout extends HttpServlet {

    private static final long serialVersionUID = 2202203044463331313L;
	private static final Logger LOGGER = Logger.getLogger(Home.class.getName());
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("user", null);
		try {
			response.sendRedirect(request.getContextPath() + "/");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Could not redirect to home page.", e);
		}
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
