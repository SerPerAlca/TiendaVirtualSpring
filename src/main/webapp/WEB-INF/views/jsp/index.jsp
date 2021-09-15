<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet type="text/css" href="${pageContext.request.contextPath}/public/css/prueba.css">
</head>
<body>
	<h1>Vista Index</h1>



	<a href="/listaruser">Mostrar usuarios</a>
	<a href="/productos/list">Mostrar productos</a>
	<a href="/formulario/cliente">Registro</a>
	<a href="/auth/login">Login</a>
	<img src="${pageContext.request.contextPath}/public/images/admin.png" onclick="admin()" alt="Imagen Admin">


<script>
    function admin(){
        var codigo = prompt("Introduzca código de administrador", "")
        if (codigo == "678479970"){
            alert("Bienvenido Admin");
            window.location.href="/empleados/list";
        } else {
            alert("¡Código incorrecto! \n Por favor, solo intente acceder si es administrador de la página");
        }
    }

</script>
</body>
</html>