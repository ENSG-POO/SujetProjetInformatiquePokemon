package pack1;

public class PokeDomestique extends Pokemon {
	
	public Dresseur dresseur;
	
	public PokeDomestique(int id, String name, String type1, String type2, double total, double HP, double attack, double defense, double spAtk, double spDef, double speed, double generation, String legendary, Dresseur dresseur) {
		super (id, name, type1, type2, HP, total, attack, defense, spAtk, spDef, speed, generation, legendary);
		this.dresseur = dresseur;
	}

}
