<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<header class="registro">
		<h1>Bienvenidos a la Tienda Generica</h1>
		<form action="Interfaz" method="POST">
			<div><input class="boxes" type="text" name="usuario" placeholder="Ingrese su usuario" required></div>
			<div><input class="boxes" type="password" name="password"placeholder="Ingrese su contrasena"  required></div>
			<div><input class="botones"type="submit" name="enviar" value="Enviar">
			<input class="botones" type="button" name="enviar" value="Cancelar">
			</div>
		</form>
	</header>
</body>
</html>