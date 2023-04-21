package jeu.eu.ensg.Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import jeu.eu.ensg.GestionPokemon.Combat;
import jeu.eu.ensg.GestionPokemon.Pokemon;




public class InterfaceCombat extends JFrame {
	
	
	/**
	 * 
	 */
	// définitions de paramètres fixes
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	private static final Color BACKGROUND_COLOR = Color.white;
	private static final String TITLE = "Combat";
	private static final int BUTTON_WIDTH = 100;
	private static final int BUTTON_HEIGHT = 100;

	

	public InterfaceCombat(Combat combat) {
		
		// taille et couleur du pannel
		
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(BACKGROUND_COLOR);
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// Pannel bouton (Panel inférieur)
		JPanel figth = new JPanel(new GridBagLayout());
		figth.setVisible(true);
		figth.setBackground(Color.white);
		getContentPane().add(figth);
		
		// Panel visuel (Panel supérieur)
		JPanel infocombat =new JPanel(new GridLayout(2, 3)); // 2 lignes, 3 colonne
		getContentPane().add(infocombat);
		setTitle("Combat"); 
		setVisible(true);
         
        //création des boutons pannel inférieur  
		
		JButton attaque = new JButton("ATTAQUE"); 
		JButton fuir = new JButton("FUITE");
		JButton team = new JButton("EQUIPE");
		JButton capture = new JButton("Capture");
		
		// création du Label KO
		
		JLabel labelKO = new JLabel(" Votre Pokémon est KO ");
		labelKO.setForeground(Color.RED);
		labelKO.setVisible(false);
		
		// création du label Super Efficace et Peu Efficace
		JLabel labelsefficace = new JLabel(" C'est super efficace ! ");
		labelsefficace.setForeground(Color.CYAN);
		labelsefficace.setVisible(false);
		
		JLabel labelpefficace = new JLabel(" C'est peu efficace ! ");
		labelpefficace.setForeground(Color.CYAN);
		labelpefficace.setVisible(false);
		
		//Création du Label GAME OVER
		
		JLabel labelGameOver = new JLabel(" GAME OVER");
		labelGameOver.setForeground(Color.RED);
		labelGameOver.setVisible(false);
		
		
		// création du label Choix pokémon
		JLabel labelChoix = new JLabel(" Choisissez votre Pokémon ");
		labelChoix.setForeground(Color.RED);
		labelChoix.setVisible(false);
		//figth.add(labelChoix);
		
		// Nom des pokémon et pv dans le pannel supérieur
		JLabel monpokemon = new JLabel( combat.equipe.get(0).getName()+" PV :"+ combat.equipe.get(0).getHp()); // va chercher les Pv du pokémon 
		JLabel pokemonadverse = new JLabel(combat.pokemonDEF.getName()+ " PV : "+ combat.pokemonDEF.getHp()); // va chercher les Pv du pokémon adverse
		
		//Affichage des sprites par rapport aux pokémon
		
				ImageIcon spriteMonPokemon = new ImageIcon("D:\\DeBockRosierMiras\\data\\Sprite_B\\"+ combat.equipe.get(0).getId() + ".png");
				ImageIcon spritePokemonAdverse = new ImageIcon("D:\\DeBockRosierMiras\\data\\Sprite\\" + combat.pokemonDEF.getId()+  ".png");
				
			
				
				
				// création des JLabel pour afficher les sprites
				
				JLabel labelSpriteMonPokemon = new JLabel();
				JLabel labelSpritePokemonAdverse = new JLabel();
				
				
				labelSpriteMonPokemon.setIcon(spriteMonPokemon);
				labelSpritePokemonAdverse.setIcon(spritePokemonAdverse);
			
		//Taille et Police des Labels
				
		Font police1 = new Font("Arial", Font.BOLD, 35);
		monpokemon.setFont(police1);
		pokemonadverse.setFont(police1); // on apllique la police et taille définit aux Labels
		
		Font police2 = new Font("Arial", Font.BOLD, 20);
		labelKO.setFont(police2);
		labelChoix.setFont(police2);
		labelsefficace.setFont(police2);
		labelpefficace.setFont(police2);
		
		
		Font police3 = new Font("Arial", Font.BOLD, 50);
		labelGameOver.setFont(police3);
		
		
		// Création d'un gestionnaire de disposition GridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    infocombat.setLayout(layout);  
		
		// mise en page des labels
		GridBagConstraints gbcI = createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.SOUTHWEST);
		GridBagConstraints gbcII = createGridBagConstraints(1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NORTHEAST);
		GridBagConstraints gbcIII = createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.BASELINE, GridBagConstraints.BASELINE);
		GridBagConstraints gbcIV = createGridBagConstraints(1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BASELINE);
		GridBagConstraints gbcV = createGridBagConstraints(1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.CENTER);
		GridBagConstraints gbcVI = createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.BASELINE, GridBagConstraints.EAST);
		GridBagConstraints gbcVII = createGridBagConstraints(1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BASELINE);
		
		// On définit l'emplacement des différents boutons, voir méthode createGridBagConstraints
		
		// ajout des labels au panel figth avec les critères de mise en page
		figth.add(monpokemon,gbcI);
		figth.add(pokemonadverse, gbcII);
		figth.add(labelKO, gbcIII);  
		figth.add(labelChoix, gbcIV);
		figth.add(labelGameOver, gbcV);
		figth.add(labelsefficace);
		figth.add(labelpefficace);
		figth.add(labelSpriteMonPokemon, gbcVI);
		figth.add(labelSpritePokemonAdverse, gbcVII);
		
		
	    // Condition d'affichage des Labels Ko et Choix 
	    
		
		
		if (combat.equipe.get(0).getHp() == 0) { // si les Pv du pokémon en combat sont nuls affiche le Label Ko 
			labelKO.setVisible(true); // Affiche le label "KO"
			labelChoix.setVisible(true); //affiche le Label Choix si il reste des pokémon non Ko dans l'équipe
			attaque.setEnabled(false); // désactive le bouton
			fuir.setEnabled(false);
			capture.setEnabled(false);
			capture.setVisible(false);
			} else if (combat.pokemonDEF.getHp() <= 0) { // si les Pv du pokémon adverse tombe à 0, affichage du bouton capture et désactivation des autres boutons
			capture.setEnabled(true);
			capture.setVisible(true);
			attaque.setEnabled(false);
			attaque.setVisible(false);
			fuir.setEnabled(false);
			team.setEnabled(false);
			
			
			} else { // cas du combat en cours 
			capture.setEnabled(false);
			capture.setVisible(false);
			labelKO.setVisible(false); // Cache le label "KO"
			labelChoix.setVisible(false);
			attaque.setEnabled(true);
			fuir.setEnabled(true);
			} 
		
		boolean allHpZero = true; // initialiser une variable booléenne à true pour les Pv de l'équipe

		for (Pokemon pokemon : combat.equipe) {
		    if (pokemon.getHp() > 0) {
		        allHpZero = false; // si le HP d'un Pokémon est supérieur à 0, la variable devient false
		        break; // sortir de la boucle car au moins un Pokémon est en vie
		    }
		}

		if (allHpZero) {
		    labelGameOver.setVisible(true); // afficher le label "Game over"
		    attaque.setEnabled(false); // désactive les boutons
		    fuir.setEnabled(false);
		    capture.setEnabled(false);
		    team.setEnabled(false);
		    labelChoix.setVisible(false);
		}
		
	     // Action des boutons
	     attaque.addActionListener(new ActionListener() { // ajout d'un évenement lorsque l'on presse le bouton attaque 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.out.println("Choisissez une attaque !");
	                if(e.getSource()==attaque) {
	                	
	                	getContentPane().remove(infocombat); // enlève le pannel actuel
	                	getContentPane().revalidate();
	                	getContentPane().repaint();
	                	JSplitPane splitPane = (JSplitPane) getContentPane().getComponent(0); // continue la séparation en 2 du Frame
	                	splitPane.setDividerLocation(HEIGHT / 2);
	                	splitPane.setBottomComponent(new FenetreAttaque(combat));
	                	FenetreAttaque FenetreAttaque = new FenetreAttaque(combat); // lancement du Panel FenetreAttaque par appel de méthode
	                	getContentPane().add(FenetreAttaque);
	                	getContentPane().revalidate();
	                }
	              
	            }
	        });
	        fuir.addActionListener(new ActionListener() { // ajout d'un évenement lorsque l'on presse le bouton fuir 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.out.println("Vous prenez la fuite !");
	                combat.setEtatCombat(false);
                    dispose();
	            }
	        });
	        
	        team.addActionListener(new ActionListener() { // ajout d'un évenement lorsque l'on presse le bouton team
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.out.println("Sélectionner un Pokémon!");
	                if(e.getSource()==team) {
	                	
	                	getContentPane().remove(infocombat); // même démarche 
	                	getContentPane().revalidate();
	                	getContentPane().repaint();
	                	JSplitPane splitPane = (JSplitPane) getContentPane().getComponent(0);
	                	splitPane.setDividerLocation(HEIGHT / 2);
	                	splitPane.setBottomComponent(new FenetreTeam(combat));
	                	FenetreTeam FenetreTeam = new FenetreTeam(combat);
	                	getContentPane().add(FenetreTeam);
	                	getContentPane().revalidate();}
	            }
	        });
	        
	        
	        capture.addActionListener(new ActionListener() { // ajout d'un évenement lorsque l'on presse le bouton capture
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.out.println("Capturez le Pokemon!");
	                if(e.getSource()==capture) { // lance la méthode capture
	                    combat.Capturer(combat.pokemonDEF);
	                    combat.setEtatCombat(false);
	                   	System.out.println("Vous avez capturé !"+ combat.pokemonDEF.getName());
	                  	combat.resetEquipe();
	                	dispose(); // ferme la fenetre combat
	                }    	
	            }	
	        });      
	        
	        // dimension des boutons
	        attaque.setPreferredSize(new Dimension(BUTTON_WIDTH+200, BUTTON_HEIGHT));
	        fuir.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
	        team.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
	        capture.setPreferredSize(new Dimension(BUTTON_WIDTH+200, BUTTON_HEIGHT));
	        
	        // espace et disposition des boutons
	        
	        GridBagConstraints gbc1 = createGridBagConstraints(1, 0, 1, 1, GridBagConstraints.BASELINE, GridBagConstraints.CENTER);
	        GridBagConstraints gbc2 = createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.BASELINE, GridBagConstraints.CENTER);
	        GridBagConstraints gbc3 = createGridBagConstraints(2, 0, 1, 1, GridBagConstraints.BASELINE, GridBagConstraints.CENTER);
	        GridBagConstraints gbc4 = createGridBagConstraints(1, 0, 1, 1, GridBagConstraints.BASELINE, GridBagConstraints.CENTER);
	       
	        // Ajout des boutons au panel
	        infocombat.add(attaque, gbc1);
	        infocombat.add(fuir, gbc2);
	        infocombat.add(team, gbc3);
	        infocombat.add(capture, gbc4);
	        
	        // création du JSplitPane pour séparer le frame en deux panneaux
	        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, figth, infocombat);
	     //   splitPane.setOneTouchExpandable(true);
	        splitPane.setDividerLocation(HEIGHT / 2);

	        // ajout du JSplitPane au frame
	        add(splitPane);
	        setVisible(true);
}

	    
	
 
	
	// méthode permettant de paramétrer le placement des boutons afin de gagner de la place dans le code.
	public static GridBagConstraints createGridBagConstraints(int gridx, int gridy, double weightx, double weighty, int fill, int anchor) {
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridx = gridx; // précise la ligne pour x et la colonne pour y
	    gbc.gridy = gridy;
	    gbc.weightx = weightx; // précise le nombre de ligne ou de colonne qu'un composant possède dans sa zone d'affichage
	    gbc.weighty = weighty;
	    gbc.fill = fill; // ajuste la taille du composant si trop grand pour l'espace
	    gbc.anchor = anchor; // ajuste dans le cas ou le composant est plus petit
	    return gbc;
	}
	
	

}