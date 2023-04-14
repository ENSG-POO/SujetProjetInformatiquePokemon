package pokemons;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "C:/Users/gosse/Documents/GitHub/Pokemon/PlayPokemon/src/Pokemons/pokemon_first_gen.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] pokemon_attribute = line.split(cvsSplitBy);
                String name = pokemon_attribute[1];
                String type = pokemon_attribute[2];
                int pv = Integer.parseInt(pokemon_attribute[5]);
                int attack = Integer.parseInt(pokemon_attribute[6]);
                int defense = Integer.parseInt(pokemon_attribute[7]);
                int speed = Integer.parseInt(pokemon_attribute[8]);
                
                System.out.println(name + " " + type + " " + pv + " " + attack + " " + defense + " " + speed);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

/*
import java.nio.file.*;
import java.io.*;

public class CSVReader {
   public static void main(String[] args) throws IOException {
      for (int i = 1; i<150; i++) {
          String line = Files.readAllLines(Paths.get("C:/Users/gosse/Documents/GitHub/Pokemon/PlayPokemon/src/Pokemons/pokemon_first_gen.csv")).get(0);
    	  System.out.println(line);
      }
   }
}*/
