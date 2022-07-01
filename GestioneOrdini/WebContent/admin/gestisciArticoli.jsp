<%@page import="com.mitota.businesscomponent.facade.AdminFacade"%>
<%@page import="com.mitota.businesscomponent.model.Articolo"%>
<%@page import="com.mitota.businesscomponent.ArticoloBC"%>

<%
	if(session.getAttribute("admin") == null) {
		response.sendRedirect("../login.jsp");
	} else {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../CDN.html" %>
<meta charset="ISO-8859-1">
<title>Gestione Articoli</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp"/>
	<div class="container">
		<header class="page-header">
			<h3>Articoli disponibili</h3>
		</header>
		
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Marca</th>
						<th>Modello</th>
						<th>Prezzo</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
						Articolo[] articoli = AdminFacade.getInstance().getArticoli();
						for(Articolo a : articoli) {
					%>
						<tr>
							<td><%= a.getMarca() %></td>
							<td><%= a.getModello() %></td>
							<td><%= String.format("%.2f", a.getPrezzo()) %>&euro;</td>
							<td>
								<button type="button" class="btn btn-info btn-sm"
								data-toggle="modal" data-target="#editModal_<%= a.getIdArticolo() %>">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>
							</td>
							<td>
								<form action="/<%= application.getServletContextName() %>/rimuoviArticolo?id=<%= a.getIdArticolo() %>" method="post">
									<button type="submit" class="btn btn-danger btn-xs">
										<span class="glyphicon glyphicon-trash"></span>
									</button>
								</form>								
							</td>
							<td>
								<jsp:include page="editArticoloModal.jsp">
									<jsp:param value="<%= a.getIdArticolo() %>" name="id"/>
								</jsp:include>
							</td>
														
						</tr>					
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<footer class="footer"><%@ include file="footer.html" %></footer>
</body>
</html>
<%
	}
%>