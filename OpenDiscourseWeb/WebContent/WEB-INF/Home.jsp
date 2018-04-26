<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OpenDiscourse</title>

<!--Bootstrap 4.0.0 CSS-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />


</head>
<body>
	<h1>Hello World</h1>
	<c:forEach var="topic" items="${topics}">
		<div class="container">
			<div class="card">
				<div class="card-header">
					<span><c:out value="${ topic.getTopicValue() }"></c:out></span>
				</div>
				<div class="card-body">
					<table>
						<thead>
							<tr>
								<th>For</th>
								<th>Against</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<c:forEach var="pro" items="${ topic.getPros() }">
										<div><c:out value="${ pro.getRemarkValue() }"></c:out></div>
									</c:forEach> 
								</td>
								<td>
									<c:forEach var="con" items="${ topic.getCons() }">
										<div><c:out value="${ con.getRemarkValue() }"></c:out></div>
									</c:forEach> 
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</c:forEach>

	<!-- Bootstrap 4.0.0 JavaScript Dependencies -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>