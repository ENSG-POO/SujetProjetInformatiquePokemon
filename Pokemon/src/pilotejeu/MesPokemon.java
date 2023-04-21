package pilotejeu;

import java.util.Arrays;
import java.util.Scanner;

public class MesPokemon   {
	// Classe qui permet de demander à l'utilisateur son pokemon de départ ainsi que la construction de son pokedex
	
	String[] pokemon_possible = {"Nidoking","Charizard","Tentacool"};
	 String pokedex = choix_firstPokemon();
	

	
	public  String choix_firstPokemon() {
		 System.out.println("Choisi ton pokémon de depart :");
	        for (int i = 0; i < pokemon_possible.length; i++) {
	            System.out.println(i + 1 + ". " + pokemon_possible[i]);
	        }
	        
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Veuillez sélectionner un Pokémon (1-" + pokemon_possible.length + "): ");
	        int choix = scanner.nextInt();
	        String pokemonChoisi = "";
	        
	        if (choix < 1 || choix > pokemon_possible.length) {
	            System.out.println("Choix invalide.");
	        } else {
	            pokemonChoisi = pokemon_possible[choix - 1];
	            
	            System.out.println("Vous avez choisi " + pokemonChoisi + ".");
	            
	}
	        return pokemonChoisi;     
	}
	
	public String ajout_pokedex(pokemon pokemon_S) {
		pokedex = pokedex +" "+ pokemon_S.getNom();
		return pokedex;
	}

	
	public String toString() {
		return "Mon pokedex contient " + this.pokedex;
	}
	
	
		
	public static void main(String[] args) {
		
		MesPokemon P = new MesPokemon();
	    
		//String pokemonChoisi = P.choix_firstPokemon();
	    //System.out.println(pokemonChoisi);
	    System.out.println(P.toString());
	    
	   
		
		
}
}


