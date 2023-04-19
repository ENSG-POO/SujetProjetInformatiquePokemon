package GestionPokemon;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;


public class Pokedex {
    
	// Création d'un dictionnaire associant le nom d'un pokemon à son numéro de pokedex
    private Map<String, Integer> pokedex;
    
    public Pokedex(String csvFile) throws IOException, CsvException {
        pokedex = new HashMap<>();
        
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            
            String[] record;
            while ((record = reader.readNext()) != null) {
                String name = record[1];
                int pokedexNumber = Integer.parseInt(record[0]);
                pokedex.put(name, pokedexNumber);
            }
        }
    }
    
    public int getPokedexNumber(String name) {
        return pokedex.getOrDefault(name, -1);
    }
    
    public static void main(String[] args) throws IOException, CsvException {
        Pokedex pokedex = new Pokedex("./data/Pokedex.csv");
        System.out.println("Pokedex number for Bulbizarre: " + pokedex.getPokedexNumber("Bulbizarre"));
        System.out.println("Pokedex number for Pikachu: " + pokedex.getPokedexNumber("Pikachu"));
    }
}

