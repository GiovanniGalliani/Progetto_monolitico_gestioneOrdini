<jsp:useBean id="carrello" class="com.mitota.businesscomponent.Carrello" scope="session"/>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" 
      class="navbar-toggle" 
      data-toggle="collapse" 
      data-target="#menuApp">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home.jsp">Negozio on-line</a>
    </div>
    <div class="collapse navbar-collapse" id="menuApp">
    <%
    	String username = (String) session.getAttribute("username");
    	if(username == null) {    
    %>
      <ul class="nav navbar-nav navbar-right">
        <li>
        	<a href="registra.jsp">
        	<span class="glyphicon glyphicon-user"></span>Sign up
        	</a>
        </li>
        <li><a href="login.jsp">
        	<span class="glyphicon glyphicon-log-in"></span>Login
        	</a>
        </li>
      </ul>
      <%
    	} else {      
      %>
      <ul class="nav navbar-nav">
        <li><a href="acquisti.jsp">Scelta articoli</a></li>
        <li><a href="carrello.jsp">Riepilogo carrello</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
        	<a href="carrello.jsp">
        	<span class="glyphicon glyphicon-shopping-cart"></span>
        	<span class="badge"><%= carrello.totaleArticoli() %></span>
        	</a>
        </li>
        <li><a href="#">
        	<span class="glyphicon glyphicon-user"></span> <%= username %>
        	</a>
        </li>
        <li><a href="logout.jsp">
        	<span class="glyphicon glyphicon-off"></span>Logout
        	</a>
        </li>
      </ul>
    <%
    	}
    %>
    </div>
    </div>
</nav>