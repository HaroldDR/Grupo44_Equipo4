<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USUARIOS</title>
</head>
<body>
<%!
String email_usuario="", nombre_usuario="", password="", usuario="", estado="";
int cedula_usuario=0;
%>
<%
if(request.getParameter("cedula_usuario")!=null){
	cedula_usuario=Integer.parseInt(request.getParameter("cedula_usuario"));
	email_usuario=request.getParameter("email_usuario");
	nombre_usuario=request.getParameter("nombre_usuario");
	password=request.getParameter("password");
	usuario=request.getParameter("usuario");
	estado="disable";
}
%>
<h1>Modulo de Usuarios</h1>
<form action="usuarios" method="post">
	<div><label>Cedula: </label><input type="number" name="cedula_usuario" value="<%=cedula_usuario%>" <%=estado%> required></div>
	<input type="hidden" name="ced" value="<%=cedula_usuario%>">
	<div><label>Email: </label><input type="text" name="email_usuario" value="<%=email_usuario%>" required></div>
	<div><label>Nombre: </label><input type="text" name="nombre_usuario" value="<%=nombre_usuario%>" required></div>
	<div><label>Password: </label><input type="password" name="password" value="<%=password%>" required></div>
	<div><label>Usuario: </label><input type="text" name="usuario" value="<%=usuario%>" required></div>
	<div>
		<input type="submit" name="ingresar" value="ingresar">
		<input type="submit" name="actualizar" value="actualizar">
		<input type="submit" name="eliminar" value="eliminar">
	</div>
</form>
<hr>
<form action="clientes" method="post">
	<fieldset>
		<legend>Consultar</legend>
		<div>
		<label>Cedula: </label><input type="text" name="cedula_usuario">
		<input type="submit" name="consultar" value="consultar">
		</div>
	</fieldset>
</form>
<%
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script>alerta('"+mensaje+"');</script>");
}
%>
</body>
</html>