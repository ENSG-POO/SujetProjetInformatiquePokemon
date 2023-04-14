package pack1;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
	
	public List<PokeSauvage> listPokeS;
	
	public Jeu(List<PokeSauvage> listPokeS) {
		this.listPokeS = listPokeS;
	}
	
	public List<Pokemon> getPokedex (Dresseur joueur){
		return joueur.pokedex;
	}
	
	public void deplacement(coord new_coord, Dresseur joueur) {
		joueur.position = new_coord;
	}
	
	public List<PokeSauvage> afficherPoke(Dresseur joueur){
		List<PokeSauvage> pokeProche = new ArrayList<PokeSauvage>(); 
		int S = listPokeS.size();
		
		for (PokeSauvage p : this.listPokeS) {
			if (p.position.distance(joueur.position)< 5) {
				
				pokeProche.add(p);
				
			}	
		}
		
		return pokeProche;
		
	}
	
	

}
