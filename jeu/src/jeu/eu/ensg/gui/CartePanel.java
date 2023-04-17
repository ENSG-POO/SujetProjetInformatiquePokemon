package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import javax.swing.JPanel;

/**
 * Exemple de panneau contenant un espace où on peut dessiner.
 * 
 *
 */
public class CartePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image fond;
	private List<Image> pokemons;

	/**
	 * Constructeur.
	 */
	public CartePanel() {
		ImageIcon ii = new ImageIcon("data/images/fond.jpg");
		this.fond = ii.getImage(); // on recupere l'Image de l'icon
	}

	/**
	 * Méthodes de dessin appelée après le constructeur
	 * ou quand on appelle la méthode repaint
	 */
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		//g2D.drawImage(this.fond, 100, 300, 300, ImageObser);
		Image fond = this.fond;
		g2D.drawImage(fond, 0, 0, 300, 300, null);
		System.out.println("coucou2");
		
		// On dessine 10 points bleus
		for (int i = 0; i < 10; i++) {
			g2D.setPaint(Color.blue);
			g.fillOval(i*50 + 100, i*50 + 100, 10, 10);
		}
		
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
