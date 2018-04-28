<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./partial/Header.jsp" />
<div class="d-flex justify-content-center">
	<div class="col-md-8">
		<h3>Post A Topic</h3>
		<p class="lead">Write a topic that you believe will generate good discussion. Make sure your topic has a defined
		boundary in which you can either argue for it or against it.</p>
		<form action="${pageContext.request.contextPath}/Topics/New">
			<div class="form-group">
				<label>Topic</label>
				<input class="form-control" type="text" name="topic" id="topic" />
			</div>
			<div class="form-group">
				<input class="btn btn-secondary" type="submit" />
			</div>
		</form>
	</div>
	
</div>
<jsp:include page="./partial/Footer.jsp" />