package pack1;

public class coord {
	public double x; 
	public double y; 
	
	public coord (double x, double y) {
		this.x = x; 
		this.y = y; 
	}
	
	public double distance (coord c1) {
		return Math.sqrt(Math.pow(c1.x-this.x, 2) + Math.pow(c1.y, this.y));
	}
	
	public String toString() {
		return "X=" + this.x +" " +"Y=" + this.y ;
	}
	
	public static void main(String[] args) {
		coord coord1 = new coord(0,0);
		System.out.println(coord1);
	}

}
