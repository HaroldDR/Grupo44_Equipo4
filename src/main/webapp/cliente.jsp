<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CLIENTES</title>
</head>
<body>
<%!
String direccion_cliente="", email_cliente="", nombre_cliente="", telefono_cliente="", estado="";
int cedula_cliente=0;
%>
<%
if(request.getParameter("cedula_cliente")!=null){
	cedula_cliente=Integer.parseInt(request.getParameter("cedula_cliente"));
	direccion_cliente=request.getParameter("direccion_cliente");
	email_cliente=request.getParameter("email_cliente");
	nombre_cliente=request.getParameter("nombre_cliente");
	telefono_cliente=request.getParameter("telefono_cliente");
	estado="disable";
}
%>
<h1>Modulo de CLientes</h1>
<form action="clientes" method="post">
	<div><label>Cedula: </label><input type="number" name="cedula_cliente" value="<%=cedula_cliente%>" <%=estado%> required></div>
	<input type="hidden" name="ced" value="<%=cedula_cliente%>">
	<div><label>Direccion: </label><input type="text" name="direccion_cliente" value="<%=direccion_cliente%>" required></div>
	<div><label>Email: </label><input type="text" name="email_cliente" value="<%=email_cliente%>" required></div>
	<div><label>Nombre: </label><input type="text" name="nombre_cliente" value="<%=nombre_cliente%>" required></div>
	<div><label>Telefono: </label><input type="text" name="telefono_cliente" value="<%=telefono_cliente%>" required></div>
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
		<label>Cedula: </label><input type="text" name="cedula_cliente">
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