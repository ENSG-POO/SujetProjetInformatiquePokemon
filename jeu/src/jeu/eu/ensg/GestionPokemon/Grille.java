package jeu.eu.ensg.GestionPokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grille {
	public double x;
	public double y;
	public String nom;
	public Boolean visibility;
	
	
	public Grille (double x,double y,String nom,Boolean visibility) {
		this.x=x;
		this.y=y;
		this.nom=nom;
		this.visibility=visibility;
		}
	
	public String toString() {
	    return "[nom=" + getNom() + ", x=" + getX() + ", y=" + getY() + "]";
	}
		
	public static List<Grille> SauvageList () { //prends le csv des coord des pokemons et le met en liste et en éléments
		String csvFilePath = "D:\\\\DeBockRosierMiras\\\\data\\\\pokemon_coordinates.csv";
        String line;
        List<Grille> coordonnees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
            	if (isFirstLine) {
                    isFirstLine = false;
                    continue; // skip the first line which is the header
                }
                String[] values = line.split(",");
                String nom = values[0].trim();
                String X = values[1].replace("\"[","");
                String Y = values[2].replace("]\"","");
                double x = Double.parseDouble(X)*50;
                double y = Double.parseDouble(Y)*100;

                Grille coord = new Grille(x, y, nom, false);
                coordonnees.add(coord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coordonnees;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double xd) {
		this.x=xd;
	}
	
	public void setY(double yd) {
		this.y=yd;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public Boolean getVisibility() {
		return visibility;
	}
	
	public void setVisible() {
		this.visibility=true;
	}
}
