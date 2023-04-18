package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import jeu.eu.ensg.Carte;
import jeu.eu.ensg.Localisation;

/**
 * Exemple de panneau contenant un espace où on peut dessiner.
 * 
 *
 */
public class CartePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image fond;
	private Carte carte;

	/**
	 * Constructeur.
	 * 
	 * @throws Exception
	 */
	public CartePanel() throws Exception {
		ImageIcon ii = new ImageIcon("../../data/Images/fond.jpg");
		this.fond = ii.getImage(); // on recupere l'Image de l'icon
		this.carte = new Carte();
	}

	public CartePanel(Carte carte) throws Exception {
		ImageIcon ii = new ImageIcon("../../data/Images/fond.jpg");
		this.fond = ii.getImage(); // on recupere l'Image de l'icon
		this.carte = carte;
	}

	/**
	 * Méthodes de dessin appelée après le constructeur ou quand on appelle la
	 * méthode repaint
	 * 
	 * @throws Exception
	 */

	public void affiche_pokemons(Graphics2D g2D) throws Exception {
		List<Localisation> localisations = this.carte.getPokemons();
		for (Localisation loc : localisations) {
			g2D.setPaint(Color.red);
			g2D.fillOval(loc.getPosition().getX(), loc.getPosition().getY(), 10, 10);
		}
	}

	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;

		Image fond = this.fond;

		g2D.drawImage(fond, 0, 0, 1400, 800, getFocusCycleRootAncestor()); // on affiche le background
		/*
		 * ImageIcon icone = new ImageIcon("../../data/Images/pikachu.png"); Image img =
		 * icone.getImage();
		 */

		try {
			affiche_pokemons(g2D);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// On dessine 10 points bleus

		/*
		 * for (int i = 0; i < 10; i++) { g2D.setPaint(Color.blue); g.fillOval(i * 50 +
		 * 100, i * 50 + 100, 10, 10); }
		 */

		if (!this.message.equals("")) {
			g2D.setColor(Color.RED);
			g2D.setFont(new Font("TimesRoman", Font.PLAIN, 36));
			g.drawString(message, 250, 50);
		}
	}

	private String message = "";

	public void ajoutMessage(String message) {
		this.message = message;
		this.repaint();
	}

}
