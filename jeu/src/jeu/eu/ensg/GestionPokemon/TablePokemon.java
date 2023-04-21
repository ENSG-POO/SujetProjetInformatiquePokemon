package jeu.eu.ensg.GestionPokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TablePokemon {
  
	//méthode permettant de créer une liste contenant tout les pokémons présent dans le fichier CSV, chaque pokémons sera ajouté comme un objet pokemon dans une liste qui contiendras uniquement des pokémons
    public static List<Pokemon> readPokemonCSV(String csvFilePath) {
        List<Pokemon> pokemonList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; //saute la première ligne qui est l'entête
                }
                String[] attributes = line.split(",");//segmente le fichier CSV en plusieurs colonne
                int id = Integer.parseInt(attributes[0]);
                String name = attributes[1];
                String type1 = attributes[2];
                String type2 = attributes[3];
                int total = Integer.parseInt(attributes[4]);
                int hp = Integer.parseInt(attributes[5]);
                int attack = Integer.parseInt(attributes[6]);
                int defense = Integer.parseInt(attributes[7]);
                int spAtk = Integer.parseInt(attributes[8]);
                int spDef = Integer.parseInt(attributes[9]);
                int speed = Integer.parseInt(attributes[10]);
                Pokemon pokemon = new Pokemon(id, name, type1, type2, total, hp, attack, defense, spAtk, spDef, speed,false);
                pokemonList.add(pokemon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pokemonList;
    }
    
    
    //permet de récuper un seul pokémon a partir de son nom (en String) dans la liste contenant tout les objets pokémons
    public static Pokemon getPokemonByName(String name, List<Pokemon> pokemonList) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getName().equalsIgnoreCase(name)) {
                return pokemon;
            }
        }
        return null; // si le Pokemon n'a pas été trouvé
    }

}

