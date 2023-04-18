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
		
	
		Graphics2D g2D = (Graphics2D) g;
		
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
