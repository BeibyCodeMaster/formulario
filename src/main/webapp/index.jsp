<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
	<link rel="stylesheet" type="text/css" href="css/formulario_mesa.css"/>
	
</head>
<body class="body">

    <h1 style="margin-top: 15%;">Modulo Mesa</h1>
   
	<div id="div_form" style="width: 20%; margin: 0 auto">
	
	 
		<form method="get" action="${pageContext.request.contextPath}/FormServlet">
			<label for="usuario">Usuario:</label>
			<input type="text" id="usuario" name="usuario" required><br><br>
			
			<label for="password">Contraseña:</label>
			<input type="password" id="password" name="password" required><br><br>
			
			<input class="btnForm" type="submit" value="Iniciar Sesión">
		</form>
		
	</div>

</body>
</html>