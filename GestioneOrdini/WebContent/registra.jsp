<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Registreazione utente</title>
<link rel="stylesheet" href="css/style.css"> 
<script src="js/convalida.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Inserire i dati per la registrazione</h3>
	</div>
	
	<form action="/<%= application.getServletContextName() %>/registra" method="post" class="form-horizontal"
	id="userForm">
	
	<!-- ----------------------- NOME -->
	<div class="form-group">
		<label class="col-md-1 control-label">Nome</label>	
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input type="text" name="nome" placeholder="Inserire nome"
				id ="nome"
				class="form-control">
			</div>	
		</div>
		<div class="col-md-7 control-label" id="infoNome"></div>
	</div>
	
	<!-- ----------------------- COGNOME -->
	<div class="form-group">
		<label class="col-md-1 control-label">Cognome</label>	
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input type="text" name="cognome" placeholder="Inserire cognome"
				id ="cognome"
				class="form-control">
			</div>	
		</div>
		<div class="col-md-7 control-label" id="infoCognome"></div>
	</div>
	
		<!-- ----------------------- INDIRIZZO -->
	<div class="form-group">
		<label class="col-md-1 control-label">Indirizzo</label>	
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				<textarea cols="40" rows="3" name="indirizzo" placeholder="Inserire indirizzo"
				id ="indirizzo"
				class="form-control" style="resize:none;"></textarea>
			</div>	
		</div>
		<div class="col-md-7 control-label" id="infoIndirizzo"></div>
	</div>
	
		<!-- ----------------------- CAP -->
	<div class="form-group">
		<label class="col-md-1 control-label">Cap</label>	
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				<input type="text" name="cap" placeholder="Inserire cap"
				id ="cap"
				class="form-control">
			</div>	
		</div>
		<div class="col-md-7 control-label" id="infoCap"></div>
	</div>
	
		<!-- ----------------------- NASCITA -->
<div class="form-group">
        <label class="col-md-1 control-label">Nascita</label>
        <div class="col-md-4 inputGroupContainer">
          <div class="input-group date" id="dp">
            <span class="input-group-addon"> <i
              class="glyphicon glyphicon-calendar"></i>
            </span> <input type="text" name="nascita" placeholder="DD/MM/YYYY"
            	id ="nascita"
              class="form-control">
          </div>
        </div>
        <div class="col-md-7 control-label" id="infoCap"></div>
      </div>
	
	<script>
		$(function(){
			$('#dp').datepicker({
				format:'dd/mm/yyyy',
				autoclose: true,
				startDate: '01/01/1900',
				endDate: new Date()
			}).on(
				'changeDate',
				function(e) {
					$('#userForm').bootstrapValidator(
							'revalidateField', 'nascita');
				});	
		});
	</script>
	
	<!-- ----------------------- USERNAMEE -->
	<div class="form-group">
		<label class="col-md-1 control-label">Username</label>	
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input type="text" name="username" placeholder="Inserire username"
				id ="username"
				class="form-control">
			</div>	
		</div>
		<div class="col-md-7 control-label" id="infoUsername"></div>
	</div>
	
	<!-- ----------------------- PASSWORD -->
	<div class="form-group">
		<label class="col-md-1 control-label">Password</label>	
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				<input type="password" name="password" placeholder="Inserire password"
				id ="password"
				class="form-control">
			</div>	
		</div>
		<div class="col-md-7 control-label" id="infoPassword"></div>
	</div>
	
	
	<!-- ----------------------- EMAIL -->
	<div class="form-group">
		<label class="col-md-1 control-label">E-mail</label>	
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
				<input type="email" name="email" placeholder="Inserire e-mail"
				id ="email"
				class="form-control">
			</div>	
		</div>
		<div class="col-md-7 control-label" id="infoEmail"></div>
	</div>
	
	<div class="row">
		<div class="col-md-4 col-md-offset-1">
			<button type="submit" class="btn btn-warning">Registrati&nbsp;&nbsp; <span class="glyphicon glyphicon-send"></span></button>
		</div>
	
	</div>
	
	</form>

</div>
<footer class="footer"><%@include file ="footer.html" %></footer>
</body>
</html>