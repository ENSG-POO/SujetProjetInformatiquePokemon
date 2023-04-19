
package jeu.eu.ensg;

import java.util.List;

public class Carte {
	private List<Localisation> pokemons;

	public Carte(List<Localisation> pokemons) {
		this.pokemons = pokemons;
	}

	public Carte() throws Exception {
		List<Localisation> poke = Inventaire.charger_csv_coords();
		this.pokemons = poke;
	}

	public void ajouter_pokemon(Localisation p) {
		int taille = this.pokemons.size();
		this.pokemons.add(p); // on ajoute le pokemon a la liste
		p.setId(taille); // on definit l indice du pokemon comme le dernier de la liste
	}

	public void supprimer_pokemon(Localisation p) {
		int taille = this.pokemons.size();
		this.pokemons.remove(p.getId()); // on supprime le pokemon de la liste
		for (int i = p.getId() + 1; i < taille; i++) { // pour chaque pokemon plus loin dans la liste
			Localisation poke = this.pokemons.get(i);
			poke.setId(poke.getId() - 1); // on abaisse la valeur de son indice de 1
		}
	}

	public List<Localisation> getPokemons() {
		return pokemons;
	}

	@Override
	public String toString() {
		return "Carte [pokemons=" + pokemons + "]";
	}

}
