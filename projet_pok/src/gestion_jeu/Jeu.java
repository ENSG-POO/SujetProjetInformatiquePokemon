package gestion_jeu;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pack1.ListePoke;
import pack1.Pokemon;
import pack1.coord;

public class Jeu {
	
	//classe qui permet de piloter le Jeu
	
	public Jeu() {}
	
	public Pokemon[] getPokedex (Joueur joueur){
		return joueur.pokedex;
	}
	
	public void deplacement(coord new_coord, Joueur joueur) {
		joueur.position = new_coord;
	}
	 
	 public List<Pokemon> trouverPokemonProche(int k, double x, double y) {
		 //méthode qui pemet de trouver les pokémons qui sont autour du joueur en fonction de sa position et de ses déplacements
	     
		 ListePoke listePoke = new ListePoke();
		 List<Pokemon> pokemons = Arrays.asList(listePoke.ListePoke);
	        for (Pokemon p : pokemons) {
	            double distance = Math.sqrt(Math.pow(p.getPosition().getX() - x, 2) + Math.pow(p.getPosition().getY() - y, 2));
	            p.setDistance(distance);
	        }
	        
	        Collections.sort(pokemons, new Comparator<Pokemon>() {
	            @Override
	            public int compare(Pokemon p1, Pokemon p2) {
	                return Double.compare(p1.getDistance(), p2.getDistance());
	            }
	        });        
	        return pokemons.subList(0, k);
	 }

	
	 public String[] listToString(List<Pokemon> pokemon) {
		 // fonction qui permet de transformer une liste de pokémons en un tableau contenant les noms des pokémons
		 //Cette fonction est utile pour afficher les pokémons proches dans un JComboBox dans l'interface graphique 
		 String [] liste = new String[] {"elem1", "elem2", "elem3", "elem4", "elem5"};
		 for (int i = 0; i < liste.length; i++) {
			 Pokemon p = pokemon.get(i);
			 liste[i] = p.getName();
		 }
		 
		 return liste;
	 }
	 
}

	


