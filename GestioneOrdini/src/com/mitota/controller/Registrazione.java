package com.mitota.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mitota.businesscomponent.facade.ClientFacade;
import com.mitota.businesscomponent.model.Utente;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/registra")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 4189762727550286889L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Utente utente = new Utente();
		
		try {
			utente.setNome(request.getParameter("nome"));
			utente.setCognome(request.getParameter("cognome"));
			utente.setIndirizzo(request.getParameter("indirizzo"));
			utente.setCap(request.getParameter("cap"));
			utente.setNascita(formato.parse(request.getParameter("nascita")));
			String username = request.getParameter("username");
			utente.setUsername(username);
			utente.setPassword(request.getParameter("password"));
			utente.setEmail(request.getParameter("email"));
			ClientFacade cF = ClientFacade.getInstance();
			cF.createUtente(utente);
			session.setAttribute("username", username);
			response.sendRedirect("acquisti.jsp");
		} catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}

}
