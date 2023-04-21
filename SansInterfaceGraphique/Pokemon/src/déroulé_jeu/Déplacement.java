package déroulé_jeu;


public class Déplacement extends Coordinate{
	
	public Coordinate position;

	public Déplacement (int CoordX, int CoordY) {
		super(CoordX, CoordY);
	}
	
	public void Mouvement(int a,Coordinate CoordCS) {
		if ( a == 4) {
			this.position.setX(this.getX()-1);  
			}
		
		if (a==6) { 
			this.position.setX(this.getX()+1);   
		}
		
		if (a==5) { 
			this.position.setY(this.getY()+1);  
		}
		if (a==8) { 
			this.position.setY(this.getY()-1);  
		}
		
		if (a==2) {
			this.position = CoordCS;
		}	
		
	}
	
}
	
	




