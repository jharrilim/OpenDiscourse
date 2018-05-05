package opendiscourse.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Favourites
 */
@WebServlet("/Topics/Favourites")
public class Favourites extends HttpServlet {

	private static final long serialVersionUID = -5538776705630302220L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
