package com.mitota.architecture.dao;

import java.sql.SQLException;

public class DAOException extends SQLException{
	private static final long serialVersionUID = 5429809246217753475L;

	private final static int ORA1017 = 1017; 
	private final static int ORA17002 = 17002; 
	private final static int ORA00001 = 0; 
	
	//posso customizzare le casistiche con messaggi diversi in output
	
	private String message;

	@Override
	public String getMessage() {
		return this.message;
	}
	
	public DAOException(SQLException sql) {
		String chiave ="";
		if(sql != null) {
			switch(sql.getErrorCode()) {
			case ORA1017:
				chiave = "Credenziali di accesso al DB errate";
				log(sql);
				break;
			case ORA17002:
				chiave = "I/O exception di Oracle DB. Impossibile connettersi alla base dati";
				log(sql);
				break;
			case ORA00001:
				chiave = "Vincolo di tabella violato";
				log(sql);
				break;
			default:
				chiave = "Eccezione sql non prevista";
				log(sql);
			}
		}
		message = chiave;
	}
	
	private void log(SQLException sql) {
		sql.printStackTrace();
		System.out.println("Motivo: " + sql.getMessage());
		System.out.println("Stato app: " + sql.getSQLState());
		System.out.println("Codice errore: "+ sql.getErrorCode());
		System.out.println("Causa eccezione: "+sql.getCause());
	}
	
	
}
