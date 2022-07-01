package com.mitota.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dao.OrdineDAO;
import com.mitota.architecture.dbaccess.DBAccess;
import com.mitota.businesscomponent.idgenerator.OrdineIdGenerator;
import com.mitota.businesscomponent.model.Ordine;

public class OrdineBC {
	private Connection conn;
	
	public OrdineBC () throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(Ordine ordine) throws DAOException, ClassNotFoundException, IOException {
		try {
			ordine.setIdOrdine(OrdineIdGenerator.getInstance().getNextId());
			ordine.setData(new Date());
			OrdineDAO.getFactory().create(conn,  ordine);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
 	}
	
	public Ordine[] getOrdini() throws DAOException {
		Ordine[] ordini = null;
		try {
			ordini = OrdineDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return ordini;
	}
	
	public void delete(long id) throws DAOException {
		try {
			OrdineDAO.getFactory().delete(conn,id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		}
	}
