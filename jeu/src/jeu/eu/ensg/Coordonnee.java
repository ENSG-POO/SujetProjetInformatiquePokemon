package jeu.eu.ensg;

import java.util.ArrayList;

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
	
	// fonction qui teste si la coordonnée coord en entrée est située dans un rayon 'rayon' de l'élément this
	public boolean isNear(Coordonnee coord, int rayon) {
		return (Math.pow(Math.pow(this.x - coord.x, 2) + Math.pow(this.y - coord.y, 2 ), 0.5) <= rayon);
		
	}
	
	public ArrayList<Pokemon> listePokemonsProximite(ArrayList<Pokemon> listePokemonSauvages, int rayon) {
		ArrayList<Pokemon> listePokemonsProximite = new ArrayList<Pokemon>();
		for (int i =0 ; i< listePokemonSauvages.size(); i++) {
				if(this.isNear(listePokemonSauvages.get(i).getPosition(), rayon)) {
					listePokemonsProximite.add(listePokemonSauvages.get(i));
				}
		}
		return listePokemonsProximite;
	}
}
	
