<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Vista Index JSP</h1>
	
	<form action="validador">
		<p><label>Usuario: </label><input type="text" name="usuario"></p>
		<p><label>Password: </label><input type="password" name="password"></p>
		<input type="submit" value="Entrar">
	</form>
	
	<a href="/listaruser">Mostrar usuarios</a>
</body>
</html>