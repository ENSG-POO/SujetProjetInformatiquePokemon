package gestion_jeu;

import pack1.ListePoke;
import pack1.Pokemon;
import pack1.coord;

public class Jeu {
	
	/*public List<Pokemon> listPokeS;
	
	public Jeu(List<Pokemon> listPokeS) {
		this.listPokeS = listPokeS;
	}*/
	
	public Pokemon[] getPokedex (Joueur joueur){
		return joueur.pokedex;
	}
	
	public void deplacement(coord new_coord, Joueur joueur) {
		joueur.position = new_coord;
	}
	
	 public Pokemon[] closerPoke(Joueur Joueur ) {
		 Pokemon[] p1 = new Pokemon[10];
		 int j = 0;
		 ListePoke l1 = new ListePoke();
		 for(int i = 0; i < l1.ListePoke.length; i++) {
		 coord c1 = l1.ListePoke[i].position;
		 if(Joueur.position.distance(c1)<3) {
			 p1[j]=l1.ListePoke[i];
			 j++;
			 }
		 }
	    	
	    	
	    	return p1;
	    	
	

	}
	
	

}
