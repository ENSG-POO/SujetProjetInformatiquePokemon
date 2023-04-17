package jeu.eu.ensg;

public class Coordonnee {
	
	private double x;
	private double y;
	
	public Coordonnee(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	

	public Coordonnee(String coord) {
		coord = coord.substring(1, coord.length() - 1);
		String[] coords = coord.split(",");
		double x = Double.parseDouble(coords[0].trim());
		double y = Double.parseDouble(coords[1].trim());
		this.x=x;
		this.y=y;
	}



	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void translate(double dx, double dy) {
		this.x +=  dx;
		this.y += dy;
	}
	
	// fonction qui vérifie que le pokémon choisi est proche du joueur
	public boolean cercle(int rayon, Coordonnee centre) {
		return (Math.pow(Math.pow(this.x - centre.x, 2) + Math.pow(this.y - centre.y, 2 ), 0.5) <= rayon);
		
	}
	
	public String[] listePokeDansRange(double[][] tabCoord, Coordonnee coordJoueur) {
		String[] ListePok = new String[];
		for (int i =0 ; i< tabCoord.lenght(); i++) {
			for (int j =0 ; j< tabCoord.lenght(); j++) {
				if (tabCoord[i][j]).cercle(50, coordJoueur){
					ListePok.add(tabCoord[i][0])
				}
			}
		}
	}
	
}
