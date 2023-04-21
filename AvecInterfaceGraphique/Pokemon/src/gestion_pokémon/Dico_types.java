package gestion_pokémon;

import java.util.HashMap;
import java.util.Map;

public interface Dico_types {
	
	public static final Map<String, Integer> TypeInt =new HashMap<String, Integer>() {{
		put("Steel",0);
		put("Fighting",1);
		put("Dragon",2);
		put("Water",3);
		put("Electric",4);
		put("Fire",5);
		put("Fairy",6);
		put("Ice",7);
		put("Bug",8);
		put("Normal",9);
		put("Grass",10);
		put("Poison",11);
		put("Psychic",12);
		put("Rock",13);
		put("Ground",14);
		put("Ghost",15);
		put("Dark",16);
		put("Flying",17);
		}};

}
