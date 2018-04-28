package opendiscourse.servlet.topic;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opendiscourse.entity.Topic;
import opendiscourse.entity.User;
import opendiscourse.guard.AuthGuard;
import opendiscourse.dao.TopicService;

@WebServlet("/Topics/New")
public class AddTopic extends HttpServlet {

	private static final long serialVersionUID = 5947926535456029423L;
	private static final Logger LOGGER = Logger.getLogger(AddTopic.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		if(!AuthGuard.isLoggedIn(request.getSession())) {
			try {
				response.sendRedirect(request.getContextPath() + "/Auth/Login");
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "Could not redirect to login.", e);
			}
			return;
		}
		
		try {
			request.getRequestDispatcher("/WEB-INF/AddTopic.jsp").forward(request, response);
		} catch (IOException | ServletException e) {
			LOGGER.log(Level.SEVERE, "Could not redirect from AddTopic.", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String topicValue = request.getParameter("topicValue");
		User user = (User) request.getSession().getAttribute("user");
		Topic topic = new Topic();
		topic.setTopicValue(topicValue);
		topic.setDatePosted(new Date());
		topic.setUser(user);
		TopicService.addTopic(topic);
		try {
			response.sendRedirect(request.getContextPath() + "/Topics");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Could not redirect from AddTopic.", e);
		}
	}
}
