package jeu.eu.ensg;

public class Localisation {
	private String nom;
	private Coordonnee position;

	public Localisation(String nom, Coordonnee position) {
		this.nom = nom;
		this.position = position;
	}

	public Coordonnee getPosition() {
		return position;
	}

	public String getNom() {
		return nom;
	}

}
