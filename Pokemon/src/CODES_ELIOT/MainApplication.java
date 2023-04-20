package Type.CODES_ELIOT;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Type.CODES_ELIOT.CartePanel;
import Type.CODES_ELIOT.ControlPanel;
import Type.CODES_ELIOT.FichePanel;

/**
 * Lancement de l'application graphique
 * 
 * @author Marie-Dominique
 *
 */
public class MainApplication {

	/**
	 * Méthode main pour lancer le programme.
	 * @param args
	 */

	
		public static void main (String[] args) {

		// Look and Feel dépend de l'OS.
		try {
			String os = System.getProperty("os.name").toLowerCase();
			
			// For windows os
			if (os.contains("windows")) {
				UIManager.setLookAndFeel(new NimbusLookAndFeel());
			}
			// For linux os
			if ((os.contains("linux")) || (os.contains("unix"))) {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			}
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		final JFrame fen = new JFrame("ce putain de jeu");
		fen.setSize(1000, 800);
		 
		
		// just a JPanel extension, add to any swing/awt container
		final ImageDeFond mapPanel = new ImageDeFond(); 
		fen.toBack();
		
		fen.setLayout(new BorderLayout());
		
		BoutonAvecFonction controlpanel = new BoutonAvecFonction();
		
		
		fen.add(BorderLayout.CENTER, controlpanel);
		fen.add(BorderLayout.EAST, new FichePanel());
		fen.add(BorderLayout.CENTER, mapPanel );
		
		
		fen.setLocationRelativeTo(null);
		fen.setResizable(false);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setTitle("Jeu Pokémon");

		fen.setVisible(true);
		
		

		
		}

}

