package jeu.eu.ensg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pokemon {

	private String nom;
	private Statistiques stats;
	private int HP;
	private Coordinates position;
	private Type type;
	private List<Attaque> listAtck;
	
	public Pokemon(String nom, Statistiques stats, Coordinates position, Type type) {
		this.nom = nom;
		this.stats = stats;
		HP = this.stats.getHpMax();
		this.position = position;
		this.type = type;
		List<Attaque> l = new ArrayList<Attaque>();
		this.listAtck = l;
	}
	
    public static int trouverIndiceLigne(String[][] tableau, String element) {
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i][1].equals(element)) {
                return i;
            }
        }
        return -1;
    }
	
	public Pokemon(String[][] tablePokemonCoord, String[][] infosPokemons, Integer ligne1) {
		this.nom = tablePokemonCoord[ligne1][0];
		Integer ligne2=trouverIndiceLigne(infosPokemons, this.nom);
		this.stats = new Statistiques(infosPokemons,ligne2);
		HP = this.stats.getHpMax();
		this.position = new Coordinates(tablePokemonCoord[ligne1][1],tablePokemonCoord[ligne1][2]);
		this.type = new Type(infosPokemons[ligne2][2]);
		this.listAtck = new ArrayList<Attaque>();
	}

	@Override
	public String toString() {
		return this.nom + this.position ;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Statistiques getStats() {
		return this.stats;
	}

	public void setStats(Statistiques stats) {
		this.stats = stats;
	}

	public int getHP() {
		return this.HP;
	}

	public void setHP(int hP) {
		this.HP = hP;
	}

	public Coordinates getPosition() {
		return this.position;
	}

	public void setPosition(Coordinates position) {
		this.position = position;
	}

	public Type getType() {
		return this.type;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(HP, listAtck, nom, position, stats, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return HP == other.HP && Objects.equals(listAtck, other.listAtck) && Objects.equals(nom, other.nom)
				&& Objects.equals(position, other.position) && Objects.equals(stats, other.stats)
				&& Objects.equals(type, other.type);
	}

	public void setListAtckRandom(List<Attaque> listAtckGlobale, int nbAtck, Type typeAtck) {
	    List<Attaque> attaquesFiltrees = listAtckGlobale.stream()
	                                        .filter(a -> a.getType().equals(typeAtck))
	                                        .collect(Collectors.toList());
	    for (int i = 0; i < nbAtck; i++) {
	        Collections.shuffle(attaquesFiltrees);
	        Attaque attaqueRandom = attaquesFiltrees.get(0);
	        this.listAtck.add(attaqueRandom);
	    }
	}

	
}
