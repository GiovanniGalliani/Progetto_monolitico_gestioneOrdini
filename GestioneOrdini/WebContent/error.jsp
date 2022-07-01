<%@page import="java.io.PrintWriter"%>
<%@page import="com.mitota.architecture.dao.DAOException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
isErrorPage="true"%>
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
 <header class="page-header">
  <h3>Pagina di errore</h3>
 </header>
<%
 if(exception instanceof ClassNotFoundException) {
%>
<div class="panel panel-danger">
 <h5 class="panel-heading">
  Eccezione durante la connessione al DB
 </h5>
 <div class="panel-body">
    <h5><%= exception.getClass().getName() %></h5>
 <p>Motivo:&nbsp;<%= exception.getMessage() %></p>
 <button onclick="window.history.back()" class="btn btn-default">Indietro</button>
 </div>
</div>

<%
 } else if(exception instanceof DAOException) {
%>
<div class="panel panel-danger">
 <h5 class="panel-heading">
  Eccezione durante l'accesso al DB
 </h5>
 <div class="panel-body">
    <h5><%= exception.getClass().getName() %></h5>
 <p>Motivo:&nbsp;<%= exception.getMessage() %></p>
 <button onclick="window.history.back()" class="btn btn-default">Indietro</button>
 </div>
</div>
<%
 } else {
%>
<div class="panel panel-danger">
 <h5 class="panel-heading">
  Eccezione non prevista
 </h5>
 <div class="panel-body">
    <h5><%= exception.getClass().getName() %></h5>
 <p>Motivo:&nbsp;<%= exception.getMessage() %></p>
 <p>StackTrace:&nbsp;<% exception.printStackTrace(new PrintWriter(out)); %></p>
 <button onclick="window.history.back()" class="btn btn-default">Indietro</button>
 </div>
</div>
<%
 }
%>
</div>
</body>
</html>