<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
String ciudad_proveedor="", direccion_proveedor="", nombre_proveedor="", telefono_proveedor="", estado="";
int nitproveedor=0;
%>
<%
if(request.getParameter("nitproveedor")!=null){
	nitproveedor=Integer.parseInt(request.getParameter("nitproveedor"));
	ciudad_proveedor=request.getParameter("ciudad_proveedor");
	direccion_proveedor=request.getParameter("direccion_proveedor");
	nombre_proveedor=request.getParameter("nombre_proveedor");
	telefono_proveedor=request.getParameter("telefono_proveedor");
	estado="disable";
}
%>
<h1>Modulo de Proveedor</h1>
<form action="proveedor" method="post">
	<div><label>NIT: </label><input type="number" name="nitproveedor" value="<%=nitproveedor%>" <%=estado%> required></div>
	<input type="hidden" name="nitproveedor" value="<%=nitproveedor%>">
	<div><label>Ciudad: </label><input type="text" name="ciudad_proveedor" value="<%=ciudad_proveedor%>" required></div>
	<div><label>Direccion: </label><input type="text" name="direccion_proveedor" value="<%=direccion_proveedor%>" required></div>
	<div><label>Nombre: </label><input type="text" name="nombre_proveedor" value="<%=nombre_proveedor%>" required></div>
	<div><label>Telefono: </label><input type="text" name="telefono_proveedor" value="<%=telefono_proveedor%>" required></div>
	<div>
		<input type="submit" name="insertar" value="ingresar">
		<input type="submit" name="actualizar" value="actualizar">
		<input type="submit" name="eliminar" value="eliminar">
	</div>
</form>
<hr>
<form action="proveedor" method="post">
	<fieldset>
		<legend>Consultar</legend>
		<div>
		<label>NIT: </label><input type="text" name="nitproveedor">
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