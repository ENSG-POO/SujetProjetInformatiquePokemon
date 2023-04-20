package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Exemple de panneau contenant des composants de formulaire.
 * 
 *
 */
public class FichePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] items;
	private JPanel infoPokemon;
	private String selectedItem;

	public FichePanel() {

		this.setSize(200, 600);
		this.setBackground(Color.PINK);

		JPanel infoPokemon = new JPanel(new GridLayout(1, 2));

		JLabel labelNom = new JLabel("Choix Pokemon:");
		infoPokemon.add(labelNom);

		add(infoPokemon);

		/*ItemListener itemListener = new ItemListener() {
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

		if (items == null) {
			items = new String[] { "" };
		}
		JComboBox<String> comboBox = new JComboBox<>(items);
		comboBox.addItemListener(itemListener);*/

		//infoPokemon.add(comboBox);
		this.infoPokemon = infoPokemon;
		
		JButton clic = new JButton("Choisir");
		clic.setBounds(50, 50, 20, 100);
		this.add(clic);
		clic.setVisible(true);
		infoPokemon.add(clic);
		String[] items = this.items;
		
		clic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDeroulant menu = new MenuDeroulant(items);
			}
		});
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	public void getItems() {
		for (String item : this.items) {
			System.out.println(item);
		}
	}


	public JPanel getInfoPokemon() {
		return infoPokemon;
	}

	public void setInfoPokemon(JPanel infoPokemon) {
		this.infoPokemon = infoPokemon;
	}
	
	

}
