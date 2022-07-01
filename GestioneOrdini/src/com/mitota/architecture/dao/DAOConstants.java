package com.mitota.architecture.dao;

public interface DAOConstants {
	
	/* ------------------- Client*/
	
	String SELECT_UTENTE = "Select * from utente";
	String SELECT_ORDINE = "Select * from ordine";
	String SELECT_ARTICOLO = "Select * from articolo";
	String SELECT_ORDINEARTICOLO = "Select * from ordine_articolo";
	String SELECT_IMMAGINE = "Select * from immagine";
	
	String SELECT_ORDINESEQ	 = "Select ordine_seq.nextval from dual";
	String SELECT_ARTICOLOSEQ = "Select articolo_seq.nextval from dual";
	
	String SELECT_USERPASS = "Select password from utente where username = ?";
	

	
	
	/* ------------------- Admin*/
	String SELECT_REPORT = "Select * from report";
	
	String SELECT_ADMINPASS = "Select password from amministratore where username = ?";
	
	String DELETE_UTENTE = "Delete from utente where username = ?";
	
	String UPDATE_UTENTE = "Update utente set nome = ?, cognome = ?, indirizzo = ?, cap = ?, nascita = ?, password = ?, email = ? where username = ?";
	
	String DELETE_ORDINE = "Delete from ordine where id_ordine = ?";
	
	String UPDATE_ORDINE = "Update ordine set totale = ?, data = ?, username = ? where id_ordine = ?";
	
	String SELECT_ORDINE_BYID = "Select * from ordine where id_ordine = ?";

	String UPDATE_ARTICOLO = "Update articolo set marca = ?, modello = ?, prezzo = ? where id_articolo = ?";
	
	String DELETE_ARTICOLO = "Delete from articolo where id_articolo = ?";
	
	String SELECT_ARTICOLO_BYID = "Select * from articolo where id_articolo = ?";
}
