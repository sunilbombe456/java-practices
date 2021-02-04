<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Wellcome to WEBWORK Company Home Page</h1>
<form:form  action="${ pageContext.request.contextPath }/logout" method="POST">
<button type="submit">Logout</button>
</form:form>
</body>
</html>