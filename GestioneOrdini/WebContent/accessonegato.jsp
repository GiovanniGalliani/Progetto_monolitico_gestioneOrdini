<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Accesso negato</title>
<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Non puoi accedere a questa pagina</h3>
	</div>
	
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h3>Risorsa non disponibile</h3>
		</div>
		<div class="panel-body">
			<p>Effettuare la registrazione:</p>
			<a href="registra.jsp">Sign Up</a>
			<p>Oppure se registrati effettuare l'accesso:</p>
			<a href="login.jsp">Login</a>
		
		</div>
	
	</div>


</div>
<footer class="footer"><%@include file ="footer.html" %></footer>
</body>
</html>