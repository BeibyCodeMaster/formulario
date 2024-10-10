<%@page import="models.Mesa"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table id="customers">
	<thead>
		<tr>
		    <th>Código</th>
		    <th>Capacidad</th>
		    <th>Estado</th>
		    <th>Ubicación</th>
		    <th>Decorada</th>
		    <th>Imagen</th>
		    <th>Acciones</th>
		</tr>
	</thead>
	<tbody>	            
		<c:forEach var="mesa"  items="${mesas}">            
			<tr>
			    <td>${mesa.getCodigo() }</td>
				<td>${mesa.getCapacidad().intValue()}</td>
				<td>${mesa.getEstado()}</td>
				<td>${mesa.getUbicacion()}</td>
				<td>${mesa.getDecorada() ? "Sí" : "No"}</td>
				<td> <img src="./${mesa.getImagenRuta()}"  alt="Imagen de Mesa" width="50"></td>	
				<td>				 
					<a  id="update" href="#modalUpdateTable"  onclick="handleClickOnUpdate('${mesa.getId()}')" >Actualizar</a>
			
					<a id="delete" href="#modalDeleteTable" onclick="handleClickOnDelete('${mesa.getId()}, ${mesa.getCodigo()}, ${mesa.getImagenRuta()}')">Eliminar</a>
					
				</td>
			</tr>
		</c:forEach>         
	</tbody>
</table>