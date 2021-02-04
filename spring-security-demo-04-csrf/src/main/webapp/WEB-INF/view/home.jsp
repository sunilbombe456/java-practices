<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Wellcome to WEBWORK Company Home Page</h1>
	<hr>
	<!--  Display username and rules -->
	<h1>
		User:
		<security:authentication property="principal.username" />
	</h1>
	<br>
	<br> Role(s)
	<security:authentication property="principal.authorities" />
	<hr>

	<security:authorize access="hasRole('MANAGER')">
		<br>
		<!-- Add a link to point to/leaders ...this for manager -->
		<a href="${ pageContext.request.contextPath }/leaders">Leadership
			Meeting (Manager for only)</a>

		<br>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<br>
		<!-- Add a link to point to/systems ...this for admin -->
		<a href="${ pageContext.request.contextPath }/systems">IT Meeting
			(ADMIN for only)</a>
		<br>
	</security:authorize>
	
	<hr>
	<br>
	<form:form action="${ pageContext.request.contextPath }/logout"
		method="POST">
		<button type="submit">Logout</button>
	</form:form>
</body>
</html>