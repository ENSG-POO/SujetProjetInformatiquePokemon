package pokemons;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pokedex {
	public List<Pokemon> lstPoke;

		
	public Pokedex(String filename) {
		String csvFile = filename;
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	    List<Pokemon> lstPoke = new ArrayList<>();


	    try {

	        br = new BufferedReader(new FileReader(csvFile));
	        br.readLine();
	        while ((line = br.readLine()) != null) {
	        	
	            String[] pokemon_attribute = line.split(cvsSplitBy);
	            
	            String name = pokemon_attribute[1];
	            Type type = new Type(pokemon_attribute[2]);
	            int pv = Integer.parseInt(pokemon_attribute[5]);
	            int attack = Integer.parseInt(pokemon_attribute[6]);
	            int defense = Integer.parseInt(pokemon_attribute[7]);
	            int speed = Integer.parseInt(pokemon_attribute[8]);
	            
	            Pokemon poke = new Pokemon(name, type, pv, attack, defense, speed);
	            
	            lstPoke.add(poke);
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	   this.lstPoke = lstPoke; 
	}
	
	@Override
	public String toString() {
		String str = "";
		for (Pokemon elt : lstPoke) {
			str += elt.toString() + "\n"; 
		}
		return str;
	}

}
