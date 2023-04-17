package pack1;

public class Pokemon {
	
	private int id;
	private String name;
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
    
    public int getId() {
    	return this.id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void setNom(String name) {
    	this.name = name;
    }
    
    public String getType1() {
    	return this.type1;
    }
    
    public void setType1(String type1) {
    	this.type1 = type1;
    }
    
    public String getType2() {
    	return this.type2;
    }
    
    public void setType2(String type2) {
    	this.type2 = null;
    }
    
    public double getTotal() {
    	return this.total;
    }
    
    public void setTotal(double total) {
    	this.total = total;
    }


    @Override
    public String toString() {
        return "Pokemon [id=" + this.id + ", nom=" + this.name + ", type=" + this.type1 + ", type2=" + this.type2 + 
        		", HP=" + this.HP + ", Total=" + this.total + ", Attack=" + this.attack + ", Defense=" + this.defense + 
        		", spAtk=" + this.spAtk + ", spDef=" + this.spDef + ", speed=" + this.speed + 
        		", Generation=" + this.generation + ", Legendary=" + this.legendary +"]";
    }
    
}
