package jeu.eu.ensg.Jeu;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import jeu.eu.ensg.Gui.*;
import jeu.eu.ensg.GestionPokemon.*;


public class Jouer{
	public static void main(String[] args) {
	    //initialisation de l'équipe pokémon avec un aspicot
		List<Point2D.Double> bluePoints = new ArrayList<Point2D.Double>();
		List<Point2D.Double> orangePoints = new ArrayList<Point2D.Double>();
	    String csvFilePath = "D:\\DeBockRosierMiras\\data\\pokemon_first_gen.csv";
	    List<Pokemon> pokemonList = TablePokemon.readPokemonCSV(csvFilePath);
	    Pokemon charmander = TablePokemon.getPokemonByName("charmander",pokemonList);
	    charmander.setEtatPokemon(true);
	    List<Pokemon> equipe = new ArrayList<Pokemon>();
	    equipe.add(charmander);
	    // boucle qui permet de relancer des combats tant que le joueur souhaite continuer à jouer
	    boolean continuer = true;
	    while (continuer) {
	        //affichage de la carte
	        Carte carte = new Carte(bluePoints,orangePoints);
	        JFrame fenetreCarte = new JFrame("Ma carte de jeu");
	        fenetreCarte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        fenetreCarte.add(carte);
	        fenetreCarte.pack();
	        fenetreCarte.setVisible(true);
	
	        Pokemon p = null;
	        while (p == null) {
	            try {
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            carte.Vérifie_capture(bluePoints, equipe);
	            p = carte.lance_combat(equipe);
	        }
	        System.out.println("Le Pokemon cliqué est : " + p.getName());
	
	        // création et affichage de la fenêtre de combat
	        Combat combat1 = new Combat(equipe.get(0), p, equipe, true);
	        InterfaceCombat fenetreCombat = new InterfaceCombat(combat1);
	        fenetreCombat.setVisible(true);
	
	        // attendre la fin du combat avant de fermer la fenêtre de combat
	        while (combat1.getEtatCombat()==true) {
	            try {
	                Thread.sleep(100); // attendre 100 millisecondes avant de vérifier à nouveau
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        fenetreCombat.dispose();
	        System.out.println("Equipe actuelle : " + equipe);
	
	        // fermeture de la fenêtre carte
	        fenetreCarte.dispose();
	    }
	}
	}



