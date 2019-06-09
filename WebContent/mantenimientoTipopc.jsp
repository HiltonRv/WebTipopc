<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="/struts-tags" prefix="s"   %>
<%@ taglib uri="/struts-bootstrap-tags" prefix="sb"   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mantenimiento de PC</title>
<sb:head/>
	<style type="text/css">
		body{ margin: 10px}
	</style>
</head>
<body>
<h1>Mantenimiento de PC</h1>
<p></p>

<s:form action="%{(edit==0)?'registrarTipopc':'actualizarTipopc'}">
		<s:textfield label="Id" name="tipopc.id" />
		<s:textfield label="Nombre" name="tipopc.nombre" />
		<s:textfield label="Marca" name="tipopc.marca" />
		<s:textfield label="Proveedor" name="tipopc.proveedor" />
		<s:select list="lstTipopc" listKey="Color" listValue="Color"
			headerKey="-1" headerValue="[--Seleccione--]" name="tipopc.color"
			label="Color" />
		<s:checkbox name="tipopc.estado" fieldValue="true" label="NUEVO"/>
		<s:submit value="%{(edit==0)?'Registrar':'Actualizar'}" />
	</s:form>

<p></p>
<table border="1" cellpadding="3px" cellspacing="3px" width="290px" >
<thead>
<tr>
	<th> id </th>
	<th> nombre </th>
	<th> marca </th>
	<th> proveedor </th>
	<th> color </th>
	<th> estado </th>
	<th colspan="2"> OPC </th>
</tr>
</thead>
<tbody>
	<s:iterator value="lstTipopc"  >
		<tr>
		<td> <s:property value="id" /> </td>
		<td> <s:property value="nombre" /> </td>
		<td> <s:property value="marca" /> </td>
		<td> <s:property value="proveedor" /> </td>
		<td> <s:property value="color" /> </td>
		<td> <s:property value="estado" /> </td>		
		<td>
			 <s:url action="editarTipopc" var="lnkeditar" >
			 	<s:param name="tipopc.id" value="id" />
			 </s:url>
			 <s:a href="%{lnkeditar}" > 
			 	<img alt="editar" src="img/editar.png">
			 </s:a>
		</td>
		<td>
			<s:url action="eliminarTipopc" var="lnkeliminar" >
			 	<s:param name="tipopc.id" value="id" />
			 </s:url>
			 <s:a href="%{lnkeliminar}" > 
				<img alt="eliminar" src="img/eliminar.png">
			 </s:a>  
		</td>
		</tr>
	</s:iterator>
</tbody>
</table>
<p></p>
	

</body>
</html>