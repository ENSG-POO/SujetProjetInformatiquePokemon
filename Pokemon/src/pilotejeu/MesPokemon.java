package pilotejeu;

import java.util.Arrays;
import java.util.Scanner;

public class MesPokemon extends pokemon  {

	String[] pokemon_possible = {"Bulbasaur","Cahrmander","Squirtle"};
	
	
	public MesPokemon(String nom, double HP, double vitesse, String type1, String type2, double Att, double Def) {
		super(nom,HP,vitesse,type1,type2,Att,Def);
	}
	
	
	
	
	
	
	
	public String[] Mon_pokedex(String pokemonChoisi) {
		String[] liste = {pokemonChoisi};
		
		return liste;
	}
	
	
    
    
		
		
		
		
		
	public static void main(String[] args) {
		
		String[] pokemon_possible = {"Bulbasaur","Charmander","Squirtle"};
        
        System.out.println("Choisi ton pokémon de depart :");
        for (int i = 0; i < pokemon_possible.length; i++) {
            System.out.println(i + 1 + ". " + pokemon_possible[i]);
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez sélectionner un Pokémon (1-" + pokemon_possible.length + "): ");
        int choix = scanner.nextInt();
        
        if (choix < 1 || choix > pokemon_possible.length) {
            System.out.println("Choix invalide.");
        } else {
            String pokemonChoisi = pokemon_possible[choix - 1];
            
            System.out.println("Vous avez choisi " + pokemonChoisi + ".");
        
		
	    pokemon mon_pokemon = new pokemon(pokemonChoisi);
	    
	    
	    
	    System.out.println(mon_pokemon.toString());
        
        
        }
        String pokemonChoisi = pokemon_possible[choix - 1];
        //System.out.println("Vous avez choisi " + pokemonChoisi + ".");
        pokemon mon_pokemon = new pokemon(pokemonChoisi);
        //System.out.println(mon_pokemon.toString());

        MesPokemon mes_pokemon = new MesPokemon(pokemonChoisi, mon_pokemon.getHP(), mon_pokemon.getVitesse(), mon_pokemon.getType1(), mon_pokemon.getType2(), mon_pokemon.getAtt(), mon_pokemon.getDef());

        String[] pokedex = mes_pokemon.Mon_pokedex("Mon pokedex contient " +pokemonChoisi);
        System.out.println(Arrays.deepToString(pokedex));
	}

}


