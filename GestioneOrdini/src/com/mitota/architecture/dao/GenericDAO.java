package com.mitota.architecture.dao;

import java.sql.Connection;

public interface GenericDAO<T> {
	void create(Connection conn, T entity) throws DAOException;
	void update(Connection conn, T Entity) throws DAOException;
	void delete(Connection conn, long id) throws DAOException;
	T getById(Connection conn, long id) throws DAOException;
	T [] getAll(Connection conn) throws DAOException;
 
}
