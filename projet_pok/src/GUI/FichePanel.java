package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gestion_jeu.Joueur;
import pack1.Pokemon;
import pack1.coord;

/**
 * Exemple de panneau contenant des composants de formulaire. 
 * 
 *
 */
public class FichePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public Joueur j;
	
	public FichePanel(Joueur j) {
		
		this.setSize(10, 10);
		this.setBackground(Color.BLUE);
		
		JPanel infoJoueur = new JPanel (new GridLayout (4,1));
		
		
		JLabel nomJoueur = new JLabel ("Nom Joueur");
		infoJoueur.add(nomJoueur);
		JTextField joueurName = new JTextField(15);
		joueurName.setText(" ");
		infoJoueur.add(joueurName);
		
        JLabel label = new JLabel("Choisissez votre premier Pokémon");
        infoJoueur.add(label);
        String[] choixPok = {"Bulbazaur", "Bulbizard", "Carapuce", "Salamèche"};
        JComboBox cb = new JComboBox(choixPok);
        infoJoueur.add(cb);
        
		
		add(infoJoueur);
		
		JButton clic = new JButton("Valider avatar");
		clic.setBounds(50, 50, 20, 100);
		this.add(clic);  
		clic.setVisible(true);
		
		// On ajoute un évènement sur le bouton
		clic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cartePanel.ajoutMessage("Ici, hello !");
				String new_name = joueurName.getText();
				Pokemon pokeDep = new Pokemon (cb.getSelectedItem().toString());
				Pokemon[] new_pokedex = {pokeDep};
				
				j.setJoueur(new_name, new_pokedex);
				clic.setVisible(false); //une fois que l'on a validé les premières informations du joueur 
										// on cache le button pour ne plus modifier l'avatar
				
				//System.out.println(joueurName.getText());
				//System.out.println(cb.getSelectedItem().toString());
				
				System.out.println(j);
				
				
			}
		});
	}

}
