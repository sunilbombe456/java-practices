<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 30%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal {
	/*display: none; Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 40%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

/* style for error message

.info,.success,.warning,.error,.validation {
	border: 1px solid;
	margin: 10px auto;
	padding: 15px 10px 15px 50px;
	background-repeat: no-repeat;
	background-position: 10px center;
	max-width: 460px;
}

.error {
	color: #D8000C;
	background-color: #FFBABA;
}

.error:before{
   font-family: FontAwesome;
   content: '\f057';
   font-size: 24px;
   color: #D8000C;
}


</style>
</head>
<body>

	<div id="id01" class="modal">

		<form:form class="modal-content animate"
			action="${ pageContext.request.contextPath }/authenticateTheUser"
			method="POST" >
			<div class="imgcontainer">
				<!-- <img src="<c:url value="/resources/logo/avatar.png" />" alt="Avatar"
					class="avatar"> -->
					<c:if test="${param.error != null}">
					<div class="error" style="color:red"><i>Sorry! you Entered Invalid username/password </i></div>
					</c:if>
					
			</div>

			<div class="container">

				<input type="text" placeholder="Enter Username" name="username"/>
				<br>

				<input type="password" placeholder="***********"
					name="password" />
				<br>
				<input type="submit" value="Login" />
			</div>

			<div class="container" style="background-color: #f1f1f1">
				<button type="button" class="cancelbtn">
					<a href="../">Cancel</a>
				</button>
				<span class="psw">Forgot <a href="#">password?</a></span>
			</div>
		</form:form>
	</div>





</body>
</html>

