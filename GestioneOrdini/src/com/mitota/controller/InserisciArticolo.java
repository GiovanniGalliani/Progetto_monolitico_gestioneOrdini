package com.mitota.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitota.architecture.dao.DAOException;
import com.mitota.businesscomponent.facade.AdminFacade;
import com.mitota.businesscomponent.model.Articolo;


@WebServlet("/inserisciArticolo")
public class InserisciArticolo extends HttpServlet {
	private static final long serialVersionUID = 1812322674642767242L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Articolo art = getArticolo(request);
		if(art != null) {
			try  {
				AdminFacade.getInstance().createOrUpdateArticolo(art);
			} catch(DAOException | ClassNotFoundException exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}
		response.sendRedirect("admin/gestisciArticoli.jsp");
	}
	
	private Articolo getArticolo(HttpServletRequest request) {
		Articolo art = null;
		try {
			long id = Long.valueOf(request.getParameter("id"));
			String marca = request.getParameter("marca");
			String modello = request.getParameter("modello");
			Double prezzo = Double.valueOf(request.getParameter("prezzo"));
			art = new Articolo();
			art.setIdArticolo(id);
			art.setMarca(marca);
			art.setModello(modello);
			art.setPrezzo(prezzo);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return art;
	}

}
