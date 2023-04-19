package jeu.eu.ensg;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*; // import pour les coordonnée de la souris
import java.util.*;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import jeu.eu.ensg.gui.CartePanel;
import jeu.eu.ensg.gui.ControlePanel;
import jeu.eu.ensg.gui.FichePanel;
import jeu.eu.ensg.gui.ImageCombat;
import jeu.eu.ensg.gui.ListePok;
import jeu.eu.ensg.gui.BarreDeVie;
import jeu.eu.ensg.gui.BoutonCombat;
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
		      Double X =(double) e.getX();
		      Double Y =(double) e.getY();
		      Coordinates C = new Coordinates(X,Y);

		      ArrayList<Pokemon> listePokemonSauvages = new ArrayList<Pokemon>();
		      Statistiques s = new Statistiques(1,1,2,3,4,5,true,7);
		      Coordinates c = new Coordinates(0.0,0.0);
		      
		      Type Feu = new Type("Feu");
		      Pokemon retardo = new Pokemon("idiota",s,c,Feu);
		      Pokemon r = new Pokemon("ratardo",s,c,Feu);
		      listePokemonSauvages.add(retardo);
		      listePokemonSauvages.add(r);
		      
		      List<Pokemon> Listeproxi = C.listePokemonsProximite(listePokemonSauvages, 100);
		      List<String> nom = new ArrayList<String>();
		      for (int i=0;i<Listeproxi.size();i++) {
		    	  nom.add(Listeproxi.get(i).getNom());
		      }
		      
		      JComboBox<String> cb = new JComboBox<String>(new Vector<String>(nom));
		      JFrame selec = new JFrame();
		      selec.add(cb);
		      selec.setSize(new Dimension(200,200));
		      selec.pack();
		      selec.setVisible(true);
		      
		      cb.addActionListener(new ActionListener() {
		    	  public void actionPerformed(ActionEvent e) {
		    		  String selectedOption = (String) cb.getSelectedItem();
		    	      System.out.println("Selected option: " + selectedOption);
		    	      selec.dispose();
		    	      JFrame fen = new JFrame();
				        fen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						fen.setSize(1200, 800);
						

						// just a JPanel extension, add to any swing/awt container
						final CartePanel mapPanel = new CartePanel(); 
						fen.add(BorderLayout.EAST, mapPanel);


						fen.setLayout(new BorderLayout());
						
						fen.add(BorderLayout.CENTER, new ImageCombat());

						
						fen.add(BorderLayout.EAST, new ListePok());

						fen.add(BorderLayout.SOUTH, new BoutonCombat(fen));
						
						fen.setLocationRelativeTo(null);
						fen.setResizable(false);
						fen.setTitle("fenetre de combat");
						
						fen.setVisible(true); 
		    	  }
		      });
		 }});

		fen.setVisible(true);
	}

}