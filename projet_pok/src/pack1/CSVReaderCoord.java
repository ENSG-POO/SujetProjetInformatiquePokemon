package pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderCoord {
	
	private String name;
	private double positionX;
	private double positionY;	
	
	public CSVReaderCoord(String name, double positionX, double positionY) {
		this.name = name;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public String getName() {
    	return this.name;
    }
	
	public double getPositionX() {
    	return this.positionX;
    }
	
	public double getPositionY() {
    	return this.positionY;
    }
	
	@Override
	public String toString() {
		return "name= " + this.name + ", X= " + this.positionX 
				+ ", Y= " + this.positionY;
	}	
	
	
	public static void main(String[] args) {
        String fichier2CSV = "../data/pokemon_coordinates.csv";
        char separateur = ',';

        List<CSVReaderCoord> listeCoords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fichier2CSV))) {
            String ligne;
            boolean ligne1 = true;
            while ((ligne = br.readLine()) != null) {
            	if(ligne1) {
            		ligne1 = false;
            		continue;
            	}
                
                String[] valeurs = ligne.split(String.valueOf(separateur));                
                
                String name = valeurs[0];
                String positionX = valeurs[1];
                String positionY= valeurs[2];
                
                if (positionX != null) {
                    positionX = positionX.trim();
                } //System.out.println(positionX);
                
                if (positionY != null) {
                    positionY = positionY.trim();
                } //System.out.println(positionY);
                
                positionX = positionX.replace("[", "").replace("]", "").replace("\"" , "");
                positionY = positionY.replace("[", "").replace("]", "").replace("\"" , "");
                
                double positionXDouble = Double.parseDouble(positionX.trim());
                double positionYDouble = Double.parseDouble(positionY.trim());
                
                CSVReaderCoord coords = new CSVReaderCoord(name, positionXDouble, positionYDouble);
                
                listeCoords.add(coords);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (CSVReaderCoord coords : listeCoords) {
        	System.out.println(coords.toString());
        }
    }
}
