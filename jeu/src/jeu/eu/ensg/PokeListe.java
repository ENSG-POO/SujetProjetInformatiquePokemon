package jeu.eu.ensg;

import java.util.List;

public class PokeListe {
	private List<Pokemon> Pokemons;

	public PokeListe(List<Pokemon> Pokemons) {
		this.Pokemons = Pokemons;
	}

	public PokeListe() throws Exception {
		List<Pokemon> poke = Inventaire.charger_csv_pokemons();
		this.Pokemons = poke;
	}

	public void ajouter_Pokemon(Pokemon p) {
		int taille = this.Pokemons.size();
		this.Pokemons.add(p); // on ajoute le Pokemon a la liste
		p.setId(taille); // on definit l indice du Pokemon comme le dernier de la liste
	}

	public void supprimer_Pokemon(Pokemon p) {
		int taille = this.Pokemons.size();
		this.Pokemons.remove(p.getId()); // on supprime le Pokemon de la liste
		for (int i = p.getId() + 1; i < taille; i++) { // pour chaque Pokemon plus loin dans la liste
			Pokemon poke = this.Pokemons.get(i);
			poke.setId(poke.getId() - 1); // on abaisse la valeur de son indice de 1
		}
	}

	public List<Pokemon> getPokemons() {
		return Pokemons;
	}

	@Override
	public String toString() {
		return "Pokemon [Pokemons=" + Pokemons + "]";
	}
}
