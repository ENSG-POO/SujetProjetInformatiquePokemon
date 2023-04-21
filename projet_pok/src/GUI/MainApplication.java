package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gestion_jeu.Jeu;
import gestion_jeu.Joueur;
import pack1.Combat;
import pack1.ListePoke;
import pack1.PokeDomestique;
import pack1.PokeSauvage;
import pack1.Pokemon;
import pack1.coord;

public class MainApplication {

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
		fen.setSize(2000, 1000);

		fen.setLayout(new BorderLayout());
		
		//création de l'avatar du joueur - joueur vide
		coord coordDep = new coord(0,0);
		PokeDomestique poke1 = new PokeDomestique ("Bulbasaur", null);
		Pokemon[] liste = new Pokemon[] {poke1};
		String Nom = new String();
		Joueur j = new Joueur(Nom, liste, coordDep);
		
		//création d'un jeu vide
		Jeu game = new Jeu();
		
		//initialisation des coord vide
		double x = 0;
		double y = 0;
		
		//création d'un combat vide
		PokeSauvage pokeS = new PokeSauvage("pokeS");
		PokeDomestique pokeD = new PokeDomestique ("pokeD", j);
		Combat c = new Combat(pokeD, pokeS);
		
		ListePoke listePokeProche = new ListePoke();
		MapPanel mapPanel = new MapPanel(listePokeProche);
		//System.out.println("coord1 x = " + mapPanel.getX());
		//System.out.println("coord1 y = " +mapPanel.getX());
		CombatPanel cp = new CombatPanel(j, c, game, mapPanel);
		
		
		// gestion des panels dans la fenêtre principale
		//fen.add(BorderLayout.EAST, new FichePanel(j));
		//fen.add(BorderLayout.SOUTH, new ControlePanel(mapPanel));
		fen.add(BorderLayout.WEST, cp);
		fen.add(BorderLayout.CENTER, mapPanel);	
		
		fen.setLocationRelativeTo(null);
		fen.setResizable(false);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setTitle("Jeu Pokémon");

		fen.setVisible(true);
		
	}

}
