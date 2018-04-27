<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./partial/Header.jsp" />
<div class="col-md-6">
	<h3>Login</h3>
	<form action="/Auth/Login" method="POST">
		<div class="form-group">
			<label for="username">Username</label> <input class="form-control"
				type="text" name="username" />
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input class="form-control"
				type="text" name="password" />
		</div>
		<div class="form-group">
			<input class="btn btn-outline-primary" type="submit" value="Login" />
		</div>
	</form>
</div>
<jsp:include page="./partial/Footer.jsp" />