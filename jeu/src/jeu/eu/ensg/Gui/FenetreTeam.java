package jeu.eu.ensg.Gui;
import jeu.eu.ensg.GestionPokemon.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




public class FenetreTeam extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	FenetreTeam(Combat combat){
	// taille et couleur du panneau
	
	this.setSize(600, 600);
	this.setBackground(Color.white);
	
	
	this.setLayout(new GridLayout(1, 2)); // 1 lignes, 2 colonne
	// Initialisation du label "KO"
   
   
	
	setVisible(true);
	// Boucle créant un bouton pour chaque pokémon compris dans l'équipe
	for (Pokemon pokemon : combat.equipe)  {
	    JButton bouton = new JButton(pokemon.getName());
	    bouton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int index = combat.equipe.indexOf(pokemon); // prend la valeur de l'indice de chaque pokémon
	        	
	            System.out.println("Vous avez choisi  " + pokemon.getName());
	            
	           	combat.Switch(combat.equipe.get(index)); // appel de la méthode permmettant d'échanger 2 pokémon dans l'equipe
	           	if ( index == 0) { // si le pokémon est déjà en combat, le switch ne fait rien et retour a l'interface
	           	System.out.println( pokemon.getName()+ " est deja en combat");
	           	JFrame ancienneframe = (JFrame)SwingUtilities.getWindowAncestor(FenetreTeam.this);
            	ancienneframe.dispose();
            	InterfaceCombat newInterface = new InterfaceCombat(combat);
            	newInterface.setVisible(true);
	           		
	           	}
            //	combat.AtqNeutre(combat.pokemonDEF, combat.equipe.get(0));
            	JFrame ancienneframe = (JFrame)SwingUtilities.getWindowAncestor(FenetreTeam.this);
            	ancienneframe.dispose();
            	InterfaceCombat newInterface = new InterfaceCombat(combat);
            	newInterface.setVisible(true);
	        }
	    });
	    if (pokemon.getHp() == 0) { // si le pokémon est KO, désactive le bouton qu'il lui est associé.
	    	System.out.println("Votre" + pokemon.getName()+" est KO!");
	        bouton.setEnabled(false);
	    }
	    this.add(bouton);}
	 // Créer un bouton "Retour"
		JButton boutonRetour = new JButton("Retour");
		boutonRetour.setPreferredSize(new Dimension(100, 80));
	    this.add(boutonRetour);
	
	// Ajouter un ActionListener au bouton "Retour"
    boutonRetour.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { // retour à l'interface d'originie quand on appui sur retour
            // Fermer la fenêtre actuelle
        	JFrame ancienneframe = (JFrame)SwingUtilities.getWindowAncestor(FenetreTeam.this);
        	ancienneframe.dispose(); 
            // Ouvrir la fenêtre précédente
            InterfaceCombat newInterface = new InterfaceCombat(combat);
        	newInterface.setVisible(true);}
    });
}

	
	
	// méthode permettant de paramétrer le placement des boutons afin de gagner de la place dans le code.
		public static GridBagConstraints createGridBagConstraints(int gridx, int gridy, double weightx, double weighty, int fill, int anchor) {
		    GridBagConstraints gbc = new GridBagConstraints();
		    gbc.gridx = gridx;
		    gbc.gridy = gridy;
		    gbc.weightx = weightx;
		    gbc.weighty = weighty;
		    gbc.fill = fill;
		    gbc.anchor = anchor;
		    return gbc;
		}
	
	
	
}