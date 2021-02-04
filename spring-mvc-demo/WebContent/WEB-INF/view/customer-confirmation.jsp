<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1>
Customer Name:  ${ customer.firstName } ${ customer.lastName }
</h1>
<h2>  Number of Free Passes ${ customer.freePasses } </h2>

<h3>Postal Code : ${ customer.postalCode }</h3>

<h4> Course Code ${ customer.courseCode }</h4>
</body>
</html>