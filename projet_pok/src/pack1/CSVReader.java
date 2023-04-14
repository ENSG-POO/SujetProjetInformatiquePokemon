package pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

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
            String[][] tableau = readCSV("C:\\1_MAJ\\Projet\\Java\\FAGUET-LEROUX-PALOS\\data\\pokemon_first_gen.csv", ',');

            for (int i = 1; i < tableau.length; i++) { // Commencer à partir de la ligne 2 pour ignorer les en-têtes
                String[] ligne = tableau[i];

                // Créer une instance de classe pour chaque ligne
                Pokemon pokemon = new Pokemon(1,"","");
                pokemon.setId(Integer.parseInt(ligne[0]));
                pokemon.setNom(ligne[1]);
                pokemon.setType(ligne[2]);

                // Faire quelque chose avec l'objet Pokemon créé (par exemple, l'afficher)
                System.out.println(pokemon);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
