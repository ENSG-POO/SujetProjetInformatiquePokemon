package pokemons;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PokedexS {
	public List<PokemonSauvage> lstPokeS;
    
	public PokedexS(String filecoord) {
		String csvFile = filecoord;
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	    List<Pokemon> lstPoke = new ArrayList<>();


	    try {

	        br = new BufferedReader(new FileReader(csvFile));
	        br.readLine();
	        while ((line = br.readLine()) != null) {
	        	String[] pokemon_coord = line.split(cvsSplitBy);
	        	
	        	//replace("\",\"", "")
	        	String name = pokemon_coord[0];
	        	String x_str = pokemon_coord[1];
	        	String y_str = pokemon_coord[2];
	        	
	        	String x = (x_str.replace("[", "").replace("\"", "").replace(" ", ""));
	        	String y = (y_str.replace("]", "").replace("\"", "").replace(" ", ""));
	        	
	        	
	        	System.out.println(name);
	        	System.out.println(x);
	        	System.out.println(y);

	        }
	            
	        	
	            /*String name = pokemon_attribute[1];
	            String type = pokemon_attribute[2];
	            int pv = Integer.parseInt(pokemon_attribute[5]);
	            int attack = Integer.parseInt(pokemon_attribute[6]);
	            int defense = Integer.parseInt(pokemon_attribute[7]);
	            int speed = Integer.parseInt(pokemon_attribute[8]);
	            
	            Pokemon poke = new Pokemon(name, type, pv, attack, defense, speed);
	            
	            lstPoke.add(poke);*/
	            
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
	    
	}

	   //this.lstPoke = lstPoke; 
	   
		/*
		String csvFile = filecoord;
        String line = "";
        String[] separators = {"[", "]"};
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            while ((line = reader.readLine()) != null) {
                String[] fields = null;
                for (String separator : separators) {
                    fields = line.split(separator);
                    if (fields.length > 1) {
                        break;
                    }
                }
                for (String field : fields) {
                    System.out.print(field + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}*/
	/*
	@Override
	public String toString() {
		String str = "";
		for (Pokemon elt : lstPoke) {
			str += elt.toString() + "\n"; 
		}
		return str;
	}*/

}