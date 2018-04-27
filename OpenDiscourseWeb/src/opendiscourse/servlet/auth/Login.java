package opendiscourse.servlet.auth;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opendiscourse.dao.TopicService;
import opendiscourse.entity.Topic;
import opendiscourse.servlet.common.HomeServlet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 6085682488301638703L;
	private static final Logger LOGGER = Logger.getLogger(HomeServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Topic> topics = TopicService.all();
			request.setAttribute("topics", topics);
			request.getRequestDispatcher("WEB-INF/auth/Login.jsp").forward(request, response);
			
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			response.sendRedirect(request.getRequestURI());			
		}
		catch(IOException e) {
			
		}
	}

}
