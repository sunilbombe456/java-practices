<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

First Name : <form:input path="firstName" />
<br><br>
Last Name : <form:input path="lastName" />
<br><br>
Country 
<form:select path="country">
<form:options items="${ student.countryOptions }"></form:options>
</form:select>
<br><br>
favourite Language:
<br>
<form:radiobutton path="favouriteLanguage" Value="PHP" />PHP
<form:radiobutton path="favouriteLanguage" Value="JAVA" />JAVA
<form:radiobutton path="favouriteLanguage" Value="C#" />C#
<form:radiobutton path="favouriteLanguage" Value="Ruby" />Ruby

<br><br>
Operating System:

Linux <form:checkbox path="operatingSystems" value="Linux" />
Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
Windows <form:checkbox path="operatingSystems" value="Windows" />

<br><br>
<input type="submit" value="submit" />

</form:form>

</body>
</html>