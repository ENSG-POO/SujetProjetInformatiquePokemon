package jeu.eu.ensg;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class Inventaire {
	private List<Vie_temporaire> pokemons;

	public Inventaire(List<Vie_temporaire> pokemons) {
		this.pokemons = pokemons;
	}

	public Inventaire() {
		List<Vie_temporaire> poke = new ArrayList<Vie_temporaire>();
		this.pokemons = poke;
	}

	public void ajouter_pokemon(Vie_temporaire p) {
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
			poke.set(poke.getId() - 1); // on abaisse la valeur de son indice de 1
		}
	}
	
	public static void charger_csv() throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("../../data/pokemon_first_gen.csv"));
		String ligne = null;
		Carte liste = new Carte();
		ligne = br.readLine(); // on ne lit pas la premiere ligne
		while ((ligne = br.readLine()) != null) {
			// Retourner la ligne dans un tableau
			String[] data = ligne.split(";");
			Vie_temporaire p = new Vie_temporaire(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]),
					Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]),
					Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10]),
					Integer.parseInt(data[11]), data[12]);
			liste.ajouter_pokemon(p);

		}
		br.close();
	}

}
