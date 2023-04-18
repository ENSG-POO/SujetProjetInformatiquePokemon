package jeu.eu.ensg;

import java.awt.BorderLayout;
import java.awt.event.*; // import pour les coordonnée de la souris
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import jeu.eu.ensg.gui.BarreDeVie;
import jeu.eu.ensg.gui.BoutonCombat;
import jeu.eu.ensg.gui.ListePok;
import jeu.eu.ensg.gui.ImageCombat;


import jeu.eu.ensg.gui.CartePanel;




public class Fenetre extends JFrame {
	
	public static void main(String[] args) {
		// Look and Feel dépend de l'OS.
		try {
			String os = System.getProperty("os.name").toLowerCase();
			
			// For windows os
			if (os.contains("windows")) {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
		
		final JFrame fen = new JFrame();
		fen.setSize(1200, 800);

		// just a JPanel extension, add to any swing/awt container
		final CartePanel mapPanel = new CartePanel(); 
		fen.add(BorderLayout.CENTER, mapPanel);


		fen.setLayout(new BorderLayout());
		
		fen.add(BorderLayout.CENTER, new ImageCombat());
		
		fen.add(BorderLayout.WEST, new BarreDeVie());
		fen.add(BorderLayout.WEST, new BarreDeVie());
		
		fen.add(BorderLayout.EAST, new ListePok());

		fen.add(BorderLayout.SOUTH, new BoutonCombat(fen));

		

		fen.setLocationRelativeTo(null);
		fen.setResizable(false);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setTitle("fenetre de combat");
		
		fen.setVisible(true);

		
	}
}