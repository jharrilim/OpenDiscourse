<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./partial/Header.jsp" />
	<div>
		<h3>Join OpenDiscourse</h3>
		<form action="${pageContext.request.contextPath}/Auth/Register" method="POST">
			<div class="form-group">
				<label class="label">Username</label>
				<input class="form-control" type="text" placeholder="Username" name="username" id="username" required />
			</div>
			<div class="form-group">
				<label class="label">Email</label>
				<input class="form-control" type="email" placeholder="abc@email.com" name="email" id="email" required />
			</div>
			<div class="form-group">
				<label class="label">Password</label>
				<input class="form-control" type="password" name="password" id="password" required />
			</div>
			<div class="form-group">
				<label class="label">Confirm Password</label>
				<input class="form-control" type="password" name="confirmPassword" id="confirmPassword" required />
			</div>
			<c:if test="${not empty error }">
			<div id="errormsg" class="alert alert-danger" role="alert">
				<c:out value="${ error }"></c:out>
			</div>
			</c:if>
			<div class="form-group">
				<input type="submit" value="Register" />
			</div>
		</form>
	</div>

<jsp:include page="./partial/Footer.jsp" />