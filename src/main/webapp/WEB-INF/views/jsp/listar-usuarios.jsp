<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr>
		<th>Nombre</th><th>Apellido</th><th>Email</th><th>Eliminar</th>
	</tr>
	
	<c:forEach var="user" items="${usuarios}">
		<tr>
			<td>${user.nombre}</td>
			<td>${user.apellidos}</td>
			<td>${user.email}</td>
			
			<!-- <a href="${linkeliminar}"><input type="button" value="Eliminar"/></a></td> --><td>
		</tr>
	</c:forEach>
</table>
</body>
</html>