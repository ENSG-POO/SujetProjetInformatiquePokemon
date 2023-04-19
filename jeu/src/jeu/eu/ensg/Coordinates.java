package jeu.eu.ensg;

import java.util.ArrayList;
import java.util.Objects;

public class Coordinates {
	
	private double x;
	private double y;
	public static String none = "Pokemon capturé";
	
	public Coordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	

	public Coordinates(String coord1,String coord2) {
		coord1 = coord1.substring(2, coord1.length());
		coord2 = coord2.substring(0, coord2.length()-2);
		double x = Double.parseDouble(coord1.trim());
		double y = Double.parseDouble(coord2.trim());
		this.x=x;
		this.y=y;
	}

	@Override
	public String toString() {
		return " [" + x + ", " + y + "]";
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
	
	// fonction qui teste si la coordonnée coord en entrée est située dans un rayon 'rayon' autour de l'élément this
	public boolean isNear(Coordinates coord, int rayon) {
		return (Math.pow(Math.pow(this.x - coord.x, 2) + Math.pow(this.y - coord.y, 2 ), 0.5) <= rayon);
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
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
	
