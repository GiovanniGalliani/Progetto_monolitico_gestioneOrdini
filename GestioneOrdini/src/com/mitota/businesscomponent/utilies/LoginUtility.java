package com.mitota.businesscomponent.utilies;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mitota.architecture.dao.DAOConstants;
import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dbaccess.DBAccess;

public class LoginUtility implements DAOConstants {
	private Connection conn;

	public LoginUtility() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public String getUserPass(String username) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_USERPASS);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString(1);
			return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public String getUserAdminPass(String username) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ADMINPASS);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString(1);
			return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	
	
}
