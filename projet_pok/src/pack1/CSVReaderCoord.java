package pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderCoord {
	
	public static void main(String[] args) {
        String fichier2CSV = "../data/pokemon_coordinates.csv";
        char separateur = ',';

        List<PokeSauvage> listeCoords = new ArrayList<>();

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
                PokeSauvage coords = new PokeSauvage(name, positionX, positionY);
                
                listeCoords.add(coords);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (PokeSauvage coords : listeCoords) {
        	System.out.println(coords.toString());
        }
    }

}
