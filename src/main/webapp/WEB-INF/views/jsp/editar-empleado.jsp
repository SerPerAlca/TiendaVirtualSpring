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
			<form:form action="/empleadosEdicion" method="POST" modelAttribute="worker">
			    <table class="table" id="tabla">
                    <tr>
                        <th> &nbsp </th>
                        <th> Registro Original </th>
                        <th> Nuevo Registro </th>
                    </tr>
                    <tr>
                        <td> ID: </td>
                        <td>
                            ${worker.id}
                        </td>
                        <td>
                            <div class="form-group">
                                <form:input path="id" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td>
                            ${worker.nombre}
                        </td>
                        <td>
                            <div class="form-group">
                                <form:input path="nombre" />
                            </div>
                        <td>
                    </tr>
                    <tr>
                        <td>Apellidos: </td>
                        <td>
                            ${worker.apellido}
                        </td>
                        <td>
                            <div class="form-group">
                                <form:input path="apellido" />
                            </div>
                        <td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td>
                            ${worker.email}
                        </td>
                        <td>
                            <div class="form-group">
                                <form:input path="email" />
                            </div>
                        <td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td>
                            ${worker.password}
                        </td>
                        <td>
                            <div class="form-group">
                                <form:input path="password" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Número Seguridad Social: </td>
                        <td>
                            ${worker.TGSS}
                        </td>
                        <td>
                            <div class="form-group">
                                <form:input path="TGSS" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Guardar Cambios" class="btn btn-success"></td>
                    </tr>
			    </table>
			</form:form>
		</div>	
	</div>
<script>
    window.onload=ocultarFila();
    function ocultarFila(){
        var tabla = document.getElementById("tabla");
        tabla.getElementsByTagName('tr')[1].style.display="none";
    }
</script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>