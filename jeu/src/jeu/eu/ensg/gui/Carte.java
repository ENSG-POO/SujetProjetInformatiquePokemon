package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Carte extends JPanel {
	
	private Image image; // attribut de type Image
	
	public Carte() {
		// on cree une icone de type image
		ImageIcon ii = new ImageIcon("./data/carte.png");
		this.image = ii.getImage(); // on recupere l 'Image de l ' icone
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2d = (Graphics) g;
				
		g2d.drawImage(this.image, 0, 0, (int)( this .image.getWidth(null) * 4),
		( int ) ( this .image.getHeight(null) * 4), null );
		// on affiche l'image avec facteur d' echelle (0.5)
		
	
	}
	
	private String message = "";
	
	public void ajoutMessage(String message) {
		this.message = message;
		this.repaint();
	}
}
