package Deroulement;

public class Deplacement {
	
	private Coordinate position;
	
	public Coordinate DeplacementG(Coordinate position,int nbcase) {
		//déplacement a gauche
		this.position=new Coordinate(position.getX()-nbcase , position.getY());
		return this.position;
	}
	
	public Coordinate DeplacementD(Coordinate position,int nbcase) {
		//déplacement a droite
		this.position=new Coordinate(position.getX()+nbcase , position.getY());
		return this.position;
	}
	
	public Coordinate DeplacementH(Coordinate position,int nbcase) {
		//déplacement a haut
		this.position=new Coordinate(position.getX() , position.getY()+nbcase);
		return this.position;
	}
	
	public Coordinate DeplacementB(Coordinate position,int nbcase) {
		//déplacement a bas
		this.position=new Coordinate(position.getX() , position.getY()-nbcase);
		return this.position;
	}

}
