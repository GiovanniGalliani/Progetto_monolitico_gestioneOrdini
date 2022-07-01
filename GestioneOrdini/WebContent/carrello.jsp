<%@page import="java.util.Enumeration"%>
<%@page import="com.mitota.businesscomponent.model.Articolo"%>
<%@page import="com.mitota.businesscomponent.facade.ClientFacade"%>


<%
	if(session.getAttribute("username") != null) {
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="carrello" class="com.mitota.businesscomponent.Carrello" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Riepilogo carrello</title>
<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Riepilogo carrello</h3>
	</div>
	<p>Totale carrello: <strong>
		<%= String.format("%.2f", carrello.totaleComplessivo()) %>
	</strong>

<div class="table-responsive">
	<table class="table table-hover">
	<thead>
		<tr>
		<th>Marca</th>
		<th>Modello</th>
		<th>Parziale</th>
		<th>Quantit&agrave;</th>
		<th>Rimuovi</th>
		</tr>
	</thead>
	<tbody>
	<%
		Enumeration<String[]> prodotti = carrello.listaProdotti();
		while(prodotti.hasMoreElements()) {
			String[] prodotto = prodotti.nextElement();
	%>
	
	<tr>
			<td><%= prodotto[0] %></td>
   			<td><%= prodotto[1] %></td>
   			<td><%= String.format("%.2f", carrello.totaleParziale(prodotto[4])) %>&euro;</td>
   			<td><%= prodotto[3] %></td>
   			<td>
		<form action="/<%= application.getServletContextName() %>/rimuoviCarrello?id=<%= prodotto[4] %>" method="post">
		<button type="submit" class="btn btn-danger btn-xs">Rimuovi</button>
		</form>
		</td>
   		
	</tr>
	
	<%
		}

	%>

	</tbody>
	</table>
	</div>
	
<hr>
	<a href="acquisti.jsp">Torna alla pagina della scelta prodotti</a>
	
	<%
		if(carrello.totaleArticoli() != 0) {	
	%>
	<div class="panel panel-default" style="margin-top: 50px;">
	<div class="panel-heading">
	<h4><strong>Conferma ordine</strong></h4>
	<div style="text-align: right">Totale articoli nel carrello: 
		<%= carrello.totaleArticoli() %>
	</div>
	</div>
	<div class="panel-body">
		<form action="/<%= application.getServletContextName() %>/conferma" method="post">
			<button type="submit" class="btn btn-success">
				&#10003; Acquista i prodotti
			</button>
		</form>	
	</div>	
</div>
</div>
<%
		}
%>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>

</body>
</html>
<%
 } else {
  response.sendRedirect("accessonegato.jsp");
 }
%>