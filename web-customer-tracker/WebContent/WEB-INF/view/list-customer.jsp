<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Of Customer</title>

<!--  Referenece our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/style.css" />


</head>
<body>
	<h1>List of Customer Comming Soon..!</h1>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Mapping</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
		
		<!--  Put a new Button to add Customer -->
		<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"  class="add-button"/>

			<!-- Set my html Table -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempCustomer" items="${ customers }">
				<c:url var="updateLink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${ tempCustomer.id }" />
				</c:url>
				
				<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerId" value="${ tempCustomer.id }" />
				</c:url>
					<tr>
						<td>${ tempCustomer.firstName }</td>
						<td>${ tempCustomer.lastName }</td>
						<td>${ tempCustomer.email }</td>
						<td>
						<a href="${ updateLink }">Update</a>
						|
						<a href="${ deleteLink }" onclick="if(!(confirm('Are you sure you want to delete this customer'))) return false">Delete</a>
						</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>