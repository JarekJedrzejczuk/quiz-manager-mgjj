<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri = "http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">


<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/spring/Spring.js" />"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script src="http://static.scripting.com/github/bootstrap2/js/bootstrap-modal.js"></script>
<script src="http://static.scripting.com/github/bootstrap2/js/jquery.js"></script>
<script type="text/javascript" 
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilesx"%>
	<tilesx:useAttribute name="current" />
	
	<div class="container">
		<div class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href='<spring:url value="/index.html"/>'>QuizManager</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'users' ? 'active' : ''}"><a
								href='<spring:url value="/users.html"/>'>users</a></li>
						</security:authorize>
						<security:authorize access="hasRole('EGZAMINATOR')">
							<li class="${current == 'users' ? 'active' : ''}"><a
								href='<spring:url value="/users.html"/>'>users</a></li>
							<li class="${current == 'grupy' ? 'active' : ''}"><a
								href='<spring:url value="/grupy.html"/>'>grupy</a></li>
							<li class="${current == 'kategorie' ? 'active' : ''}"><a
								href='<spring:url value="/kategorie-wyswietl.html"/>'>kategorie</a></li>
							<li class="${current == 'quizy' ? 'active' : ''}"><a
								href='<spring:url value="/quizy-wyswietl.html"/>'>quizy</a></li>
							<li class="${current == 'pytania' ? 'active' : ''}"><a
								href='<spring:url value="/pytania-wyswietl.html"/>'>pytania</a></li>
						</security:authorize>
						<security:authorize access="hasRole('UCZESTNIK')">
							<li class="${current == 'podejscia' ? 'active' : ''}"><a
								href='<spring:url value="/podejscia.html"/>'>podejscia</a></li>
						</security:authorize>

						<security:authorize access="! isAuthenticated()">
							<li class="${current == 'user-register' ? 'active' : ''}"><a
								href='<spring:url value="/register.html"/>'>register</a></li>
							<li class="${current == 'login' ? 'active' : ''}"><a
								href='<spring:url value="/login.html"/>'>login</a></li>
						</security:authorize>
<%-- 						<security:authorize access="isAuthenticated()"> --%>
<%-- 							<li class="${current == 'account' ? 'active' : ''}"><a href="<spring:url value="/account.html" />">My account</a></li> --%>
<%-- 							<li><a href="<spring:url value="/logout"/>">logout</a></li> --%>
<%-- 						</security:authorize> --%>
					</ul>
					
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</div>
		<tiles:insertAttribute name="body" />
		<br> <br>
		<center>
			<tiles:insertAttribute name="footer" />
		</center>
	</div>
</body>
</html>