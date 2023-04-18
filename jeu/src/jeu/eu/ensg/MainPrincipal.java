package jeu.eu.ensg;
import java.util.ArrayList;

//import jeu.src.jeu.eu.ensg.CSVReader;

public class MainPrincipal {
    public static void main(String[] args) {
        //String tableauTypeCsv = "./data/tableau-type.csv"; 
        String infosPokemonCsv = "./data/pokemon_first_gen.csv";
        String pokemonCoordinatesCsv = "./data/pokemon_coordinates.csv";
        // "import" des trois fichiers csv
        String csvSeparator = ","; // choix du séparateur dans les csv 
        // création des trois tableaux à partir des trois csv
        //String[][] tableauType = CSVReader.readCsvFile(tableauTypeCsv, csvSeparator);
        String[][] infosPokemon = CSVReader.readCsvFile(infosPokemonCsv, csvSeparator);
        String[][] pokemonCoordinates = CSVReader.readCsvFile(pokemonCoordinatesCsv, csvSeparator);
        
        ArrayList<Pokemon> listePokemonsSauvages=new ArrayList<Pokemon>();
        for (int i = 0; i < pokemonCoordinates.length; i++) {
        	Pokemon p= new Pokemon(pokemonCoordinates, infosPokemon, i);
        	listePokemonsSauvages.add(p);
        }
        System.out.println(listePokemonsSauvages);
        
        
    }
}