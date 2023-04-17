package jeu.eu.ensg;

import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.*;

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

	public List<Pokemon> PokemonsProches(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.drawOval(this.coord.getX(), this.coord.getY(), 70, 70);
		for (Pokemon p : super.pokemons) {
			if (distance(this.coord, p.getCoord()) < 70) {
				super.ajouter_pokemon(p);
			}
		}

	}

}
