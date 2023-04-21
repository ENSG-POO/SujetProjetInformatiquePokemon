package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gestion_jeu.Joueur;
import pack1.Attaque;
import pack1.Combat;
import pack1.PokeDomestique;
import pack1.PokeSauvage;
import pack1.Pokemon;

public class CombatPanel extends JPanel {
	
	public Joueur j;
	public Combat c;
	
	public CombatPanel(Joueur j, Combat c) {
		
		this.setSize(200, 50);
		
		//création du premier panel pour le choix des pokémons qui vont combattre 
		JPanel infoCombat = new JPanel (new GridLayout (10,2));
		
		JLabel label = new JLabel("Choisissez le pokémon sauvage");
        infoCombat.add(label);
        String[] choixPokS = {"Bulbasaur", "Mew", "Poliwag"}; //liste à modifier selon les pokémons autour sur map
        JComboBox cb = new JComboBox(choixPokS);
        infoCombat.add(cb);
        
        JLabel labe2 = new JLabel("Choisissez votre pokémon pour combattre");
        infoCombat.add(labe2);
        Pokemon[] choixPokD = j.pokedex ; //pokémon domestique du joueur 
        System.out.println(choixPokD);
        JComboBox cb2 = new JComboBox(choixPokD);
        infoCombat.add(cb2);
        
        add(infoCombat);
        
        //création du boutton pour valider choix pok
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
				
				clic.setVisible(false);
				JLabel vide = new JLabel (" ");
				infoCombat.add(vide);
				
				
				double pvS = c.pokeS.getPV();
				double pvD = c.pokeD.getPVd();
				
				//while (pvS != 0 && pvD != 0) {
				
				
				//avant de commencer le combat, on affiche les PV des 2 pok au départ
				JLabel afPVS = new JLabel ("PV pokémon sauvage: " + pvS);
				JLabel afPVD = new JLabel ("PV de ton pokémon: " + pvD);
				
				infoCombat.add(afPVS);
				infoCombat.add(afPVD); 
				
				// une fois que l'on a cliqué sur les choix du combat, on peut faire une attaque
				JLabel rien2 = new JLabel (" ");
				infoCombat.add(rien2);
				JLabel premAtt = new JLabel ("Le joueur commence:");
				infoCombat.add(premAtt);
				
				JLabel choixAtt = new JLabel ("-choisis ton attaque");
				infoCombat.add(choixAtt);
				
				//Boutton qui lance une attaque normale
				JButton atN = new JButton ("attaque normale");
				atN.setBounds(50, 50, 20, 100);
				infoCombat.add(atN);  
				atN.setVisible(true);
				
				atN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Attaque a1 = new Attaque();
						double coutN = a1.attackN ();
						afPVS.setText("PV pokémon sauvage: " + (pvS-coutN)); //trouver moyen de modifier pvS et pvD pour le remettre à jour
						
						//on crée ensuite une action "aléatoire" qui lance l'attaque du pokemon sauvage
						double m = Math.random()*10; // si inf à 5 attaque N sinon attaque S
						System.out.println(m);
						
						if (m<5) {
							Attaque a2 = new Attaque();
							double coutN2 = a2.attackN();
							afPVD.setText("Attaque neutre du Pokemon Sauvage : tu perds " + coutN2 + " de PV. Nouveau PV de ton pokémon: " + (pvD-coutN2));
							
						}
						
						else {
							Attaque a2p = new Attaque(pokeS.toPokeCharacter(), pokeD.toPokeCharacter());
							double coutS2 = a2p.attackS();
							afPVD.setText("Attaque spécifique du Pokemon Sauvage : tu perds " + coutS2 + " de PV. Nouveau PV de ton pokémon: " + (pvD-coutS2));
						}
						
					}
				});
				
				//Boutton qui lance une attaque Special
				JButton atS = new JButton ("attaque spéciale");
				atS.setBounds(50, 50, 20, 100);
				infoCombat.add(atS);   
				atS.setVisible(true);
				
				atS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Attaque a2 = new Attaque(c.pokeD.toPokeCharacter(),c.pokeS.toPokeCharacter());
						double coutS = a2.attackS();
						afPVS.setText("PV pokémon sauvage: " + (pvS-coutS));
						
						//on crée ensuite une action "aléatoire" qui lance l'attaque du pokemon sauvage
						double m = Math.random()*10; // si inf à 5 attaque N sinon attaque S
						System.out.println(m);
						
						if (m<5) {
							Attaque a3 = new Attaque();
							double coutN2 = a2.attackN();
							afPVD.setText("Attaque neutre du Pokemon Sauvage : tu perds " + coutN2 + " de PV. Nouveau PV de ton pokémon: " + (pvD-coutN2));
							
						}
						
						else {
							Attaque a2p = new Attaque(pokeS.toPokeCharacter(), pokeD.toPokeCharacter());
							double coutS2 = a2p.attackS();
							afPVD.setText("Attaque spécifique du Pokemon Sauvage : tu perds " + coutS2 + " de PV. Nouveau PV de ton pokémon: " + (pvD-coutS2));
						}
					}
				});
				
				
				//Boutton fait changer de Pokémon
				/*JButton change = new JButton ("changer de Pokémon");
				change.setBounds(50, 50, 20, 100);
				infoCombat.add(change);   
				change.setVisible(true);
				
				change.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JLabel label3 = new JLabel("Choisissez un nouveau pokémon pour combattre");
				        infoCombat.add(labe2);
				        
				        Pokemon[] choixPokD = j.pokedex ; //pokémon domestique du joueur 
				        JComboBox nv_choix = new JComboBox(choixPokD);
				        infoCombat.add(nv_choix);
				        
				        
				        //création du boutton pour valider nouveau choix pok
				        JButton nv = new JButton("Valider");
						nv.setBounds(50, 50, 20, 100);
						infoCombat.add(nv);  
						nv.setVisible(true);
						
						nv.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								PokeDomestique nv_pok = new PokeDomestique(nv_choix.getSelectedItem().toString(), j);
								c.changerpokeD(nv_pok);
								
							}
						});
						
						
					}
				}); */
				
				
				
				
				
				
				
				
				
				
			}
			//}
		});
        
        
	}

}
