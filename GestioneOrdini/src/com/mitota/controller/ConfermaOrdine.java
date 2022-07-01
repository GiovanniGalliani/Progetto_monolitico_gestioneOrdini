package com.mitota.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mitota.businesscomponent.Carrello;
import com.mitota.businesscomponent.facade.ClientFacade;
import com.mitota.businesscomponent.model.Ordine;
import com.mitota.businesscomponent.model.OrdineArticolo;

@WebServlet("/conferma")
public class ConfermaOrdine extends HttpServlet {
	private static final long serialVersionUID = -4027756140464607670L;
	private static final String Enumeration = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Carrello carrello = (Carrello) session.getAttribute("carrello");
		Ordine ordine = new Ordine(); 
		ordine.setTotale(carrello.totaleComplessivo());
		ordine.setUsername((String)session.getAttribute("username"));
		
		try {
			ClientFacade cF = ClientFacade.getInstance();
			cF.createOrdine(ordine);
			OrdineArticolo oa;
			Enumeration<String[]> prodotti = carrello.listaProdotti();
			while(prodotti.hasMoreElements()) {
				oa= new OrdineArticolo();
				String[] p = prodotti.nextElement();
				oa.setIdOrdine(ordine.getIdOrdine());
				oa.setIdArticolo(Long.parseLong(p[4]));
				oa.setQuantita(Integer.parseInt(p[3]));
				cF.createOrdineArticolo(oa);
			}
			session.setAttribute("idordine", ordine.getIdOrdine());
			response.sendRedirect("ordine.jsp");
		}catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
			
			
			
			
			
		}
		
	}

}