package gestion_pokémon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Pokedex {
	
	public ArrayList<Pokemon> ArrayPokedex;
	
	public Pokedex () {
		ArrayList<Pokemon> ArrayPokedex = new ArrayList<Pokemon>();
		String csvFile = "C:\\Users\\bapti\\git\\GregoireTychyjDelaunay\\data\\pokemon_first_gen.csv";
		String line = "";
		String csvSplitBy = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){
			while ((line = br.readLine()) != null) {
				String[] Poke = line.split(csvSplitBy);
				Pokemon pokemon =new Pokemon (Poke[1], Poke[2], Poke[3], Double.valueOf(Poke[5]),Double.valueOf(Poke[6]),Double.valueOf(Poke[10]),Boolean.parseBoolean(Poke[12]));
				ArrayPokedex.add(pokemon);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	this.ArrayPokedex=ArrayPokedex;

	}
/*	public String toString () {
		String str="";
		for (Pokemon P : pokedex) {str+= P.nom+ " / ";}
		return str;
	}*/
	

public static void main(String[] args) {
	Pokedex pokedex = new Pokedex();
	System.out.println(pokedex.ArrayPokedex.get(0).name);
	}
}