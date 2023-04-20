package gestion_jeu;

import java.util.ArrayList;
import java.util.List;

import pack1.Pokemon;
import pack1.coord;

public class Joueur {
	
	public String name;
	public Pokemon[] pokedex; 
	public coord position;
	
	public Joueur (String name, Pokemon[] pokedex, coord position) {
		this.name = name; 
		this.pokedex = pokedex ;
		this.position = position;
	}
	
	@Override 
	public String toString() {
		return "nom=" + this.name + "poke=" + this.pokedex + "position=" + this.position;
	}
	


}
