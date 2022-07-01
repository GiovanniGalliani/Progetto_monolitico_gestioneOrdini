<%
	if(session.getAttribute("username") != null) {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Riepilogo ordine</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<header class="page-header">
		<h3>Ordine confermato</h3>
	</header>
	<p>Codice ordine:&nbsp;<%= session.getAttribute("idordine") %></p>
	<% session.removeAttribute("carrello"); %>
	<p>Per fare altri acquisti:</p>
	<a href="acquisti.jsp">Torna alla scelta degli articoli</a>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>
