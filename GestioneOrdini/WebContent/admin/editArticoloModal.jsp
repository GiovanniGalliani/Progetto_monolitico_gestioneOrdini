<%@page import="com.mitota.businesscomponent.facade.AdminFacade"%>
<%@page import="com.mitota.businesscomponent.model.Articolo"%>
<%
long id = Long.parseLong(request.getParameter("id"));
Articolo a = null;
if (request.getParameter("id") == null) {
	response.sendRedirect("admin/gestioneArticoli.jsp");
} else {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
a = AdminFacade.getInstance().getArticoloByID(id);
if (a == null)
	a = new Articolo();
%>
<div class="modal fade" id="editModal_<%=id%>" role="dialog">
	<div class="modal-dialog modal-md">
		<form
			action="/<%=application.getServletContextName()%>/inserisciArticolo"
			method="post">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						Modifica/Inserimento articolo
						<%=id > 0 ? id : ""%>
					</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" name="id" value="<%=a.getIdArticolo()%>">
					<div class="form-group">
						<label for="marca">Marca</label> <input type="text" name="marca"
							class="form-control"
							value="<%=a.getMarca() == null ? "" : a.getMarca()%>">
					</div>
					<div class="form-group">
						<label for="modello">Modello</label> <input type="text"
							name="modello" class="form-control"
							value="<%=a.getModello() == null ? "" : a.getModello()%>">
					</div>
					<div class="form-group">
						<label for="prezzo">Prezzo</label> <input type="number"
							name="prezzo" class="form-control" step="0.01"
							value="<%=a.getPrezzo()%>">
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success btn-l">Salva
						modifiche</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Annulla</button>
				</div>
			</div>
		</form>
	</div>
</div>
<%
}
%>