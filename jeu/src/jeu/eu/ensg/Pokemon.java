package jeu.eu.ensg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pokemon {

	// Déclaration des attributs de la classe Pokemon
	private String nom;
	private Statistiques stats;
	private int HP;
	private Coordinates position;
	private Type type;
	private List<Attaque> listAtck;
	
	// Constructeur de la classe Pokemon
	public Pokemon(String nom, Statistiques stats, Coordinates position, Type type) {
		this.nom = nom;
		this.stats = stats;
		HP = this.stats.getHpMax();
		this.position = position;
		this.type = type;
		List<Attaque> l = new ArrayList<Attaque>();
		this.listAtck = l;
	}
	
	// Méthode statique pour trouver l'indice d'une ligne dans un tableau à deux dimensions
    public static int trouverIndiceLigne(String[][] tableau, String element) {
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i][1].equals(element)) {
                return i;
            }
        }
        return -1;
    }
	
	// Constructeur de la classe Pokemon à partir de deux tableaux de données et d'un indice de ligne
	public Pokemon(String[][] tablePokemonCoord, String[][] infosPokemons, Integer ligne1) {
		// Récupération du nom du Pokemon à partir du tableau de coordonnées
		this.nom = tablePokemonCoord[ligne1][0];
		// Recherche de l'indice de ligne correspondant aux informations du Pokemon dans le tableau d'informations
		Integer ligne2=trouverIndiceLigne(infosPokemons, this.nom);
		// Création d'une instance de la classe Statistiques à partir des informations du Pokemon
		this.stats = new Statistiques(infosPokemons,ligne2);
		// Initialisation des points de vie du Pokemon
		HP = this.stats.getHpMax();
		// Création d'une instance de la classe Coordinates à partir des coordonnées du Pokemon
		this.position = new Coordinates(tablePokemonCoord[ligne1][1],tablePokemonCoord[ligne1][2]);
		// Création d'une instance de la classe Type à partir du type du Pokemon
		this.type = new Type(infosPokemons[ligne2][2]);
		// Initialisation de la liste des attaques du Pokemon
		this.listAtck = new ArrayList<Attaque>();
	}

	// Méthode qui renvoie une chaîne de caractères représentant le Pokemon
	@Override
	public String toString() {
		return this.nom + this.position ;
	}

	// Getters et setters pour les attributs de la classe Pokemon
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
	
	/**
	 * Attribue à un Pokémon une liste d'attaques générées alléatoirement à partir d'une liste d'attaques globale
	 * @param listAtckGlobale liste contenant toutes les attaques possibles
	 * @param nbAtck nombre d'attaques à attribuer
	 * @param typeAtck type de l'attaque à attribuer
	 * @return La liste d'attaque pour le pokemon
	 */
	public void setListAtckRandom(List<Attaque> listAtckGlobale, int nbAtck, Type typeAtck) {
	    // On commence par filtrer la liste globale d'attaques pour ne garder que celles du type voulu
	    List<Attaque> attaquesFiltrees = listAtckGlobale.stream()
	                                        .filter(a -> a.getType().equals(typeAtck))
	                                        .collect(Collectors.toList());
	    // On mélange la liste filtrée
	    Collections.shuffle(attaquesFiltrees);
	    // On ajoute un nombre d'attaques aléatoires à la liste d'attaques du Pokémon
	    for (int i = 0; i < nbAtck; i++) {
	        Attaque attaqueRandom = attaquesFiltrees.get(i);
	        this.listAtck.add(attaqueRandom);
	    }
	}

	/**
	 * Recherche un Pokémon dans une liste par son nom
	 * @param L La liste de Pokémon dans laquelle effectuer la recherche
	 * @param nom Le nom du Pokémon à rechercher
	 * @return L'index du Pokémon dans la liste, ou -1 s'il n'est pas trouvé
	 */
	public static int FindbyName(List<Pokemon> L,String nom) {
	    for (int i = 0;i<L.size();i++) {
	        if (L.get(i).getNom()==nom) {
	            return i;
	        }
	    }
	    return -1;
	}


	
}
