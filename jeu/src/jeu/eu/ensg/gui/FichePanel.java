package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Exemple de panneau contenant des composants de formulaire.
 * 
 *
 */
public class FichePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public FichePanel() {

		this.setSize(200, 600);
		this.setBackground(Color.PINK);

		
        // Utilisation de BoxLayout avec orientation verticale
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //JPanel infoPokemon = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel infoPokemon = new JPanel(new GridLayout(2, 2));

		// Utilisation de FlowLayout avec alignement à gauche
        //infoPokemon.setLayout(new FlowLayout(FlowLayout.LEFT));
        
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

		ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Object selectedItem = e.getItem();
                    System.out.println("Élément sélectionné : " + selectedItem.toString());
                    // Code à exécuter lorsque l'élément est sélectionné
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    Object deselectedItem = e.getItem();
                    System.out.println("Élément désélectionné : " + deselectedItem.toString());
                    // Code à exécuter lorsque l'élément est désélectionné
                }
            }
        };
        
        String[] items = {"", "coucou", "deux", "trois"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.addItemListener(itemListener);
        // pour creer un espace entre les deux objets
        add(Box.createVerticalStrut(600));
        //add(comboBox);
        
        // Utilisation de Box.createVerticalGlue pour ajouter de l'espace entre infoPokemon et la liste déroulante
        //add(Box.createVerticalGlue());
        add(comboBox);
    }
}




