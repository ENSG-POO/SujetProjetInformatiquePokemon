package Type.CODES_ELIOT;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;

import java.awt.*;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameCombat extends JFrame{
	
	public FrameCombat () {
		      super("Ma frame avec une image de fond");
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		      // Créer un JPanel pour l'image de fond
		      JPanel imagePanel = new JPanel() {
		         // Override la méthode paintComponent pour dessiner l'image de fond
		         @Override
		         protected void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            ImageIcon image = new ImageIcon("C:/Users/alexa/git/EsteoulleCamboursBarriere/battle_screen_background.jpg");
		            g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), this);
		         }
		      };
		      imagePanel.setLayout(new BorderLayout());

		      // Récupérer les boutons créés dans une autre classe et les ajouter au JPanel
		      BoutonAvecFonction BoutonAvecFonction = new BoutonAvecFonction();
		      JPanel boutonPanel = BoutonAvecFonction.getBoutonPanel();
		      imagePanel.add(boutonPanel, BorderLayout.SOUTH,0);

		      // Ajouter le JPanel à la frame
		      getContentPane().add(imagePanel, BorderLayout.CENTER);

		      // Afficher la frame
		      pack();
		      setVisible(true);
		     
		      
		   }

		   public static void main(String[] args) {
		      new FrameCombat();
		   }

}
