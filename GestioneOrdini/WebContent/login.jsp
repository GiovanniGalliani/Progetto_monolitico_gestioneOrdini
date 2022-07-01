<% 
	if(session.getAttribute("username") == null) {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
 <div class="page-header text-center">
  <h3>Inserire i dati per il login</h3>
 </div>
 <form action="/<%=application.getServletContextName()%>/controllo" method="post" class="form-horizontal" id="userForm">
 
 
 <!-- USERNAME  -->
 <div class="form-group">
  <label class="col-md-1 control-label">Username</label>
  <div class="col-md-4 inputGroupContainer">
   <div class="input-group">
    <span class="input-group-addon">
     <i class="glyphicon glyphicon-user"></i>
    </span>
    <input type="text" name="username" placeholder="Username..." class="form-control" id="username">
   </div>
  </div>
 </div>
 
 <!-- PASSWORD  -->
 <div class="form-group">
  <label class="col-md-1 control-label">Password</label>
  <div class="col-md-4 inputGroupContainer">
   <div class="input-group">
    <span class="input-group-addon">
     <i class="glyphicon glyphicon-lock"></i>
    </span>
    <input type="password" name="password" placeholder="Password..." class="form-control" id="password">
   </div>
  </div>
 </div>
 
 <div class="row">
  <div class="col-md-4 col-md-offset-1">
   <button type="submit" class="btn btn-success">
    Login&nbsp;&nbsp;<span class="glyphicon glyphicon-log-in"></span>
   </button>
  </div>
 </div>
 </form>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>

<%
	}else{
		response.sendRedirect("acquisti.jsp");
	}

	%>