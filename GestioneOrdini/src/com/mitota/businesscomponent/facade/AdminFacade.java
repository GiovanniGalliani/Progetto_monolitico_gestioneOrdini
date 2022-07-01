package com.mitota.businesscomponent.facade;

import java.io.IOException;

import com.mitota.architecture.dao.DAOException;
import com.mitota.businesscomponent.ArticoloBC;
import com.mitota.businesscomponent.model.Articolo;

public class AdminFacade {
	private static AdminFacade aF;
	private ArticoloBC aBC;
	
	private AdminFacade() {
		
	}
	
	public static AdminFacade getInstance() {
		if(aF == null) {
			aF = new AdminFacade();
		}
		return aF;
	}
	
	public void createOrUpdateArticolo(Articolo articolo)
			throws DAOException, ClassNotFoundException, IOException {
		aBC = new ArticoloBC();
		aBC.createOrUpdate(articolo);
	}
	
	public Articolo getArticoloByID(long id) 
			throws ClassNotFoundException, DAOException, IOException {
		aBC = new ArticoloBC();
		return aBC.getByID(id);
	}
	
	public Articolo[] getArticoli() throws ClassNotFoundException, DAOException, IOException {
		aBC = new ArticoloBC();
		return aBC.getArticoli();
	}
	
	public void delete(long id) throws ClassNotFoundException, DAOException, IOException {
		aBC = new ArticoloBC();
		aBC.delete(id);
	}
	
}