
package jeu.eu.ensg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Inventaire {
	protected static List<Pokemon> pokemons;

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


	public static ArrayList<type> charger_type() {
		ArrayList<type> liste = new ArrayList<type>();
		type n = new type(0, "Normal");
		liste.add(n);
		type f = new type(1, "Feu");
		liste.add(f);
		type e = new type(2, "Eau");
		liste.add(e);
		type p = new type(3, "Plante");
		liste.add(p);
		type el = new type(4, "Electrik");
		liste.add(el);
		type g = new type(5, "Glace");
		liste.add(g);
		type c = new type(6, "Combat");
		liste.add(c);
		type po = new type(7, "Poison");
		liste.add(po);
		type s = new type(8, "Sol");
		liste.add(s);
		type v = new type(9, "Vol");
		liste.add(v);
		type ps = new type(10, "Psy");
		liste.add(ps);
		type i = new type(11, "Insecte");
		liste.add(i);
		type r = new type(12, "Roche");
		liste.add(r);
		type spe = new type(13, "Spectre");
		liste.add(spe);
		type d = new type(14, "Dragon");
		liste.add(d);
		type T = new type(15, "Tenebres");
		liste.add(T);
		type A = new type(16, "Acier");
		liste.add(A);
		return liste;

	}

	public static ArrayList<Pokemon> charger_csv_pokemons() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("../../data/pokemon_first_gen.csv"));
		String ligne = null;
		ArrayList<Pokemon> liste = new ArrayList<Pokemon>();
		ligne = br.readLine(); // on ne lit pas la premiere ligne
		while ((ligne = br.readLine()) != null) {
			// Retourner la ligne dans un tableau
			String[] data = ligne.split(",");
			Pokemon p = new Pokemon(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]),
					Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]),
					Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10]),
					Integer.parseInt(data[11]), data[12], Integer.parseInt(data[13]));
			liste.add(p);

		}
		System.out.println(liste);
		br.close();
		return liste;
	}

	public static ArrayList<attaque> charger_csv_attaque() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("../../data/attaque.csv"));
		String ligne = null;
		ArrayList<attaque> liste = new ArrayList<attaque>();
		ligne = br.readLine(); // on ne lit pas la premiere ligne
		while ((ligne = br.readLine()) != null) {
			// Retourner la ligne dans un tableau
			String[] data = ligne.split(",");
			attaque a = new attaque(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]),
					Integer.parseInt(data[5]));
			liste.add(a);

		}
		System.out.println(liste);
		br.close();
		return liste;
	}

	public static List<Localisation> charger_csv_coords() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("../../data/pokemon_coordinates.csv"));
		String ligne = null;
		List<Localisation> localisations = new ArrayList<Localisation>();
		ligne = br.readLine(); // on ne lit pas la premiere ligne
		while ((ligne = br.readLine()) != null) {
			// Retourner la ligne dans un tableau
			String[] data = ligne.split(",");
			int x = (int) (30 * Double.parseDouble(data[1].replace("[", "").replace("\"", ""))); // on supprime les
																									// caracteres
			// inutiles
			int y = (int) (65 * Double.parseDouble(data[2].replace("]", "").replace("\"", "")));
			Coordonnee c = new Coordonnee(30 + x, 50 + y);
			Localisation loc = new Localisation(data[0], c);
			loc.setId(localisations.size());
			localisations.add(loc);
		}
		br.close();
		return localisations;
	}

	public static Pokemon getDonnées(int ind) {
		Pokemon p = pokemons.get(ind);
		return p;
	}

	public static List<Pokemon> getPokemons() {
		return pokemons;
	}

	
	

}
