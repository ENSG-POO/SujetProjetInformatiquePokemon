package jeu.eu.ensg;


import java.util.ArrayList;

public class MainPrincipal {
    public static void main(String[] args) {
     // "import" des fichiers csv
        String tableauTypeCsv = "./data/tableau-type.csv"; 
        String infosPokemonCsv = "./data/pokemon_first_gen.csv";
        String pokemonCoordinatesCsv = "./data/pokemon_coordinates.csv";
        String movesCsv = "./data/moves.csv"; 
     // choix du séparateur dans les csv
        String csvSeparator = ",";  
     // création des tableaux à partir des csv
        String[][] tableauType = CSVReader.readCsvFile(tableauTypeCsv, csvSeparator);
        String[][] infosPokemon = CSVReader.readCsvFile(infosPokemonCsv, csvSeparator);
        String[][] pokemonCoordinates = CSVReader.readCsvFile(pokemonCoordinatesCsv, csvSeparator);
        String[][] moves=CSVReader.readCsvFile(movesCsv,csvSeparator);
     // ===========================================================================================		
     // Création de la liste de pokémons sauvages
        ArrayList<Pokemon> listePokemonsSauvages=new ArrayList<Pokemon>();
        for (int i = 1; i < pokemonCoordinates.length; i++) {
        	Pokemon p= new Pokemon(pokemonCoordinates, infosPokemon, i);
        	listePokemonsSauvages.add(p);
        }
     // ===========================================================================================		
     // Nettoyages du tableau moves pour ne garder que les attaques qui peuvent infliger des dégats
        String[][] attacksClean = TableManips.cleanTable(moves, 6, "None");
     // Création d'une liste contenant toutes les attaques
        ArrayList<Attaque> listeAttaques=new ArrayList<Attaque>();
        for (int i = 1; i < attacksClean.length; i++) {//on démare à i=0 car le tableau nettoyé ne contient pas de header
        	Attaque a= new Attaque(attacksClean, i);
        	listeAttaques.add(a);
        }
     // ===========================================================================================		
        // attribution d'une liste d'attaque à chaque pokemon contenant deux attaques alléatoire depuis 
        
        
        //for (int i = 1; i < attacks.length; i++) {
            //for (int j = 0; j < attacks[i].length; j++) {
                //System.out.print(attacks[i][j] + " ");
            //}
           // System.out.println();
        //System.out.println(listePokemonsSauvages);
        //System.out.println(listePokemonsSauvages.size());
          System.out.println(listeAttaques);
          System.out.println(listeAttaques.size());
    // }
    }   
}
