package com.mitota.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mitota.architecture.dao.ArticoloDAO;
import com.mitota.architecture.dao.DAOException;
import com.mitota.architecture.dbaccess.DBAccess;
import com.mitota.businesscomponent.idgenerator.ArticoloIdGenerator;
import com.mitota.businesscomponent.model.Articolo;

public class ArticoloBC {
	private Connection conn;

	public ArticoloBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public void createOrUpdate(Articolo articolo) throws DAOException, ClassNotFoundException, IOException {
		try {
			if (articolo.getIdArticolo() > 0)
				ArticoloDAO.getFactory().update(conn, articolo);
			else {
				articolo.setIdArticolo(ArticoloIdGenerator.getInstance().getNextId());
				ArticoloDAO.getFactory().create(conn, articolo);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Articolo[] getArticoli() throws DAOException {
		Articolo[] articoli = null;
		try {
			articoli = ArticoloDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return articoli;
	}

	public Articolo getByID(long id) throws DAOException {
		try {
			return ArticoloDAO.getFactory().getById(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void delete(long id) throws DAOException {
		try {
			ArticoloDAO.getFactory().delete(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Articolo[] searchArticolo(String query) throws DAOException {
		ArrayList<Articolo> lista = new ArrayList<Articolo>();
		String[] criterioDiRicerca = query.toLowerCase().split(" ");

		for (Articolo a : getArticoli())
			for (String s : criterioDiRicerca)
				if (a.getMarca().toLowerCase().contains(s) || a.getModello().toLowerCase().contains(s))
					lista.add(a);

		Articolo[] articoli = new Articolo[lista.size()];
		for (int i = 0; i < lista.size(); i++)
			articoli[i] = lista.get(i);

		return articoli;
	}
}
