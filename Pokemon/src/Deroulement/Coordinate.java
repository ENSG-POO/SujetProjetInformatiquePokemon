package Deroulement;

public class Coordinate {
	
	private double x;
	private double y;
	
	public Coordinate(double x,double y){
		this.x = x ;
		this.y = y ;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public Coordinate translater(double dx, double dy) {
		this.x = this.x + dx;
		this.y = this.y + dy;
		return new Coordinate(x,y);
	}

}
