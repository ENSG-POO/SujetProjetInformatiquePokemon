package jeu.eu.ensg;

import java.awt.BorderLayout;
import java.awt.event.*; // import pour les coordonnée de la souris
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import jeu.eu.ensg.gui.CartePanel;
import jeu.eu.ensg.gui.ControlePanel;
import jeu.eu.ensg.gui.FichePanel;
import jeu.eu.ensg.gui.BarreDeVie;
import jeu.eu.ensg.gui.Carte;


public class MainApp {

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
		final Carte map = new Carte(); 
		final CartePanel mapPanel = new CartePanel(); 


		fen.setLayout(new BorderLayout());
		
		fen.add(BorderLayout.CENTER, map);
		fen.add(BorderLayout.EAST, new FichePanel());
		fen.add(BorderLayout.SOUTH, new ControlePanel(mapPanel));
		
		
		fen.setLocationRelativeTo(null);
		fen.setResizable(false);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setTitle("Jeu Pokémon");
		
		// récupération coordonnée de la souris		
		fen.addMouseListener(new MouseAdapter() {
		    @Override 
		    public void mousePressed(MouseEvent e) {
		      System.out.println("X=" + e.getX() + " ,Y=" + e.getY());
		    }
		 });

		fen.setVisible(true);
	}

}