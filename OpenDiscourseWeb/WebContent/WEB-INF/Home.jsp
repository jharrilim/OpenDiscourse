<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp" />

<h2 class="text-center">Trending Topics</h2>

<c:forEach var="topic" items="${topics}">
	<div class="container">
		<div class="card">
			<div class="card-header">
				<span class="card-title"><c:out value="${ topic.getTopicValue() }"></c:out></span>
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
			<div class="card-footer">
				<span class="card-subtitle">Post Remark</span>
				<form action="${pageContext.request.contextPath}/AddTopic">
					<textarea class="form-control col-xs-12"></textarea>
					<div class="radio">
						<label><input type="radio" name="topicType" />For</label>
					</div>
					<div>
						<label><input type="radio" name="topicType" />Against</label>
					</div>								
					<input class="btn btn-lg btn-outline-primary float-right" type="submit" value="Submit" />
				</form>
			</div>
		</div>
	</div>
</c:forEach>
<jsp:include page="Footer.jsp" />