package pack1;

import java.awt.Point;


// classe intermédiaire pour manipuler les coordonnées des pokémons
public class coord {
	public double x; 
	public double y; 
	public Point p;
	
	public coord (double x, double y) {
		this.x = x; 
		this.y = y; 
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double distance (coord c1) {
		return Math.sqrt(Math.pow(c1.x-this.x, 2) + Math.pow(c1.y, this.y));
	}
	
	@Override
	public String toString() {
		return "X=" + this.x +" " +"Y=" + this.y ;
	}
	
	public void setCoord(double new_x, double new_y) {
		this.x = new_x;
		this.y = new_y;
	}
	
	public static void main(String[] args) {
		coord coord1 = new coord(0,0);
		System.out.println(coord1);
	}
	
	public coord pointToCoord(Point p) {
		double x = p.x;
		double y = p.y;
		
		coord c1 = new coord(x,y);
		return c1;
	}


}
