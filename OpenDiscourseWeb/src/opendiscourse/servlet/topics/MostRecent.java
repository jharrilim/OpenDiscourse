package opendiscourse.servlet.topics;

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
import opendiscourse.entity.Remark;
import opendiscourse.entity.Topic;
import opendiscourse.servlet.common.HomeServlet;

/**
 * Servlet implementation class MostRecent
 */
@WebServlet("/Topics/Recent")
public class MostRecent extends HttpServlet {

	private static final long serialVersionUID = 9136391628550781098L;
	private static final Logger LOGGER = Logger.getLogger(HomeServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Topic> topics = TopicService.all();
			for(Topic topic : topics) {
				LOGGER.log(Level.INFO, "topic: " + topic.getTopicValue());	
				for(Remark remark: topic.getRemarks())
					LOGGER.log(Level.INFO, "Remark: " + remark.getRemarkValue());
			}
			request.setAttribute("topics", topics);
			request.getRequestDispatcher("WEB-INF/Home.jsp").forward(request, response);
			
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
		doGet(request, response);
	}

}
