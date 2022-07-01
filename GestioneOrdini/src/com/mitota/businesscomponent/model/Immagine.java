package com.mitota.businesscomponent.model;

public class Immagine {
	private long idImmagine;
	private String url;
	private String descrizione;
	public long getIdImmagine() {
		return idImmagine;
	}
	public void setIdImmagine(long idImmagine) {
		this.idImmagine = idImmagine;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	@Override
	public String toString() {
		return "Immagine [idImmagine=" + idImmagine + ", url=" + url + ", descrizione=" + descrizione + "]";
	}
	
	
	
}
