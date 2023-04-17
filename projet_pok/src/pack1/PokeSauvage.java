package pack1;

public class PokeSauvage{
	
	private String name;
	private String positionX;
	private String positionY;
	/*
	public PokeSauvage(int id, String name, String type1, String type2, double total, double HP, double attack, double defense, double spAtk, double spDef, double speed, double generation, String legendary, coord position) {
		super(id, name, type1, type2, total, HP, attack, defense, spAtk, spDef, speed, generation, legendary);
		this.position = position;
	}*/
	
	public PokeSauvage(String name, String positionX, String positionY) {
		this.name = name;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public String getName() {
    	return this.name;
    }
	
	public String getPositionX() {
    	return this.positionX;
    }
	
	public String getPositionY() {
    	return this.positionY;
    }
	
	//double positionXDouble = Double.parseDouble(positionX);
    //double positionYDouble = Double.parseDouble(positionY);
	
	@Override
	public String toString() {
		return "name= " + this.name + ", X= " + this.positionXDouble.replace("[", "").replace("]", "").replace("\"", "") + ", Y=" + this.positionYDouble.replace("[", "").replace("]", "").replace("\"", "");
	}
	
}
	
	
