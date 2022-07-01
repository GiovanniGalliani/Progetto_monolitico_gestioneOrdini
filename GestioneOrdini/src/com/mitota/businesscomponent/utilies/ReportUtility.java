package com.mitota.businesscomponent.utilies;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.mitota.architecture.dao.DAOConstants;
import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dbaccess.DBAccess;

public class ReportUtility implements DAOConstants {
	private Connection conn;

	public ReportUtility() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Vector<String[]> getReport() throws DAOException {
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_REPORT);
			
			ResultSetMetaData meta = rs.getMetaData();
			int nColonne = meta.getColumnCount();
			Vector<String[]> dati = new Vector<String[]>();
			rs.beforeFirst();
			while(rs.next()) {
				String[] riga = new String[meta.getColumnCount()];
				for(int i = 0; i<nColonne; i++) 
					riga[i] = rs.getString(i+1);
				dati.add(riga);	
			}
			return dati;
		}catch (SQLException sql) {
				throw new DAOException(sql);
			}
	}

}
