<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
</head>
<body>
<h1>Modulo Productos</h1>
<hr>
<form action="producto" method="post" enctype="multipart/form-data">
	<div>
		<label>Nombre del Archivo</label><input type="file" value="Examinar" name="archivo">
	</div>
	<input type="submit" value="Cargar Archivo" name="cargar">
</form>
</body>
</html>