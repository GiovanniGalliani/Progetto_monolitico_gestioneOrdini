package com.mitota.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitota.architecture.dao.DAOException;
import com.mitota.businesscomponent.facade.AdminFacade;


@WebServlet("/rimuoviArticolo")
public class RimuoviArticolo extends HttpServlet {
	private static final long serialVersionUID = -5503124229981844517L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			if( id!=null)
				AdminFacade.getInstance().delete(Long.valueOf(id));
			response.sendRedirect("admin/gestisciArticoli.jsp");
		} catch (DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}

}
