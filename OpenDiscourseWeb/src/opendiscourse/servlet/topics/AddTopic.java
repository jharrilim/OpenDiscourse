package opendiscourse.servlet.topics;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opendiscourse.entity.Topic;
import opendiscourse.dao.TopicService;

@WebServlet("/Topics/AddTopic")
public class AddTopic extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(AddTopic.class.getName());
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect(request.getContextPath() + "/Topics");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Could not redirect from AddTopic.", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String topicValue = request.getParameter("topicValue");
		Topic topic = new Topic();
		topic.setTopicValue(topicValue);
		TopicService.addTopic(topic);
		try {
			response.sendRedirect(request.getContextPath() + "/Topics");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Could not redirect from AddTopic.", e);
		}
	}

}
