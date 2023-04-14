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

            for (int i = 1; i < tableau.length; i++) {
                String[] ligne = tableau[i];

                Pokemon pokemon = new Pokemon(1,"","");
                pokemon.setId(Integer.parseInt(ligne[0]));
                pokemon.setNom(ligne[1]);
                pokemon.setType(ligne[2]);

                System.out.println(pokemon);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
