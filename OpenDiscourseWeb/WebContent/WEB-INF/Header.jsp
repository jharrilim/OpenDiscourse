<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OpenDiscourse</title>

<!--Bootstrap 4.0.0 CSS CDN-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />

<!-- FontAwesome CSS CDN -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
	integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
	crossorigin="anonymous">
<script defer
	src="https://use.fontawesome.com/releases/v5.0.10/js/all.js"
	integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+"
	crossorigin="anonymous"></script>

</head>
<body>
	<!-- Header -->
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark main-nav">
	    <div class="container justify-content-center">
	        <ul class="nav navbar-nav flex-fill w-100 flex-nowrap">
	            <li class="nav-item">
	                <div class="hidden-xl-down"></div>
	            </li>
	        </ul>
	        <ul class="nav navbar-nav flex-fill justify-content-center">
	            <li class="nav-item">
	            	<a class="navbar-brand" href="${pageContext.request.contextPath}/">( | )OpenDiscourse</a>
	            </li>
	        </ul>
	        <div class="nav navbar-nav flex-fill w-100 justify-content-end">
	        	<form class="form-inline" action="${pageContext.request.contextPath}/Search" method="POST">
		        	<div class="nav-item">
		                <input class="form-control" type="text" placeholder="Search" />
		            </div>
		            <div class="nav-item">
		                <input class="btn btn-outline-success" type="submit" value="Search" />
		            </div>
	        	</form>
	        </div>
	    </div>
	</nav>

	<!-- Sidebar -->
	<div class="container-fluid h-100">
		<div class="row h-100">
			<aside class="col-12 col-md-2 p-0 bg-dark">
				<nav class="navbar navbar-expand navbar-dark bg-dark flex-md-column flex-row align-items-start py-2">
					<div class="collapse navbar-collapse">
						<ul class="flex-md-column flex-row navbar-nav w-100 justify-content-between">
							<li class="nav-item">
								<a class="nav-link pl-0 text-nowrap" href="${pageContext.request.contextPath}/">
									<i class="fa fa-home fa-fw"></i>
									<span class="font-weight-bold">&nbsp;OpenDiscourse</span>
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
							<li class="nav-item">
								<a class="nav-link pl-0" href="${pageContext.request.contextPath}/Profile">
									<i class="fa fa-user fa-fw"></i>
									<span class="d-none d-md-inline">&nbsp;Profile</span>
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link pl-0" href="${pageContext.request.contextPath}/Logout">
									<i class="fa fa-list fa-fw"></i>
									<span class="d-none d-md-inline">&nbsp;Logout</span>
								</a>
							</li>
						</ul>
					</div>
				</nav>
			</aside>
			<main class="col bg-faded py-3">