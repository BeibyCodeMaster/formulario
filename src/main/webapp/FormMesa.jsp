 
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	List estados = new ArrayList<String>();
	estados.add("Disponible");
	estados.add("Ocupada");
	estados.add("Reservada");	
	pageContext.setAttribute("estados", estados);
	
	List ubicaciones = new ArrayList<String>();
	ubicaciones.add("Interior");
	ubicaciones.add("Terraza");
	ubicaciones.add("Exterior");
	pageContext.setAttribute("ubicaciones", ubicaciones);
	
	String metodo 		= request.getParameter("metodo");
	String idForm 		= request.getParameter("idForm");
	String submitForm 	= request.getParameter("submitForm");
	 
	pageContext.setAttribute("metodo", metodo);
	pageContext.setAttribute("idForm", idForm);
	pageContext.setAttribute("submitForm", submitForm);
%>
 
 <div id="div_form">
	
	<form method="post" action="FormServlet" enctype="multipart/form-data">
	 	 
			 <center> <h1>Formulario Mesa</h1> </center>
			<br>
			<br>
	
	        <label for="codigo">Código:</label>
	        <input type="text" id="codigo" name="codigo"  maxlength="50">
	        <br>
	
	        <br>
	        <label for="capacidad">Capacidad:</label>
	        <input type="number" id="capacidad" name="capacidad"  min="1">
	        <br>
	
	        <br>
	        <label for="estado">Estado:</label>
			<select id="estado" name="estado">
				<c:forEach var="opcion" items="${estados}">
					<option value=${opcion}  ${opcion == 'Disponible' ? 'selected="selected"' : ""} >${opcion}</option>
				</c:forEach>
			</select>
	        <br>
	
	        <br>
	        <label for="ubicacion">Ubicación:</label>
	
	        <select id="ubicacion" name="ubicacion">
	        	<c:forEach var="ubicacion"  items="${ubicaciones}">
					<option value=${ubicacion}  ${ubicacion == 'Interior' ? 'selected="selected"' : ""} >${ubicacion}</option>
				</c:forEach>
	        </select>
	        <br>
	        <label for="decorada">¿Está decorada?</label>
	        <input type="checkbox" id="decorada" name="decorada">
	        <br>
	        <br>
	        <label for="imagen">Imagen:</label>      
	         <input type="file" id="imagen" name="imagen" accept="image/*">
	         <input type="hidden" name="metodo" value="registrarMesa">
	        <br>
	        <br>        
	        <input type="submit" value="Registrar">
	</form>

</div>