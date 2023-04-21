package jeu.eu.ensg.Gui;


import jeu.eu.ensg.GestionPokemon.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

   
public class FenetreAttaque extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	FenetreAttaque(Combat combat){
	// taille et couleur du pannel
	
	this.setSize(600, 600);
	this.setBackground(Color.white);
	this.setLayout(new GridLayout(1, 2)); // 1 lignes, 2 colonne
	setVisible(true);
	
	// Boutons d'attaques
	JButton attaque1 = new JButton("ATTAQUE NEUTRE"); // bouton affichant attaque neutre
	JButton attaque2 = new JButton("ATTAQUE TYPE : " + combat.equipe.get(0).getType1()); // bouton affichant l'attaque type et le type
	
	
	 // Créer un bouton "Retour"
	JButton boutonRetour = new JButton("Retour");
	
	//taille des boutons
	attaque1.setPreferredSize(new Dimension(200, 80));
	attaque2.setPreferredSize(new Dimension(200, 80));
	boutonRetour.setPreferredSize(new Dimension(100, 80));
	
	
	// Création d'un gestionnaire de disposition GridBagLayout
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);  
	
	
	// Positionnement des boutons:
	
	 GridBagConstraints gbc1 = InterfaceCombat.createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER);
	 GridBagConstraints gbc2 = InterfaceCombat.createGridBagConstraints(1, 0, 1, 1, GridBagConstraints.NORTHEAST, GridBagConstraints.CENTER);
	 GridBagConstraints gbc3 = InterfaceCombat.createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BASELINE);
	
	
	// ajout des boutons et mise en page au Panel

	this.add(attaque1, gbc1);
    this.add(attaque2,gbc2);   
    this.add(boutonRetour,gbc3);
 
    
    // Ajouter un ActionListener au bouton "Retour"
    boutonRetour.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Fermer la fenêtre actuelle
        	JFrame ancienneframe = (JFrame)SwingUtilities.getWindowAncestor(FenetreAttaque.this);
        	ancienneframe.dispose(); 
            // Ouvrir la fenêtre précédente
            InterfaceCombat newInterface = new InterfaceCombat(combat);
        	newInterface.setVisible(true);}
    });
    
  //Action des boutons d'attaques
    attaque1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(" utilise l'attaque neutre !");
            if(e.getSource()==attaque1) { // lorsque le bouton attaquez neutre est pressé, lance l'attaque
            	if( combat.equipe.get(0).getSpeed()>=combat.pokemonDEF.getSpeed()) {
            	combat.AtqNeutre(combat.pokemonDEF);
            	          	
            	if (combat.pokemonDEF.getHp()!= 0) { // si le pokémon adverse est vivant, il attaque 
            	combat.AtqEnnemie();}
            	} else {
            		combat.AtqEnnemie();
            		if (combat.pokemonATQ.getHp()!= 0) {
            			combat.AtqNeutre(combat.pokemonDEF);// si le pokémon possédé est vivant, il attaque 
                	;}
                	
            	}
            	
            	// commande fermant le pannel et actualisant la fenêtre
            	JFrame ancienneframe = (JFrame)SwingUtilities.getWindowAncestor(FenetreAttaque.this);
            	ancienneframe.dispose();            	
            	InterfaceCombat newInterface = new InterfaceCombat(combat);
            	newInterface.setVisible(true);
               }
             }    
	});
    
    attaque2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(" utilise l'attaque type !");
            
            if(e.getSource()==attaque2) { // lorsque l attaque type est pressé, lance l'attaque 
            	
            	if( combat.equipe.get(0).getSpeed()>=combat.pokemonDEF.getSpeed()) {
                	combat.AtqSpe(combat.pokemonDEF);
                	          	
                	if (combat.pokemonDEF.getHp()!= 0) { // si le pokémon adverse est vivant, il attaque 
                	combat.AtqEnnemie();}
                	} else {
                		combat.AtqEnnemie();
                		if (combat.equipe.get(0).getHp()!= 0) {
                			combat.AtqSpe(combat.pokemonDEF);// si le pokémon possédé est vivant, il attaque 
                    	;}
                    	
                	}
            	
            	if ( Combat.getCoef(combat.pokemonATQ, combat.pokemonDEF) >= 2 ) {
            		System.out.println(" L'attaque est super efficace !");}
            		
            	else if ( Combat.getCoef(combat.pokemonATQ, combat.pokemonDEF) <= 0.5 ) {
            		System.out.println(" L'attaque est peu efficace !");}
            	
            	
            	// commande fermant le pannel et actualisant la fenêtre
            	JFrame ancienneframe = (JFrame)SwingUtilities.getWindowAncestor(FenetreAttaque.this); 
            	ancienneframe.dispose();
            	InterfaceCombat newInterface = new InterfaceCombat(combat);
            	newInterface.setVisible(true);
            }
           }
    });
    
	}
}