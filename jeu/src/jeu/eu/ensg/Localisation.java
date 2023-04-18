package jeu.eu.ensg;

public class Localisation {
	private String nom;
	private Coordonnee position;
	private int id;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Localisation [nom=" + nom + ", position=" + position + ", id=" + id + "]";
	}
	
	

}
