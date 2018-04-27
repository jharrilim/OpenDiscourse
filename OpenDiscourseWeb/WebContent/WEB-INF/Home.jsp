<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp" />

<h2 class="text-center">Trending Topics</h2>

<c:forEach var="topic" items="${topics}">
	<div class="container">
		<div class="card">
			<div class="card-header">
				<span><c:out value="${ topic.getTopicValue() }"></c:out></span>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-6">
						<h3>For</h3>
					</div>
					<div class="col-6">
						<h3>Against</h3>
					</div>
				</div>
				<div class="row">
					<div class="col-6">
						<c:forEach var="pro" items="${ topic.getPros() }">
							<div>
								<c:out value="${ pro.getRemarkValue() }"></c:out>
							</div>
						</c:forEach>
					</div>
					<div class="col-6">
						<c:forEach var="con" items="${ topic.getCons() }">
							<div class="text-xs-right">
								<c:out value="${ con.getRemarkValue() }"></c:out>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:forEach>
<jsp:include page="Footer.jsp" />