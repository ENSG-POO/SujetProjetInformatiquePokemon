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
	

	  public static ArrayList<String[]> findObjectsWithinDistance(String[][] objects, double[] targetCoordinate, double distance) {
		    ArrayList<String[]> result = new ArrayList<String[]>();

		    for (int i = 0; i < objects.length; i++) {
		      String[] object = objects[i];
		      String name = object[0];
		      double x = Double.parseDouble(object[1].substring(1, object[1].indexOf(",")));
		      double y = Double.parseDouble(object[1].substring(object[1].indexOf(",")+1, object[1].indexOf("]")));

		      double d = Math.sqrt(Math.pow(x-targetCoordinate[0],2) + Math.pow(y-targetCoordinate[1],2));
		      if (d <= distance) {
		        String[] found = {name, Double.toString(x), Double.toString(y)};
		        result.add(found);
		      }
		    }

		    return result;
		  }



	@Override
	public String toString() {
		return "Coordonnee [x=" + x + ", y=" + y + "]";
	}
	
}