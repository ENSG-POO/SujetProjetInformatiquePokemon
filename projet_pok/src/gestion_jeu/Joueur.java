package gestion_jeu;

import java.util.ArrayList;
import java.util.List;

import pack1.Pokemon;
import pack1.coord;

public class Joueur {
	
	public String name;
	//public Pokemon[] pokedex; 
	public coord position;
	
	public Joueur (String name, coord position) {
		this.name = name; 
		//this.pokedex = pokedex ;
		this.position = position;
	}
	
	/*
	@Override 
	public String toString() {
		return "nom=" + this.name + "poke=" + this.pokedex + "position=" + this.position;
	}
	
	public void setJoueur (String new_name, Pokemon[] new_pokedex ) {
		this.name = new_name;
		this.pokedex = new_pokedex;
	}
	
	public void setPosition(coord new_position) {
		this.position = new_position;
	}*/
}
