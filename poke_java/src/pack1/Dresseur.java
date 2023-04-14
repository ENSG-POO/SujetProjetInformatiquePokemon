package pack1;

import java.util.List;

public class Dresseur {
	
	public String name; 
	public List<Pokemon> pokedex; 
	public coord position; 
	
	
	public Dresseur(String name, List<Pokemon> pokedex, coord position) {
		this.name = name; 
		this.pokedex = pokedex;
		this.position = position;
	}
	
	public void addpoke (Pokemon pokemon) {
		this.pokedex.add(pokemon);
	}
	

}
