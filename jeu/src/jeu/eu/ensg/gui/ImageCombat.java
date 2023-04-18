package jeu.eu.ensg.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageCombat  extends JPanel{

	private Image image; // attribut de type Image
	
	public ImageCombat() {
		// on cree une icone de type image
		ImageIcon ii = new ImageIcon("C:/Users/Formation/Desktop/ProjetJava/Jmammou-Labbe-Bontoux/data/arriereplanpokemon.png");
		this.image = ii.getImage(); // on recupere l 'Image de l ' icone
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2d = (Graphics) g;
				
		g2d.drawImage(this.image, 0, 0, (int)( this .image.getWidth(null) * 1.5),
		( int ) ( this .image.getHeight(null) * 1.5), null );
		// on affiche l'image avec facteur d' echelle (0.5)
	}
}
