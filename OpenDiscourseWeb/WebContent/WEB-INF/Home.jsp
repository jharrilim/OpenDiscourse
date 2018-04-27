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
							<hr />
						</c:forEach>
					</div>
					<div class="col-6">
						<c:forEach var="con" items="${ topic.getCons() }">
							<div class="text-xs-right">
								<c:out value="${ con.getRemarkValue() }"></c:out>
							</div>
							<hr />
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="card-footer">
				<span class="card-subtitle">Post Remark</span>
				<form action="${pageContext.request.contextPath}/AddRemark" method="POST">
					<input type="hidden" name="topicId" value="${ topic.getIdTopic() }" />
					<div class="row">
						<textarea class="form-control col-xs-12" name="remarkValue"></textarea>
					</div>
					<div class="row">
						<div id="topicBtnGrp" class="btn btn-group-toggle col-xs-4" data-toggle="buttons">
							<label class="btn btn-secondary active"><input type="radio" name="topicType" id="typeFor" value="for" checked />For</label>
							<label class="btn btn-secondary"><input type="radio" name="topicType" id="typeAgainst" value="against" />Against</label>
						</div>								
						<div class="col-xs-8">
							<input class="btn btn-lg btn-outline-primary pull-right text-right" type="submit" value="Submit" />
						</div>
					</div>	
				</form>
			</div>
		</div>
	</div>
</c:forEach>
<jsp:include page="Footer.jsp" />