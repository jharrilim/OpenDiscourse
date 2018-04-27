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
import opendiscourse.entity.User;
import opendiscourse.servlet.common.HomeServlet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Auth/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 6085682488301638703L;
	private static final Logger LOGGER = Logger.getLogger(HomeServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Topic> topics = TopicService.all();
			request.setAttribute("topics", topics);
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
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		TopicService.registerUser(user);
		request.getSession().setAttribute("user", user);
		try {
			response.sendRedirect(request.getRequestURI());			
		}
		catch(IOException e) {
			
		}
	}

}
