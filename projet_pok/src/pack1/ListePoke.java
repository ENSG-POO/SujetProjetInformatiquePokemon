package pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import GUI.MapPanel;

public class ListePoke {
	public Pokemon[] ListePoke;
	public ListePoke() {
	String fichier2CSV = "../data/pokemon_coordinates.csv";
    char separateur = ',';

    Pokemon[] ListePoke = new Pokemon[998];
    int i = 0;
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
                       
            double positionXDouble = Double.parseDouble(positionX.trim())*16;
            double positionYDouble = Double.parseDouble(positionY.trim())*64;
            
            coord c1 = new coord(positionXDouble,positionYDouble);
            Pokemon p1 = new Pokemon(name,c1);
            ListePoke[i] = p1;
            
            i++;            
        }
        
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }

    this.ListePoke = ListePoke;
    
	}
   
	public Pokemon GetListePoke(int i) {
		return this.ListePoke[i];
	}	
	
		
}