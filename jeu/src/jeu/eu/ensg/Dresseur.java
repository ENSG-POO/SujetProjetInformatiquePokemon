
package jeu.eu.ensg;

import java.util.ArrayList;
import java.util.List;

public class Dresseur extends Inventaire {
	private String nom;
	private Coordonnee coord;

	public Dresseur(String nom, Coordonnee coord, List<Pokemon> inventaire) {
		super(inventaire);
		this.nom = nom;
		this.coord = coord;
	}

	public double distance(Coordonnee c1, Coordonnee c2) {
		double selon_x = c1.getX() - c2.getX();
		double selon_y = c1.getY() - c2.getY();
		return Math.sqrt(selon_x * selon_x + selon_y * selon_y);
	}

	public List<Localisation> PokemonsProches(Carte carte) {
		List<Localisation> proches = new ArrayList<Localisation>();
		for (Localisation p : carte.getPokemons()) {
			if (distance(this.coord, p.getPosition()) < 30) {
				proches.add(p);
			}
		}
		return proches;

	}

}
