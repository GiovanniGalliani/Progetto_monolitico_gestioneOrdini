package com.mitota.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mitota.businesscomponent.Carrello;
import com.mitota.businesscomponent.facade.ClientFacade;
import com.mitota.businesscomponent.model.Articolo;

@WebServlet("/aggiungiCarrello")
public class AggiungiCarrello extends HttpServlet {
 private static final long serialVersionUID = -8399814575492370113L;

 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
   throws ServletException, IOException {
  
  HttpSession session = request.getSession();
  Carrello carrello = (Carrello) session.getAttribute("carrello");
  
  long id = Long.valueOf(request.getParameter("id"));
 
  Articolo articolo;
  try {
   articolo = ClientFacade.getInstance().getArticoloByID(id);
   if(id != 0) {
    carrello.aggiungiArticolo(
      Long.toString(id),
      articolo.getMarca(),
      articolo.getModello(), 
      articolo.getPrezzo());
   }
   response.sendRedirect("acquisti.jsp");
   
  } catch (Exception exc) {
   exc.printStackTrace();
  }
 }
}