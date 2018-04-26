<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp" />

<h2>Trending Topics</h2>

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
									<div>
										<c:out value="${ pro.getRemarkValue() }"></c:out>
									</div>
								</c:forEach>
							</td>
							<td>
								<c:forEach var="con" items="${ topic.getCons() }">
									<div>
										<c:out value="${ con.getRemarkValue() }"></c:out>
									</div>
								</c:forEach>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</c:forEach>
<jsp:include page="Footer.jsp" />