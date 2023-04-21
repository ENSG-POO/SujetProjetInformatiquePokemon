package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gestion_jeu.Joueur;
import pack1.Combat;
import pack1.ListePoke;
import pack1.PokeDomestique;
import pack1.PokeSauvage;
import pack1.Pokemon;
import pack1.coord;

public class MainApplication2 extends JFrame{

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
		fen.setSize(2000, 2000);

		fen.setLayout(new BorderLayout());
		
		// Création de l'avatar du joueur - joueur vide
		coord coordDep = new coord(0,0);
		Pokemon poke1 = new Pokemon("Ratata");
		Pokemon[] liste = new Pokemon[] {poke1};
		String Nom = new String();
		Joueur j = new Joueur(Nom, liste, coordDep);
		
		// Création d'un combat vide
		PokeSauvage pokeS = new PokeSauvage("pokeS");
		PokeDomestique pokeD = new PokeDomestique ("pokeD", j);
		Combat c = new Combat(pokeD, pokeS);

		ListePoke listePokeProche = new ListePoke();
		MapPanel mapPanel = new MapPanel(listePokeProche);

		
		// Gestion des panels dans la fenêtre principale
		
		fen.add(BorderLayout.NORTH, new FichePanel(j));
		//fen.add(BorderLayout.SOUTH, new ControlePanel(mapPanel));
		fen.add(BorderLayout.WEST, new CombatPanel(j, c));
		fen.add(BorderLayout.CENTER, mapPanel);
		
		fen.setLocationRelativeTo(null);
		fen.setResizable(false);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setTitle("Jeu Pokémon");

		fen.setVisible(true);
		
		//System.out.println(mapPanel.getSize());
	}

}
