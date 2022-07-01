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
<title>Pagina acquisti</title>
<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Articoli presenti in catalogo</h3>
	</div>
	<p>Totale carrello: <strong>
		<%= String.format("%.2f", carrello.totaleComplessivo()) %>
	</strong>

<div class="table-responsive">
	<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Marca</th>
			<th>Modello</th>
			<th>Prezzo</th>
			<th>Ordine</th>
		</tr>
	</thead>
	<tbody>
		<%
			Articolo[] a = ClientFacade.getInstance().getArticoli();
			for(int i= 0; i<a.length;i++) {
		%>
		<tr>
			<td><%= a[i].getIdArticolo() %></td>
			<td><%= a[i].getMarca() %></td>
			<td><%= a[i].getModello() %></td>
			<td><%= String.format("%.2f", a[i].getPrezzo()) %>&euro;</td>	
			<td>
			<form action="/<%= application.getServletContextName() %>/aggiungiCarrello"
			method="post">
				<input type="hidden" name="id" value="<%= a[i].getIdArticolo() %>">
				<button type="submit" class="btn btn-primary btn-xs">
				Aggiungi
				</button>
			
			
			</form>
			
			</td>
		</tr>
	<%
		}
	%>
	
	</tbody>
	</table>
	
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