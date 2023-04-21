package déroulé_jeu;

import java.util.Random;

public class Coordinate {

	public int x;
	public int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	
	public Coordinate PositionInitiale(int Dim_jeu) {
		
		Random r = new Random();
		int m = r.nextInt(Dim_jeu);
		int n = r.nextInt(Dim_jeu);
		Coordinate position= new Coordinate(m,n);
		
		return position;
		
	}
	public void Mouvement(int a,Coordinate CoordCS) {
		if ( a == 4) {
			this.setX(this.getX()-1);  
			}
		
		if (a==6) { 
			this.setX(this.getX()+1);   
		}
		
		if (a==5) { 
			this.setY(this.getY()+1);  
		}
		if (a==8) { 
			this.setY(this.getY()-1);  
		}
		
		
		//Téléportation au centre de soins.
		if (a==2) {
			this.setX(CoordCS.getX());
			this.setY(CoordCS.getY());
		}	
		
	}
	
	
	@Override
	public String toString() {
		return "x = " + this.x + "; y = " +this.y;
	}
	
	
	 @Override
	 public boolean equals(Object obj) {
		 if (obj == this) {
			 return true;
	        }
	        
        if (!(obj instanceof Coordinate)) {
            return false;
	        }
	        
        Coordinate other = (Coordinate) obj;
	        
	        // Comparaison des valeurs x et y
        return this.x == other.x && this.y == other.y;
	    }

}

