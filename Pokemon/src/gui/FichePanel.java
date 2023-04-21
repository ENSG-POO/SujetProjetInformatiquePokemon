package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
		
		 JPanel grille = new JPanel();
	     grille.setLayout(new GridLayout(300, 300 ));
	      //   70 lignes, 70 colonnes, espacement horizontal et vertical de 5 pixels
	       add(grille);
		JPanel principal = new JPanel();
	    principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
	    
		
		this.setSize(800, 1200);
		this.setBackground(Color.RED);
		
		JPanel infoPokemon_sauvage = new JPanel(new GridLayout(4,2));
		
		JLabel labelInterfacesauvage = new JLabel("Pokemon sauvage");
		infoPokemon_sauvage.add(labelInterfacesauvage);
		JTextField empty = new JTextField(10);
		empty.setText(" ");
		infoPokemon_sauvage.add(empty);
		
		JLabel labelNom = new JLabel("Nom Pokémon:");
		infoPokemon_sauvage.add(labelNom);
		JTextField pokemonName = new JTextField(10);
		pokemonName.setText("Dracaufeu");
		infoPokemon_sauvage.add(pokemonName);
		
		JLabel labelFamille = new JLabel("Type Pokémon:");
		infoPokemon_sauvage.add(labelFamille);
		JTextField pokemonType = new JTextField(10);
		pokemonType.setText("Feu");
		infoPokemon_sauvage.add(pokemonType);
		
		JLabel LabelPV = new JLabel(" PV Pokémon:");
		infoPokemon_sauvage.add(LabelPV);
		JTextField pokemonPV = new JTextField(10);
		pokemonPV.setText("80");
		infoPokemon_sauvage.add(pokemonPV);
		
		principal.add(infoPokemon_sauvage, BorderLayout.EAST);
		
		JPanel infoPokemon_utilisateur = new JPanel(new GridLayout(7,2));
		
		JLabel labelInterfaceutilisateur = new JLabel("Pokemons joueur");
		infoPokemon_utilisateur.add(labelInterfaceutilisateur);
		JTextField empty2 = new JTextField(10);
		empty2.setText(" ");
		infoPokemon_utilisateur.add(empty2);
		
		JLabel labelNomutilisateur = new JLabel("Nom Pokémon:");
		infoPokemon_utilisateur.add(labelNomutilisateur);
		JTextField pokemonNameutilisateur = new JTextField(10);
		pokemonNameutilisateur.setText("Dracaufeu");
		infoPokemon_utilisateur.add(pokemonNameutilisateur);
		
		JLabel labelFamilleutilisateur = new JLabel("Type Pokémon 1:");
		infoPokemon_utilisateur.add(labelFamilleutilisateur);
		JTextField pokemonTypeutilisateur = new JTextField(10);
		pokemonTypeutilisateur.setText("Feu");
		infoPokemon_utilisateur.add(pokemonTypeutilisateur);
		
		JLabel labelFamilleutilisateur2 = new JLabel("Type Pokémon 2:");
		infoPokemon_utilisateur.add(labelFamilleutilisateur2);
		JTextField pokemonTypeutilisateur2 = new JTextField(10);
		pokemonTypeutilisateur2.setText("Feu");
		infoPokemon_utilisateur.add(pokemonTypeutilisateur2);
		
		JLabel LabelPVutilisateur = new JLabel(" PV Pokémon:");
		infoPokemon_utilisateur.add(LabelPVutilisateur);
		JTextField pokemonPV1 = new JTextField(10);
		pokemonPV1.setText("80");
		infoPokemon_utilisateur.add(pokemonPV1);
		
		JLabel LabelAttack_neutre = new JLabel(" Attaque neutre");
		infoPokemon_utilisateur.add(LabelAttack_neutre);
		JTextField attack_neutre = new JTextField(10);
		attack_neutre.setText("charge");
		infoPokemon_utilisateur.add(attack_neutre);
		
		JLabel LabelAttack_type = new JLabel(" Attaque type");
		infoPokemon_utilisateur.add(LabelAttack_type);
		JTextField attack_type = new JTextField(10);
		attack_type.setText("lance-flamme");
		infoPokemon_utilisateur.add(attack_type);
		
		principal.add(infoPokemon_utilisateur,BorderLayout.WEST  );
		add(principal);
		add(grille);
		
	}

}