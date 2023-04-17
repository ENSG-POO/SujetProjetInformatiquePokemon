package jeu.eu.ensg;

import java.util.List;
import java.util.ArrayList;

public class Pokemon {

	private String nom;
	private Statistiques stats;
	private int HP;
	private Coordonnee position;
	private Type type;
	private List<Attaque> listAtck;
	
	public Pokemon(String nom, Statistiques stats, Coordonnee position, Type type) {
		this.nom = nom;
		this.stats = stats;
		HP = this.stats.getHpMax();
		this.position = position;
		this.type = type;
		this.listAtck = new ArrayList<Attaque>();
	}
	
    public static int trouverIndiceLigne(String[][] tableau, String element) {
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i][1].equals(element)) {
                return i;
            }
        }
        return -1;
    }
	
	public Pokemon(String[][] tablePokemonEtCoord, String[][] tableInfosPokemons, Integer ligne1) {
		this.nom = tablePokemonEtCoord[ligne1][0];
		Integer ligne2=trouverIndiceLigne(tableInfosPokemons, this.nom);
		this.stats = new Statistiques(tableInfosPokemons,ligne2);
		HP = this.stats.getHpMax();
		this.position = new Coordonnee(tablePokemonEtCoord[ligne1][1]);
		this.type = new Type(tableInfosPokemons[ligne2][2]);
		this.listAtck = new ArrayList<Attaque>();
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
		return this.listAtck;
	}

	public void setListAtck(List<Attaque> listAtck) {
		this.listAtck = listAtck;
	}
	
	
}
