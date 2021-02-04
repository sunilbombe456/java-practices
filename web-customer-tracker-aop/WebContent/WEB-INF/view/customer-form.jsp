<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />


<body>

	<div class="wrapper">
		<div class="header">
			<h2>Add Customer..here!</h2>
		</div>
	</div>
	<div  class="container">


		<form:form action="saveCustomer" method="post" 
			modelAttribute="customer">
			<form:hidden path="id" />
			<table>
			<tbody>
			<tr>
			<td><label>First Name:</label></td>
			<td><form:input path="firstName" />
			</td>
			</tr>
			
			<tr>
			<td><label>Last Name:</label></td>
			<td><form:input path="lastName" />
			</td>
			</tr>
			
			<tr>
			<td><label>Email:</label></td>
			<td><form:input path="email" />
			</td>
			</tr>
			
			<tr>
			<td><input  type="submit" value="save" />
			</td>
			</tr>
			
			</tbody>
			
			</table>
			

		</form:form>
		
		<div style="clear; both;">
		</div>
		<p>
		<a href="${ pageContext.request.contextPath}/customer/list">Back To List</a>
		</p>
	</div>
</body>
</html>