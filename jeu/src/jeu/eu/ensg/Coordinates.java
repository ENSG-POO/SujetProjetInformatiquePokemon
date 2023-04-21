package jeu.eu.ensg;

import java.util.ArrayList;
import java.util.Objects;

public class Coordinates {
	
	private double x;  // Coordonnée x
	private double y;  // Coordonnée y
	public static String none = "Pokemon capturé";  // Chaîne de caractères pour les pokémons capturés

	public Coordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructeur pour initialiser les coordonnées à partir de deux chaînes de caractères.
	 * @param coord1 Première coordonnée sous forme de chaîne de caractères
	 * @param coord2 Deuxième coordonnée sous forme de chaîne de caractères
	 */
	public Coordinates(String coord1, String coord2) {
		coord1 = coord1.substring(2, coord1.length());  // Supprimer les deux premiers caractères de coord1
		coord2 = coord2.substring(0, coord2.length() - 2);  // Supprimer les deux derniers caractères de coord2
		double x = Double.parseDouble(coord1.trim());  // Convertir coord1 en double et le stocker dans x
		double y = Double.parseDouble(coord2.trim());  // Convertir coord2 en double et le stocker dans y
		this.x = x;
		this.y = y;
	}

	/**
	 * Méthode pour afficher les coordonnées sous forme de chaîne de caractères.
	 */
	@Override
	public String toString() {
		return " [" + x + ", " + y + "]";
	}

	/**
	 * Méthode pour obtenir la coordonnée x.
	 * @return La coordonnée x.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Méthode pour définir la coordonnée x.
	 * @param x La nouvelle valeur de la coordonnée x.
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Méthode pour obtenir la coordonnée y.
	 * @return La coordonnée y.
	 */
	public double getY() {
		return y;
	}

	/**
	 * Méthode pour définir la coordonnée y.
	 * @param y La nouvelle valeur de la coordonnée y.
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Méthode pour déplacer les coordonnées d'un certain montant.
	 * @param dx La quantité à ajouter à la coordonnée x.
	 * @param dy La quantité à ajouter à la coordonnée y.
	 */
	public void translate(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}
	
	/**
	 * Méthode pour déterminer si une autre paire de coordonnées est à une certaine distance de cet objet Coordinates.
	 * @param coord L'autre paire de coordonnées à vérifier.
	 * @param rayon La distance maximale autorisée.
	 * @return Vrai si l'autre paire de coordonnées est à une distance de rayon ou moins de cet objet Coordinates, faux sinon.
	 */
	public boolean isNear(Coordinates coord, int rayon) {
		return (Math.pow(Math.pow(this.x - coord.x, 2) + Math.pow(this.y - coord.y, 2 ), 0.5) <= rayon);
	}
	
 // Redéfinition de la méthode equals() pour pouvoir comparer deux objets de la classe
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);

	}
}
	
