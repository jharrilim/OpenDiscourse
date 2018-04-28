<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./partial/Header.jsp" />

<h2 class="text-center">Trending Topics</h2>

<c:forEach var="topic" items="${topics}">
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h4 class="card-title"><c:out value="${ topic.getTopicValue() }"></c:out></h4>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-6">
						<h4>For</h4>
					</div>
					<div class="col-6">
						<h4>Against</h4>
					</div>
				</div>
				<div class="row">
					<div class="col-6">
						<c:forEach var="pro" items="${ topic.getPros() }">
							<div>
								<p><c:out value="${ pro.getRemarkValue() }"></c:out></p>
								<h6 class="text-right">- <c:out value="${ pro.getUser().getUsername() }"/>, <c:out value="${ pro.getDatePosted() }"/></h6>
							</div>
							<hr />
						</c:forEach>
					</div>
					<div class="col-6">
						<c:forEach var="con" items="${ topic.getCons() }">
							<div class="text-xs-right">
								<div>
									<p><c:out value="${ con.getRemarkValue() }"></c:out></p>
									<h6 class="text-right">- <c:out value="${ con.getUser().getUsername() }"/>, <c:out value="${ con.getDatePosted() }"/></h6>
								</div>
							</div>
							<hr />
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="card-footer">
				<h6 class="card-subtitle">Write Remark</h6>
				<form action="${pageContext.request.contextPath}/AddRemark" method="POST">
					<input type="hidden" name="topicId" value="${ topic.getIdTopic() }" />
					<div class="row">
						<textarea class="form-control col-xs-12" name="remarkValue"></textarea>
					</div>
					<div class="row">
						<div class="btn-group" role="group">
							<div id="topicBtnGrp" class="btn btn-group-toggle col-xs-4" data-toggle="buttons">
								<label class="btn btn-secondary active"><input type="radio" name="topicType" id="typeFor" value="for" checked />For</label>
								<label class="btn btn-secondary"><input type="radio" name="topicType" id="typeAgainst" value="against" />Against</label>
							</div>
							<input class="btn btn-outline-primary" type="submit" value="Submit" />						
						</div>
					</div>	
				</form>
			</div>
		</div>
	</div>
</c:forEach>
<br />
<br />
<br />
<br />
<br />
<br />
<jsp:include page="./partial/Footer.jsp" />