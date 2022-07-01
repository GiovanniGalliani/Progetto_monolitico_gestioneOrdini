package com.mitota.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mitota.businesscomponent.utilies.LoginUtility;
import com.mitota.security.AlgoritmoMD5;

/**
 * Servlet implementation class Controllo
 */
@WebServlet("/controllo")
public class Controllo extends HttpServlet {
	private static final long serialVersionUID = 8300633159495698955L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = AlgoritmoMD5.convertiMD5(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		String userpass = null;
		String adminpass = null;
		if(username != null && password !=null ) {
			try {
				LoginUtility lU = new LoginUtility ();
				userpass = lU.getUserPass(username);
				adminpass = lU.getUserAdminPass(username);
				
				if(userpass != null) {
					if(userpass.equals(password)) {
						session.setAttribute("username", username);
						response.sendRedirect("acquisti.jsp");
					} else {
						response.sendRedirect("accessonegato.jsp");
					}
				} else if(adminpass != null) {
					if(adminpass.equals(password)) {
						session.setAttribute("admin", username);
						response.sendRedirect("admin/admin.jsp");
					} else {
						response.sendRedirect("accessonegato.jsp");
					}
				} else {
					response.sendRedirect("accessonegato.jsp");
				}
			} catch (Exception exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}
	}

}
