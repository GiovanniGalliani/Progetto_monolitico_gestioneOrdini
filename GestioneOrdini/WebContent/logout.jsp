<% 
	if(session.getAttribute("username") != null || session.getAttribute("admin") != null  ) {
		session.invalidate();
	
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Logout</h3>
	</div>
	
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h3>Hai appena effettuato il logout</h3>
		</div>
		<div class="panel-body">
			<p>Per procedere con gli acquisti, effettuare l'accesso:</p>
			<a href="login.jsp">Login</a>
		
		</div>
	
	</div>


</div>
<footer class="footer"><%@include file ="footer.html" %></footer>
</body>
</html>

<% 
	} else {
		response.sendRedirect("accessonegato.jsp");
		
}
%>