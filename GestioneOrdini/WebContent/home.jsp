<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="carrello" class="com.mitota.businesscomponent.Carrello" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="well well" style="background-color: #F9F9F9">
<a class="btn btn-primary btn-lg" href="registra.jsp">Registrati gratis &raquo;</a>
</div>
<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="img/1.png" alt="Apple Airpods Pro">
    </div>

    <div class="item">
      <img src="img/2.png" alt="Samsung S20">
    </div>

    <div class="item">
      <img src="img/3.png" alt="Apple iPhone">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Precedente</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Successivo</span>
  </a>
</div>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>