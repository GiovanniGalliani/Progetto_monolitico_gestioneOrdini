package com.mitota.architecture.dao;

import java.sql.Connection;
import com.mitota.businesscomponent.model.Utente;

public abstract class UtenteAdapter implements GenericDAO<Utente>, DAOConstants {

	@Override
	public void create(Connection conn, Utente entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, Utente entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utente getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Connection conn, String username) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}