package jeu.eu.ensg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Inventaire {
	private static List<Pokemon> pokemons;

	public Inventaire(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public Inventaire() {
		List<Pokemon> poke = new ArrayList<Pokemon>();
		this.pokemons = poke;
	}

	public void ajouter_pokemon(Pokemon p) {
		int taille = this.pokemons.size();
		this.pokemons.add(p); // on ajoute le pokemon a la liste
		p.setId(taille); // on definit l indice du pokemon comme le dernier de la liste
	}

	@Override
	public String toString() {
		return "Inventaire [pokemons=" + pokemons + "]";
	}

	public void supprimer_pokemon(Pokemon p) {
		int taille = this.pokemons.size();
		this.pokemons.remove(p.getId()); // on supprime le pokemon de la liste
		for (int i = p.getId() + 1; i < taille; i++) { // pour chaque pokemon plus loin dans la liste
			Pokemon poke = this.pokemons.get(i);
			poke.setId(poke.getId() - 1); // on abaisse la valeur de son indice de 1
		}
	}
	
	public static void charger_csv() throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("../../data/pokemon_first_gen.csv"));
		String ligne = null;
		Carte liste = new Carte();
		ligne = br.readLine(); // on ne lit pas la premiere ligne
		while ((ligne = br.readLine()) != null) {
			// Retourner la ligne dans un tableau
			String[] data = ligne.split(",");
			Pokemon p = new Pokemon(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]),
					Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]),
					Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10]),
					Integer.parseInt(data[11]), data[12],Integer.parseInt(data[13]));
			liste.ajouter_pokemon(p);

		}
		System.out.println(liste);
		br.close();
	}

	public static Pokemon getPokemons(int ind){
		Pokemon p = pokemons.get(ind);
		return p;
	}


}
