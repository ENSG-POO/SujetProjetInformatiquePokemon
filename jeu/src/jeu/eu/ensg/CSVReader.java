package jeu.eu.ensg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Formation
 *
 */
public class CSVReader {
    public static String[][] readCsvFile(String csvFile, String csvSeparator) {
        // Initialiser les variables pour compter le nombre de lignes et de colonnes
        int numRows = 0;
        int numCols = 0;

        // Déclarer un tableau pour stocker les données
        String[][] tableau = null;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            
            // Compter le nombre de lignes et de colonnes
            while ((line = br.readLine()) != null) {
                String[] row = line.split(csvSeparator);
                numCols = row.length;
                numRows++;
            }

            // Initialiser le tableau avec le nombre de lignes et de colonnes comptées
            tableau = new String[numRows][numCols];

            // Fermer et rouvrir le fichier CSV pour lire les données
            BufferedReader br2 = new BufferedReader(new FileReader(csvFile));

            int i = 0;
            // Stocker les données dans le tableau
            while ((line = br2.readLine()) != null) {
                String[] row = line.split(csvSeparator);
                for (int j = 0; j < row.length; j++) {
                    tableau[i][j] = row[j];
                }
                i++;
            }

            // Fermer le deuxième BufferedReader
            br2.close();

        } catch (IOException e) {
            // Gérer les exceptions
            e.printStackTrace();
        }

        // Retourner le tableau de données
        return tableau;
    }

    public static void main(String[] args) {
        String csvFile = "chemin/vers/fichier.csv";
        String csvSeparator = ",";
        // Lire le fichier CSV
        String[][] data = readCsvFile(csvFile, csvSeparator);

        // afficher les données lues depuis le fichier
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}

