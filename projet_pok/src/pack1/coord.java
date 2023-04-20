package pack1;

public class coord {
	public double x; 
	public double y; 
	
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
	
	public coord getCoord() {
	    return new coord(this.getX(), this.getY());
	}
	
	public double distance (coord c1) {
		return Math.sqrt(Math.pow(c1.x-this.x, 2) + Math.pow(c1.y, this.y));
	}
	
	@Override
	public String toString() {
		return "X=" + this.x +" " +"Y=" + this.y ;
	}
	
	public static void main(String[] args) {
		coord coord1 = new coord(0,0);
		System.out.println(coord1);
	}

}
