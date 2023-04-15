package pokemons;
//import java.util.List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Pokemon {
	private String name;
	private int pv;
	private String type;
	
	//private List<Attaques> attaques;
	
	public Pokemon(String name, int pv, String type) { //List<Attaques> attaques
		this.name = name;
		this.pv = pv;
		this.type = type;
		//this.attaques = attaques;
	}
	
	
	public List<List<String>> pokemonAttributes() {
		String csvFile = "C:/Users/gosse/Documents/GitHub/Correia_Gosse_Liu/Play/src/pokemons/pokemon_first_gen.csv";
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	    List<List<String>> allPoke = new ArrayList<>();


	    try {

	        br = new BufferedReader(new FileReader(csvFile));
	        br.readLine();
	        while ((line = br.readLine()) != null) {

	            // use comma as separator
	        	
	            String[] pokemon_attribute = line.split(cvsSplitBy);
	            List<String> poke = new ArrayList<>();
	            
	            String name = pokemon_attribute[1];
	            String type = pokemon_attribute[2];
	            String pv = pokemon_attribute[5];
	            String attack = pokemon_attribute[6];
	            String defense = pokemon_attribute[7];
	            String speed = pokemon_attribute[8];
	            //int speed = Integer.parseInt(pokemon_attribute[8]);
	            
	            poke.add(name);
	            poke.add(type);
	            poke.add(pv);
	            poke.add(attack);
	            poke.add(defense);
	            poke.add(speed);
	            
	            allPoke.add(poke);
	            
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
	    return allPoke;
	}
	
	@Override
	public String toString() {
		return name + ": " + pv + "PV";
	}

}
