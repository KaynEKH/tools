package net.kurse.ts2c.utils;

public class LibVal {

	private String libelle;
	private String valeur;
	
	public LibVal(String libelle, String valeur) {
		this.libelle = libelle;
		this.valeur = valeur;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
}
