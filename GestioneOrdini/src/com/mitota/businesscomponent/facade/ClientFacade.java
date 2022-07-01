package com.mitota.businesscomponent.facade;

import java.io.IOException;

import com.mitota.architecture.dao.DAOException;
import com.mitota.businesscomponent.ArticoloBC;
import com.mitota.businesscomponent.OrdineArticoloBC;
import com.mitota.businesscomponent.OrdineBC;
import com.mitota.businesscomponent.UtenteBC;
import com.mitota.businesscomponent.model.Articolo;
import com.mitota.businesscomponent.model.Ordine;
import com.mitota.businesscomponent.model.OrdineArticolo;
import com.mitota.businesscomponent.model.Utente;

public class ClientFacade {
	private static ClientFacade cF;
	private UtenteBC uBC;
	private OrdineBC oBC;
	private ArticoloBC aBC;
	private OrdineArticoloBC oaBC;
	
	private ClientFacade() { 
	}
	
	public static ClientFacade getInstance() {
		if (cF == null)
			cF = new ClientFacade();
		return cF;
	}
	
	public void createUtente(Utente utente) throws ClassNotFoundException, DAOException, IOException {
		uBC = new UtenteBC();
		uBC.create(utente);
	}
	
	
	public void createOrdine(Ordine ordine) throws ClassNotFoundException, DAOException, IOException {
		oBC = new OrdineBC();
		oBC.create(ordine);
	}
	
	
	public void createOrdineArticolo(OrdineArticolo oa) throws DAOException, ClassNotFoundException, IOException {
		oaBC = new OrdineArticoloBC();
		oaBC.create(oa);
	}
	

	public Articolo[] getArticoli() throws ClassNotFoundException, DAOException, IOException {
		aBC = new ArticoloBC();
		return aBC.getArticoli();
	}
	
	public Articolo getArticoloByID(long id) 
			   throws ClassNotFoundException, DAOException, IOException {
			  aBC = new ArticoloBC();
			  return aBC.getByID(id);
			 }

}
