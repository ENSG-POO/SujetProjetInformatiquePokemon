package pack1;

public class PokeSauvage extends Pokemon{
	
	private String name;
	private double positionX;
	private double positionY;	
	
	public PokeSauvage(String name, double positionX, double positionY) {
		this.name = name;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public String getName() {
    	return this.name;
    }
	
	public double getPositionX() {
    	return this.positionX;
    }
	
	public double getPositionY() {
    	return this.positionY;
    }
	
	@Override
	public String toString() {
		return "name= " + this.name + ", X= " + this.positionX 
				+ ", Y= " + this.positionY;
	}	
}
