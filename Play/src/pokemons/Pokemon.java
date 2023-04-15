package pokemons;
//import java.util.List;

public class Pokemon {
	public String name;
	public String type;
	public int pv;
	public int attack;
	public int defense;
	public int speed;
	
	//private List<Attaques> attaques;
	
	public Pokemon(String name, String type) {
	this.name = name;
	this.type = type;
	}
	
	public Pokemon(String name, String type, int pv, int attack, int defense, int speed) {
		this.name = name;
		this.type = type;
		this.pv = pv;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
	}
	
	//Setters
	
	
	//Getters
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public int getPV(){
		return pv;
	}
	public int getAttack() {
		return attack;
	}
	public int getDefense() {
		return defense;
	}
	public int getSpeed() {
		return speed;
	}
	
	
	
	
	@Override
	public String toString() {
		return name + ": type " + type + " - "+ pv + " PV - Att " + attack + " - Def " + defense + " - Sp " + speed;
	}

}
