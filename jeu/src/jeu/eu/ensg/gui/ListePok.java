package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ListePok extends JPanel{

	private static final long serialVersionUID = 1L;

	public ListePok() {
		
		this.setSize(200, 600);
		this.setBackground(Color.PINK);
		
		JPanel infoPokemon = new JPanel(new GridLayout(2,2));
		
		JLabel labelNom = new JLabel("Nom Pokémon:");
		infoPokemon.add(labelNom);
		JTextField pokemonName = new JTextField(10);
		pokemonName.setText("Bulbizarre");
		infoPokemon.add(pokemonName);
		
		JLabel labelFamille = new JLabel("Type Pokémon:");
		infoPokemon.add(labelFamille);
		JTextField pokemonType = new JTextField(10);
		pokemonType.setText("Plante");
		infoPokemon.add(pokemonType);
			
		add(infoPokemon);
	}
}
