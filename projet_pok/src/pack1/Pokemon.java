package pack1;

public class Pokemon {
	
	private int id;
	protected String name;
	private String type1; 
	private String type2; 
	private double HP; 
	private double total; 
	private double attack;
	private double defense; 
	private double spAtk; 
	private double spDef; 
	private double speed; 
	private double generation;
	private String legendary;
	
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
    
    public Pokemon() {
    	
    }

    @Override
    public String toString() {
        return "Pokemon [id=" + this.id + ", nom=" + this.name + ", type=" + this.type1 + ", type2=" + this.type2 + 
        		", HP=" + this.HP + ", Total=" + this.total + ", Attack=" + this.attack + ", Defense=" + this.defense + 
        		", spAtk=" + this.spAtk + ", spDef=" + this.spDef + ", speed=" + this.speed + 
        		", Generation=" + this.generation + ", Legendary=" + this.legendary +"]";
    }
    
}
