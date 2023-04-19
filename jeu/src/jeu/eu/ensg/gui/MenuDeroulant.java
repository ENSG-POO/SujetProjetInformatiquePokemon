package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import jeu.eu.ensg.Dresseur;

public class MenuDeroulant extends JPanel {

	public MenuDeroulant(String[] items) {

		final JFrame fen = new JFrame();
		fen.setSize(300, 300);
		fen.setTitle("Choix Pokemon");
		fen.setVisible(true);

		JPanel infoPokemon = new JPanel(new GridLayout(1, 1));
		infoPokemon.setSize(200, 600);
		infoPokemon.setBackground(Color.PINK);

		ItemListener itemListener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object selectedItem = e.getItem();
					String nom = selectedItem.toString();
					//MenuDeroulant inventaire = new MenuDeroulant(new String[] { "coucou", "" });
					// Code à exécuter lorsque l'élément est sélectionné
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					Object deselectedItem = e.getItem();
					System.out.println("Élément désélectionné : " + deselectedItem.toString());
					// Code à exécuter lorsque l'élément est désélectionné
				}
			}
		};

		if (items == null) {
			items = new String[] { "" };
		}
		JComboBox<String> comboBox = new JComboBox<>(items);
		comboBox.addItemListener(itemListener);
		infoPokemon.add(comboBox);
		fen.add(infoPokemon);

	}

	public MenuDeroulant(String[] items, Dresseur dresseur) {

		final JFrame fen = new JFrame();
		fen.setSize(300, 300);
		fen.setTitle("Choix Pokemon");
		fen.setVisible(true);

		JPanel infoPokemon = new JPanel(new GridLayout(1, 1));
		infoPokemon.setSize(200, 600);
		infoPokemon.setBackground(Color.PINK);

		ItemListener itemListener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object selectedItem = e.getItem();
					String nom = selectedItem.toString();
					System.out.println(dresseur.getNomsPokemons());
					MenuDeroulant inventaire = new MenuDeroulant(dresseur.getNomsPokemons());
					// Code à exécuter lorsque l'élément est sélectionné
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					Object deselectedItem = e.getItem();
					System.out.println("Élément désélectionné : " + deselectedItem.toString());
					// Code à exécuter lorsque l'élément est désélectionné
				}
			}
		};

		if (items == null) {
			items = new String[] { "" };
		}
		JComboBox<String> comboBox = new JComboBox<>(items);
		comboBox.addItemListener(itemListener);
		infoPokemon.add(comboBox);
		fen.add(infoPokemon);

	}
}
