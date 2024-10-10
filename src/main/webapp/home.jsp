<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" type="text/css" href="css/index.css"/>
	<link rel="stylesheet" type="text/css" href="css/modal.css"/>
	<link rel="stylesheet" type="text/css" href="css/lista_mesas.css"/>
	<link rel="stylesheet" type="text/css" href="css/formulario_mesa.css"/>


</head>
<body class="body">

	<h1>Bienvenido  ${user.get_usuario()}  al Modulo Mesa</h1>
	<br>
	  <ul class="menuIndex">
	      <li><a href="#sendFormPost">Agregar Mesa</a></li>
	  </ul>
	  
	  
	   <br><br>
	   <c:if test = "${mesas != null}">
	        <jsp:include page="listTables.jsp"/>
	    </c:if>
	    
	  
	  	     <div id="modalUpdateTable" class="modalmask">
		          <div class="modalbox movedown">
		              <a href="#" title="Close" class="close">X</a>
		                <jsp:include page="FormMesa.jsp"/>           
		          </div>
	         </div>
	         
	       <div id="modalDeleteTable" class="modalmask">
	          <div class="modalbox movedown">
	              <a href="#" title="Close" class="close">X</a>
				   <jsp:include page="eliminarMesa.jsp"/>    			    
	           </div>
	       </div>      
	         
	        <div id="sendFormPost" class="modalmask">
		          <div class="modalbox movedown">
		              <a href="#" title="Close" class="close">X</a>
		                <jsp:include page="sendFormPost.jsp"/>           
		          </div>
	         </div>

</body>
</html>