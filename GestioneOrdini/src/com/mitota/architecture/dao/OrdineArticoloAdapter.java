package com.mitota.architecture.dao;

import java.sql.Connection;

import com.mitota.businesscomponent.model.OrdineArticolo;

public abstract class OrdineArticoloAdapter implements GenericDAO<OrdineArticolo>{

	@Override
	public void create(Connection conn, OrdineArticolo entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, OrdineArticolo entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrdineArticolo getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdineArticolo[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}