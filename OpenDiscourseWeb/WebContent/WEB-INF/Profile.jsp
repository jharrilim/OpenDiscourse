<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./partial/Header.jsp" />
<div class="jumbotron">
	<div class="col-md-8">
		<h3><c:out value="${ user.getUsername() }"/>'s Profile</h3>
		<table>
			<tr>
				<th>Name: </th>
				<td><c:out value="${ user.getUsername() }" /></td>
			</tr>
			<tr>
				<th>Email: </th>
				<td><c:out value="${ user.getEmail() }" /></td>
			</tr>
		</table>
	</div>

</div>
<jsp:include page="./partial/Footer.jsp" />