<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Desafío Contact Manager</title>
<script type="text/javascript">

function setIdSelect(id){
	idSelect = id;
}

function deleteRow(){

	location.href = "/deleteContact/?id=" + idSelect;
}

</script>

</head>
<body>

	<form:form id="formContactos" modelAttribute="contacto" action="/addContact" method="POST">
		<div>
			<fieldset>
				<legend>Mantenedor de Contactos</legend>
				<table border="1">
					<tr>
						<td>Nombre:</td>
						<td><input type="text" id="idNombre" name="nombre" /></td>
						<td>Apellido Paterno:</td>
						<td><input type="text" id="idApellidoPaterno"
							name="ApellidoP" /></td>
						<td>Apellido Materno:</td>
						<td><input type="text" id="idApellidoMaterno"
							name="ApellidoM" /></td>
					</tr>
					<tr>
						<td>Dirección:</td>
						<td colspan="3"><input type="text" id="idDireccion"
							name="direccion" width="100%" /></td>
						<td>Teléfono:</td>
						<td><input type="text" id="idTelefono" name="telefono" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Agregar"/></td>
							<td><input type="button" value="Eliminar" onclick="deleteRow()"/></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</form:form><br>
	
<fieldset>	
			<legend>Lista de Contactos</legend>
	<table border="1" align="center">
		<tr>
			<th></th>
			<th>Nombre</th>
			<th>Apellido Paterno</th>
			<th>Apellido Materno</th>
			<th>Dirección</th>
			<th>Teléfono</th>
		</tr>
		
		<c:forEach items="${ContactList}" var="contacto">
		<tr>
		<td><input type="radio" id="filaSelecc${contacto.getIdContacto()}" name="filaSelecc" onclick="setIdSelect(${contacto.getIdContacto()})"/></td>
		<td><c:out value="${contacto.getNombre()}"></c:out></td>
		<td><c:out value="${contacto.getApellidoP()}"></c:out></td>
		<td><c:out value="${contacto.getApellidoM()}"></c:out></td>
		<td><c:out value="${contacto.getDireccion()}"></c:out></td>
		<td><c:out value="${contacto.getTelefono()}"></c:out></td>
				</tr>		
    	</c:forEach>

	</table>
</fieldset>

</body>
</html>