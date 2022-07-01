package com.mitota.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.mitota.businesscomponent.model.OrdineArticolo;

public class OrdineArticoloDAO extends OrdineArticoloAdapter implements DAOConstants {

	private CachedRowSet rowSet;

	private OrdineArticoloDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public static OrdineArticoloDAO getFactory() throws DAOException {
		return new OrdineArticoloDAO();
	}

	@Override
	public void create(Connection conn, OrdineArticolo entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_ORDINEARTICOLO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getIdOrdine());
			rowSet.updateLong(2, entity.getIdArticolo());
			rowSet.updateInt(3, entity.getQuantita());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}


}