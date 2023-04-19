package GestionPokemon;

public class Capacite {
	private String nom;
	private Type type;
	private String categorie;
	private int puissance;
	private int precision;
	
	// Builder
	public Capacite(String nom, Type t, String c, int pui, int acc) {
		this.nom = nom;
		this.type = t;
		this.categorie = c;
		this.puissance = pui;
		this.precision = acc;
	}

	public String getNom() {
		return nom;
	}

	public Type getType() {
		return type;
	}

	public String getCategorie() {
		return categorie;
	}

	public int getPuissance() {
		return puissance;
	}

	public int getPrecision() {
		return precision;
	}

	
}
