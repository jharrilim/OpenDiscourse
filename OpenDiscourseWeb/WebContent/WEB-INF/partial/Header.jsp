<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OpenDiscourse</title>

<!--Bootstrap 4.1.0 CSS CDN-->
<link rel="stylesheet" 
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" 
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous" />

<!-- FontAwesome CSS CDN -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
	integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
	crossorigin="anonymous" />
<script defer
	src="https://use.fontawesome.com/releases/v5.0.10/js/all.js"
	integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+"
	crossorigin="anonymous"></script>

</head>
<body class="h-100">

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark hidden-sm-down justify-content-between">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/">( | )OpenDiscourse</a>
		<form class="form-inline my-2 my-lg-0">
			<c:if test="${ user }">
				<span class="navbar-text"><c:out value="${ user.getUsername() }"></c:out></span>
			</c:if>
	    	<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
	    	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</nav>

	<!-- Sidebar -->
	<div class="position-fixed container-fluid h-100">
		<div class="row h-100">
			<aside class="col-12 col-md-2 p-0 bg-dark">
				<nav class="navbar navbar-expand navbar-dark bg-dark flex-md-column flex-row align-items-start py-2">
					<div class="collapse navbar-collapse">
						<ul class="flex-md-column flex-row navbar-nav w-100 justify-content-between">
							<li class="nav-item">
								<a class="nav-link pl-0 text-nowrap" href="${pageContext.request.contextPath}/">
									<i class="fa fa-home fa-fw"></i>
									<span class="font-weight-bold">&nbsp;Home</span>
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link pl-0" href="${pageContext.request.contextPath}/Topics/New">
									<i class="fa fa-plus fa-fw"></i>
									<span class="d-none d-md-inline">&nbsp;New Topic</span>
								</a>
							</li>							
							<li class="nav-item">
								<a class="nav-link pl-0" href="${pageContext.request.contextPath}/Topics/Popular">
									<i class="fa fa-fire fa-fw"></i>
									<span class="d-none d-md-inline">&nbsp;Most Popular</span>
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link pl-0" href="${pageContext.request.contextPath}/Topics/Recent">
									<i class="fa fa-clock fa-fw"></i>
									<span class="d-none d-md-inline">&nbsp;Most Recent</span>
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link pl-0" href="${pageContext.request.contextPath}/Favourites">
									<i class="fa fa-heart fa-fw"></i>
									<span class="d-none d-md-inline">&nbsp;Favourites</span>
								</a>
							</li>
							<c:choose>
								<c:when test="${ empty user }">
							<li class="nav-item">
								<a class="nav-link pl-0" href="${pageContext.request.contextPath}/Auth/Login">
									<i class="fa fa-sign-in-alt fa-fw"></i>
									<span class="d-none d-md-inline">&nbsp;Login</span>
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link pl-0" href="${pageContext.request.contextPath}/Auth/Register">
									<i class="fa fa-user-plus fa-fw"></i>
									<span class="d-none d-md-inline">&nbsp;Register</span>
								</a>
							</li>
								</c:when>
								<c:otherwise>
							<li class="nav-item">
								<a class="nav-link pl-0" href="${pageContext.request.contextPath}/Profile">
									<i class="fa fa-user fa-fw"></i>
									<span class="d-none d-md-inline">&nbsp;Profile</span>
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link pl-0" href="${pageContext.request.contextPath}/Auth/Logout">
									<i class="fa fa-sign-out-alt fa-fw"></i>
									<span class="d-none d-md-inline">&nbsp;Logout</span>
								</a>
							</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</nav>
			</aside>
			<main class="col bg-faded py-3" style="overflow-y:scroll;">