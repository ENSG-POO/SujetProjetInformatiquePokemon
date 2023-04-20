package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gestion_jeu.Joueur;
import pack1.Combat;
import pack1.PokeDomestique;
import pack1.PokeSauvage;
import pack1.Pokemon;

public class CombatPanel extends JPanel {
	
	public Joueur j;
	public Combat c;
	
	public CombatPanel(Joueur j, Combat c) {
		
		this.setSize(200, 50);
		
		JPanel infoCombat = new JPanel (new GridLayout (2,2));
		
		JLabel label = new JLabel("Choisissez le pokémon sauvage");
        infoCombat.add(label);
        String[] choixPokS = {"Pikachu", "Bulbizard", "Carapuce", "Salamèche"}; //liste à modifier selon les pokémons autour sur map
        JComboBox cb = new JComboBox(choixPokS);
        infoCombat.add(cb);
        
        JLabel labe2 = new JLabel("Choisissez votre pokémon pour combattre");
        infoCombat.add(labe2);
        Pokemon[] choixPokD = j.pokedex ; //pokémon domestique du joueur 
        JComboBox cb2 = new JComboBox(choixPokD);
        infoCombat.add(cb2);
        
        add(infoCombat);
        
        JButton clic = new JButton("Valider le combat");
		clic.setBounds(50, 50, 20, 100);
		this.add(clic);  
		clic.setVisible(true);
		
		// On ajoute un évènement sur le bouton
		clic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PokeSauvage pokeS = new PokeSauvage (cb.getSelectedItem().toString());
				PokeDomestique  pokeD = new PokeDomestique (cb2.getSelectedItem().toString(), j);
				
				c.pokeS = pokeS;
				c.pokeD = pokeD;
				
				System.out.println(cb.getSelectedItem().toString());
				System.out.println(cb2.getSelectedItem().toString());
				
				
				
			}
		});
        
        
	}

}
