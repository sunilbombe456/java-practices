<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>The Student Confirmation</title>
</head>
<body>
<h1>
The Confirmation Student Name: ${ student.firstName } ${ student.lastName } 
 </h1>
 
 <h2> The Country: ${ student.country } </h2>
 
 <br>
 <h3> Favourite Language: ${ student.favouriteLanguage }  </h3>
 
 <br><br>
 
 Operating System :
 <ul>
 <c:forEach var="temp" items="${ student.operatingSystems }" > 
 <li> ${ temp } </li>
 </c:forEach>
 </ul>
</body>
</html>