package pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	
	public static void main(String[] args) {
        String fichierCSV = "../data/pokemon_first_gen.csv";
        char separateur = ',';

        List<Pokemon> listePokemons = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fichierCSV))) {
            String ligne;
            boolean ligne1 = true;
            while ((ligne = br.readLine()) != null) {
            	if(ligne1) {
            		ligne1 = false;
            		continue;
            	}
                
                String[] valeurs = ligne.split(String.valueOf(separateur));
                
                int id = Integer.parseInt(valeurs[0]);
                String nom = valeurs[1];
                String type = valeurs[2];
                String type2 = valeurs[3];
                double Total = Integer.parseInt(valeurs[4]);
                Pokemon pokemon = new Pokemon(id, nom, type, type2, Total);
               
                listePokemons.add(pokemon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Pokemon pokemon : listePokemons) {
            System.out.println(pokemon.toString());
        }
    }

	
	
	
/*	

    public static String[][] readCSV(String nomFichier, char c) throws IOException {
        List<String[]> lignes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] valeurs = ligne.split(String.valueOf(c));
                lignes.add(valeurs);
            }
        }
        return lignes.toArray(new String[0][0]);
    }
    
    

    public static void main(String[] args) {
        try {
            String[][] tableau = readCSV("../data/pokemon_first_gen.csv", ',');

            for (int i = 1; i < tableau.length; i++) {
                String[] ligne = tableau[i];

                Pokemon pokemon = new Pokemon();
                pokemon.setId(Integer.parseInt(ligne[0]));
                pokemon.setNom(ligne[1]);
                pokemon.setType(ligne[2]);

                System.out.println(pokemon);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}
