package opendiscourse.servlet.common;

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

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {

	private static final long serialVersionUID = 5994273152881343696L;
	private static final Logger LOGGER = Logger.getLogger(Home.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/WEB-INF/Search.jsp").forward(request, response);
			
		} catch (IOException | ServletException e) {
			LOGGER.log(Level.WARNING, "Could not get Search page", e);
			try {
				response.sendRedirect(request.getContextPath() + "/");
			} catch (IOException e1) {
				LOGGER.log(Level.SEVERE, "Cannot redirect to: " + request.getContextPath() + "/", e);
			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String search = (String) request.getParameter("search");
		if (search != null) {
			search = search.trim();
		}
		LOGGER.info(search);
		List<Topic> searchResults = TopicService.searchTopic(search);
		request.setAttribute("searchResults", searchResults);
		doGet(request, response);
	}

}
