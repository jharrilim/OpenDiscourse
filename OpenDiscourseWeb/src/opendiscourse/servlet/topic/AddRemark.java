package opendiscourse.servlet.topic;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opendiscourse.entity.Remark;
import opendiscourse.entity.Topic;
import opendiscourse.entity.User;
import opendiscourse.dao.TopicService;

@WebServlet("/AddRemark")
public class AddRemark extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(AddTopic.class.getName());
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect(request.getContextPath() + "/");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Could not redirect from AddTopic.", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String topicType = request.getParameter("topicType");
			String remarkValue = request.getParameter("remarkValue");
			User user = (User) request.getSession().getAttribute("user");
			int topicId = Integer.parseInt(request.getParameter("topicId"));
			
			Topic topic = TopicService.getTopicById(topicId);
			Remark remark = new Remark();
			remark.setRemarkValue(remarkValue);
			remark.setAgainst("against".equals(topicType));
			remark.setTopic(topic);
			remark.setDatePosted(new Date());
			remark.setUser(user);
			topic.addRemark(remark);
			TopicService.addRemark(remark);				
		

			LOGGER.log(Level.INFO, () -> String.format("Topic Type: %s", topicType));
		}
		catch(NumberFormatException e) {
			LOGGER.log(Level.SEVERE, "Could not parse topic id", e);
		}
		finally {
			doGet(request, response);
		}
	}

}
