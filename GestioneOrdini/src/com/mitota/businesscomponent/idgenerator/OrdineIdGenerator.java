package com.mitota.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mitota.architecture.dao.DAOConstants;
import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dbaccess.DBAccess;

public class OrdineIdGenerator implements IdGeneratorInterface, DAOConstants {
	private static OrdineIdGenerator idGen;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private OrdineIdGenerator() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public static OrdineIdGenerator getInstance() throws ClassNotFoundException, DAOException, IOException {
		if(idGen == null)
			idGen = new OrdineIdGenerator();
		return idGen;
	}

	@Override
	public long getNextId() throws ClassNotFoundException, DAOException, IOException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ORDINESEQ);
			rs.next();
			id = rs.getLong(1);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return id;
	}
}
