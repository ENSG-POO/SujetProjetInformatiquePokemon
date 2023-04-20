package gestion_jeu;

import java.util.ArrayList;
import java.util.List;

import pack1.ListePoke;
import pack1.PokeSauvage;
import pack1.Pokemon;
import pack1.coord;

public class Jeu {
	
	public List<Pokemon> listPokeS;
	
	public Jeu(List<Pokemon> listPokeS) {
		this.listPokeS = listPokeS;
	}
	
	public Pokemon[] getPokedex (Joueur joueur){
		return joueur.pokedex;
	}
	
	public void deplacement(coord new_coord, Joueur joueur) {
		joueur.position = new_coord;
	}
	
	public Pokemon[] prochePok()
	 public Pokemon closerPoke(coord position ) { // à finir 
		 ListePoke l1 = new ListePoke();
		 coord c1 = l1.GetListePoke(1).position;
	    	
	    	
	    	return null;
	    	
	

	}
	
	

}
