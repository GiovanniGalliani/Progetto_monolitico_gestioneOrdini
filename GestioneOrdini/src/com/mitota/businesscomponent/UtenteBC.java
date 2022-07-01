package com.mitota.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dao.UtenteDAO;
import com.mitota.architecture.dbaccess.DBAccess;
import com.mitota.businesscomponent.model.Utente;

public class UtenteBC {
	private Connection conn;
	
	public UtenteBC () throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(Utente utente) throws DAOException, ClassNotFoundException, IOException {
		try {
			UtenteDAO.getFactory().create(conn,  utente);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
 	}
	
	public void delete(String username) throws DAOException, ClassNotFoundException, IOException {
		try {
			UtenteDAO.getFactory().delete(conn,  username);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
 	}
	

	}
