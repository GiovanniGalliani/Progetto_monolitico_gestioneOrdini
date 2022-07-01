package com.mitota.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dao.OrdineArticoloDAO;
import com.mitota.architecture.dbaccess.DBAccess;
import com.mitota.businesscomponent.model.OrdineArticolo;

public class OrdineArticoloBC {
	private Connection conn;
	
	public OrdineArticoloBC () throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(OrdineArticolo oa) throws DAOException, ClassNotFoundException, IOException {
		try {
			OrdineArticoloDAO.getFactory().create(conn,  oa);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
 	}
	

	}
