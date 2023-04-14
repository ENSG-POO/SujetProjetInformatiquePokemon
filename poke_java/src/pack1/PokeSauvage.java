package pack1;

public class PokeSauvage extends Pokemon{
	
	public coord position;
	
	public PokeSauvage (int id, String name, String type1, String type2, double total, double HP, double attack, double defense, double spAtk, double spDef, double speed, double generation, String legendary, coord position) {
		super(id, name, type1, type2, HP, total, attack, defense, spAtk, spDef, speed, generation, legendary);
		this.position = position;
		
		
	}

}
