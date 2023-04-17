package jeu.eu.ensg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "C:/Users/Formation/Desktop/projet/Jmammou-Labbe-Bontoux/data/pokemon_first_gen.csv";
        String line = "";
        String csvSplitBy = ",";
        int numRows = 0;
        int numCols = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                numRows++;
                String[] row = line.split(csvSplitBy);
                numCols = row.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[][] data = new String[numRows][numCols];

        int rowIndex = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(csvSplitBy);
                for (int i = 0; i < row.length; i++) {
                    data[rowIndex][i] = row[i];
                }
                rowIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
