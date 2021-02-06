<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-4">
		<div class="col-sm-6">
			<form:form action="save" method="POST" modelAttribute="producto" enctype="multipart/form-data">
				<div class="card-header">
					<h3>Agregar Producto</h3>	
				</div>
				<div class="card-body">
					<div class="form-group">
						<label><h5>Nombre:</h5> </label>
						<form:input path="nombre"/>
					</div>
					<div class="form-group">
						<label><h5>Precio: </h5></label>
						<form:input path="precio"/>
					</div>
					<div class="form-group">
						<p><label><h5>Descripción:</h5> </label></p>
						<form:textarea path="descripcion"/>
					</div>
					<div class="form-group">
						<p><h5>Categoría: </h5></p>
						<p><h6>Telefonía</h6> <form:radiobutton path="categoria" value="telefonía"/>
						<h6>Informática</h6> <form:radiobutton path="categoria" value="informática"/></p>
						<p><h6>Imagen y Sonido</h6> <form:radiobutton path="categoria" value="imagenysonido"/>
						<h6>Videojuegos</h6> <form:radiobutton path="categoria" value="videojuegos"/></p>
					</div>
					<div class="form-group">
						<p><h5>Agregar Imagen</h5></p>
						<p><form:input type="file" path="imagen"/></p>
					</div>			
				</div>
				<div class="card-footer">
					<input type="submit" value="Guardar" class="btn btn-success">
				</div>
			</form:form>	
		</div>	
	</div>
	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>