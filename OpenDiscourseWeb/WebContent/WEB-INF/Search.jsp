<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./partial/Header.jsp" />
<div class="col-md-8">
	<c:if test="${ not empty searchResults }">
	<h3>Search Results: <c:out value="${ searchResults.size() } found" /></h3>
	<hr />
	<c:forEach var="topic" items="${ searchResults }">
		<div>
			<h5><c:out value="${ topic.getTopicValue() }" /></h5>
		</div>
		<hr />
	</c:forEach>
	</c:if>
</div>
<jsp:include page="./partial/Footer.jsp" />