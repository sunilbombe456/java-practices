<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr>
<h1>Spring Rest Demo</h1>
<br>
<br>
<hr>
<br>
<a href="${pageContext.request.contextPath }/test/hello">Hello</a>
<br>
<a href="${pageContext.request.contextPath }/api/Students">Get All Students</a>
<br>
<hr>
</body>
</html>