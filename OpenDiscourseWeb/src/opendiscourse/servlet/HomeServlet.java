package opendiscourse.servlet;

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

/**
 * For the main page of the OpenDiscourse application.
 */
@WebServlet(description = "Access the main page of the application.", 
urlPatterns = { "/Index", "/", "Home" })
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = -8842471261332777447L;
	private static final Logger LOGGER = Logger.getLogger(HomeServlet.class.getName());

	public HomeServlet() {
		super();
	}

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
