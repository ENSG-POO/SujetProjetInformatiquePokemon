package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Debut extends JPanel{
	
	private Image image;

	public Debut() {
	
		// on cree une icone de type image
		ImageIcon ii = new ImageIcon("./data/image.jpg");
		this.image = ii.getImage(); // on recupere l 'Image de l ' icone
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2d = (Graphics) g;
				
		g2d.drawImage(this.image, 0, 0, (int)( this.getWidth()) ,
		( int ) ( this.getHeight() ), null );
		// on affiche l'image avec facteur d' echelle (0.5)
	
	}
}
