
package jeu.eu.ensg;

import java.util.ArrayList;
import java.util.List;

public class Dresseur extends Inventaire {
	private String nom;
	private Coordonnee coord;
	private List<Pokemon> pokemons_joueur;

	public Dresseur(String nom, Coordonnee coord, List<Pokemon> pokemons_joueur) {
		//super(inventaire);
		this.nom = nom;
		this.coord = coord;
		this.pokemons_joueur = pokemons_joueur;
	}
	
	

	public Dresseur(String nom) {
		this.nom = nom;
		List<Pokemon> pokemons_joueur = new ArrayList<Pokemon>();
		Pokemon p1 = new Pokemon(1,"Bulbasaur","Plante","Poison",318,45,49,49,65,65,45,1,"legendaire", 77);
		Pokemon p2 = new Pokemon(2,"Ivysaur","Plante","Poison",405,60,62,63,80,80,60,1,"legendaire",76);
		Pokemon p3 = new Pokemon(3,"Venusaur","Plante","Poison",525,80,82,83,100,100,80,1,"legendaire",79);
		pokemons_joueur.add(p1);
		pokemons_joueur.add(p2);
		pokemons_joueur.add(p3);
		this.pokemons_joueur = pokemons_joueur;
	}



	public double distance(Coordonnee c1, Coordonnee c2) {
		double selon_x = c1.getX() - c2.getX();
		double selon_y = c1.getY() - c2.getY();
		return Math.sqrt(selon_x * selon_x + selon_y * selon_y);
	}

	public List<Localisation> PokemonsProches(Carte carte) {
		List<Localisation> proches = new ArrayList<Localisation>();
		for (Localisation p : carte.getPokemons()) {
			if (distance(this.coord, p.getPosition()) < 30) {
				proches.add(p);
			}
		}
		return proches;

	}
	
	public String[] getNomsPokemons() {
		List<Pokemon> pokemons_joueur = this.pokemons_joueur;
		String[] noms = new String[pokemons_joueur.size()];
		for (int i=0; i<pokemons_joueur.size(); i++) {
			noms[i] = pokemons_joueur.get(i).getName();
			System.out.println("tatat" + noms[i]);
		}
		return noms;
		
	}

	public void setCoord(Coordonnee coord) {
		this.coord = coord;
	}

	
	
}
