package jeu.eu.ensg;

import java.util.List;

public class Carte {
	private List<Pokemon> pokemons;

	public Carte(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public Carte() {
		List<Pokemon> poke = new ArrayList<Pokemon>();
		this.pokemons = poke;
	}

	public void ajouter_pokemon(Pokemon p) {
		int taille = this.pokemons.size();
		this.pokemons.add(p); // on ajoute le pokemon a la liste
		p.setId(taille); // on definit l indice du pokemon comme le dernier de la liste
	}

	public void supprimer_pokemon(Pokemon p) {
		int taille = this.pokemons.size();
		this.pokemons.remove(p.getId()); // on supprime le pokemon de la liste
		for (int i = p.getId() + 1; i < taille; i++) { // pour chaque pokemon plus loin dans la liste
			Pokemon poke = this.pokemons.get(i);
			poke.set(poke.getId() - 1); // on abaisse la valeur de son indice de 1
		}
	}

}
