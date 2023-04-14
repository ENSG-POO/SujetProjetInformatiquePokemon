package pack1;

public class Pokemon {
	
	public String name;
	public String type1; 
	public String type2; 
	public double HP; 
	public double total; 
	public double attack;
	public double defense; 
	public double spAtk; 
	public double spDef; 
	public double speed; 
	public double generation;
	public String legendary; 
	public int id;
	
	public Pokemon (int id, String name, String type1, String type2, double total, double HP, double attack, double defense, double spAtk, double spDef, double speed, double generation, String legendary) {
		this.id = id;
		this.name = name; 
		this.type1 = type1; 
		this.type2 = null;
		this.HP = HP; 
		this.total = total; 
		this.attack = attack; 
		this.defense = defense; 
		this.spAtk = spAtk; 
		this.spDef = spDef; 
		this.speed = speed; 
		this.generation = generation; 
		this.legendary = legendary;
		
	}
	
	@Override
	public String toString() {
		return "Pokemon [id=" + this.id + ", nom=" + this.name + ", type=" + this.type1 + ", type2=" + this.type2 + this.total + this.HP + this.attack + this.defense + this.spAtk + this.spDef + this.speed + this.generation + this.legendary;
	}
	
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
