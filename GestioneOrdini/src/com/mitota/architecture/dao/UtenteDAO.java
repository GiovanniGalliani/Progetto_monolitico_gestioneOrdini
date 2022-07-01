package com.mitota.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.mitota.businesscomponent.model.Utente;
import com.mitota.security.AlgoritmoMD5;

public class UtenteDAO extends UtenteAdapter implements DAOConstants {

	private CachedRowSet rowSet;

	private UtenteDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public static UtenteDAO getFactory() throws DAOException {
		return new UtenteDAO();
	}

	@Override
	public void create(Connection conn, Utente entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_UTENTE);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, entity.getNome());
			rowSet.updateString(2, entity.getCognome());
			rowSet.updateString(3, entity.getIndirizzo());
			rowSet.updateString(4, entity.getCap());
			rowSet.updateDate(5, new java.sql.Date(entity.getNascita().getTime()));
			rowSet.updateString(6, entity.getUsername());
			rowSet.updateString(7, AlgoritmoMD5.convertiMD5(entity.getPassword()));
			rowSet.updateString(8, entity.getEmail());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	@Override
	public void update(Connection conn, Utente Entity) throws DAOException {
		PreparedStatement ps;
		try {
		ps = conn.prepareStatement(UPDATE_UTENTE);
		ps.setString(1, Entity.getNome());
		ps.setString(2, Entity.getCognome());
		ps.setString(3, Entity.getIndirizzo());
		ps.setString(4, Entity.getCap());
		ps.setDate(5, new java.sql.Date(Entity.getNascita().getTime()));
		ps.setString(6, AlgoritmoMD5.convertiMD5(Entity.getPassword()));
		ps.setString(7, Entity.getEmail());
		ps.setString(8, Entity.getUsername());
		ps.execute();
		conn.commit();

	} catch (SQLException sql) {
		throw new DAOException(sql);
	}
	}

	@Override
	public void delete(Connection conn, String username) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_UTENTE);
			ps.setString(1, username);
			ps.execute();
			conn.commit();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}





}
