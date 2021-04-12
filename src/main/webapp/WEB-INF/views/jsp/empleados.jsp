<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet type="text/css" href="${pageContext.request.contextPath}/public/css/style_listar-productos.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <p id="message"><p>
	<button type="button" class="btn btn-success"><a class="btnagregar" href="/empleados/formulario">Agregar</a></button>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Email</th>
				<th>Numero TGSS</th>
				<th> Editar </th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="worker" items="${empleados}">
				<tr>
					<td>${worker.id}</td>
					<td>${worker.nombre}</td>
					<td>${worker.apellido}</td>
					<td>${worker.email}</td>
					<td>${worker.TGSS}</td>
					<td><button type="button" class="btn btn-warning"><a class="btneditar" href="/edicionado/empleado/${worker.id}">Editar</a></button></td>
					<td><button type="button" class="btn btn-danger"><a class="btneliminar" href="/eliminado/empleado/${worker.id}">Eliminar</a></button></td>
				</tr>
		</tbody>
			</c:forEach>
	</table>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>