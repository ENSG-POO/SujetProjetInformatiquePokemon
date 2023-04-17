package jeu.eu.ensg;

import java.util.List;

public class Pokemon {

	private String nom;
	private Statistiques stats;
	private int HP;
	private Coordonnee position;
	private Type type;
	private List<Attaque> ListAtck;
	
	public Pokemon(String nom, Statistiques stats, int hP, Coordonnee position, Type type, List<Attaque> listAtck) {
		super();
		this.nom = nom;
		this.stats = stats;
		HP = hP;
		this.position = position;
		this.type = type;
		ListAtck = listAtck;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Statistiques getStats() {
		return stats;
	}

	public void setStats(Statistiques stats) {
		this.stats = stats;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public Coordonnee getPosition() {
		return position;
	}

	public void setPosition(Coordonnee position) {
		this.position = position;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Attaque> getListAtck() {
		return ListAtck;
	}

	public void setListAtck(List<Attaque> listAtck) {
		ListAtck = listAtck;
	}
	
	
}
