package opendiscourse.guard;

import javax.servlet.http.HttpSession;

public class AuthGuard {

	private AuthGuard() {
		
	}
	
	public static boolean isLoggedIn(HttpSession session) {
		return session.getAttribute("user") != null;
	}
	
}
