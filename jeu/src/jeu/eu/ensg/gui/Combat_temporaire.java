package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Combat_temporaire extends JPanel{
	
	public Combat_temporaire(String pokemon_inventaire, String adversaire, int id_pokemon, int id_adversaire) {

		final JFrame fen = new JFrame();
		fen.setSize(1000, 1000);
		fen.setTitle("Choix Pokemon");
		fen.setVisible(true);

		JPanel infoPokemon = new JPanel(new GridLayout(1, 3));
		infoPokemon.setSize(200, 600);
		infoPokemon.setBackground(Color.PINK);

		JLabel labelNom = new JLabel("<html>     "+pokemon_inventaire+"<br><br>    " + id_pokemon +"</html>");
		infoPokemon.add(labelNom);
		JLabel labelNom2 = new JLabel("<html>"+adversaire+"<br><br>" + id_adversaire +"</html>");
		infoPokemon.add(labelNom2);
		JLabel versus = new JLabel("versus");
		infoPokemon.add(versus);
		infoPokemon.add(labelNom2);
		fen.add(infoPokemon);

	}
}
