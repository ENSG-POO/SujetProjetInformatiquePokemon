package pokemons;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PokedexS extends Pokedex {
	public List<PokemonSauvage> lstPokeS;
    
	public PokedexS(String filecoord, String filename) {
		super(filename);
		String csvFile = filecoord;
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	    List<PokemonSauvage> lstPokeS = new ArrayList<>();


	    try {

	        br = new BufferedReader(new FileReader(csvFile));
	        br.readLine();
	        while ((line = br.readLine()) != null) {
	        	String[] pokemon_coord = line.split(cvsSplitBy);
	        	
	        	//replace("\",\"", "")
	        	String name = pokemon_coord[0];
	        	String x_str = pokemon_coord[1];
	        	String y_str = pokemon_coord[2];
	        	
	        	Double x = Double.parseDouble(x_str.replace("[", "").replace("\"", "").replace(" ", ""));
	        	Double y = Double.parseDouble(y_str.replace("]", "").replace("\"", "").replace(" ", ""));
	        	
	        	Coordonnee coord = new Coordonnee(x, y);
	        	
	        	for(Pokemon poke : lstPoke) {
	        		if ((poke.name).equals(name)) {
	        			String type = poke.type;
	        			int pv = poke.pv;
	        			int attack = poke.attack;
	        			int defense = poke.defense;
	        			int speed = poke.speed;
	        			PokemonSauvage pokeS = new PokemonSauvage(name, type, pv, attack, defense, speed, coord);
	        			lstPokeS.add(pokeS);
	        		}
	        			
	        	} 

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

	   this.lstPokeS = lstPokeS;  
	}
	
	@Override
	public String toString() {
		String str = "";
		for (PokemonSauvage elt : lstPokeS) {
			str += elt.toString() + "\n"; 
		}
		return str + "taille = " + lstPokeS.size();
	}

}