package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gestion_jeu.Jeu;
import gestion_jeu.Joueur;
import pack1.Attaque;
import pack1.Combat;
import pack1.PokeDomestique;
import pack1.PokeSauvage;
import pack1.Pokemon;
import pack1.coord;

public class CombatPanel extends JPanel {
	
	public Joueur j;
	public Combat c;
	public Jeu game;
	public double pvS;
	public double pvD;
	public MapPanel map;
	public List<Pokemon> pokemonsProches;
	
	public CombatPanel(Joueur j, Combat c, Jeu game, MapPanel map) {
		
		this.setSize(200, 50);
		
		//création du premier panel pour le choix des pokémons qui vont combattre 
		JPanel infoCombat = new JPanel (new GridLayout (25 ,2));
		
		JLabel label = new JLabel("Choisissez le pokémon sauvage");
        infoCombat.add(label);
        coord coord1 = new coord(map.getX(),map.getY());
        
        pokemonsProches = game.trouverPokemonProche(5, coord1.x, coord1.y); //liste à modifier selon les pokémons autour sur map
        String[] l = game.listToString(pokemonsProches);
        
        JComboBox<String> cb = new JComboBox<>(l);
        ComboBoxModel<String> cbTest = new DefaultComboBoxModel<>(l);
        cb.setModel(cbTest);
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
				
				pvS = c.pokeS.getPV();
				pvD = c.pokeD.getPVd();
				
				//while (pvS != 0 && pvD != 0) {
				
				
				//avant de commencer le combat, on affiche les PV des 2 pokémons au départ
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
						pvS -= coutN;
						afPVS.setText("PV pokémon sauvage: " + pvS); 
						
						//on crée ensuite une action "aléatoire" qui lance l'attaque du pokemon sauvage
						double m = Math.random()*10; // si inférieur à 5 attaque Neutre sinon attaque Spéciale
						System.out.println(m);
						
						if (m<5) {
							Attaque a2 = new Attaque();
							double coutN2 = a2.attackN();
							pvD-= coutN2;
							afPVD.setText("Attaque du Pokemon Sauvage. PV de ton Pokémon: " + pvD);
						}
						
						else {
							Attaque a2p = new Attaque(pokeS.toPokeCharacter(), pokeD.toPokeCharacter());
							double coutS2 = a2p.attackS();
							pvD -= coutS2;
							afPVD.setText("Attaque du Pokemon Sauvage. PV de ton Pokémon " + pvD);
						}
						
						if (pvS <= 0) {
							JLabel fin = new JLabel ("Le combat est terminé, tu peux maintenant capturer le pokemon");
							infoCombat.add(fin);
							
							
						}
						
						if (pvD <= 0) {
							JLabel fin = new JLabel ("Tu as perdu le combat!");
							infoCombat.add(fin);
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
						pvS -= coutS;
						afPVS.setText("PV pokémon sauvage: " + pvS);
						
						//on crée ensuite une action "aléatoire" qui lance l'attaque du pokemon sauvage
						double m = Math.random()*10; // si inf à 5 attaque N sinon attaque S
						System.out.println(m);
						
						if (m<5) {
							Attaque a3 = new Attaque();
							double coutN2 = a2.attackN();
							pvD -= coutN2;
							afPVD.setText("Attaque du Pokemon Sauvage. PV de ton Pokémon: " + pvD);
						}
						
						else {
							Attaque a2p = new Attaque(pokeS.toPokeCharacter(), pokeD.toPokeCharacter());
							double coutS2 = a2p.attackS();
							pvD -= coutS2;
							afPVD.setText("Attaque du Pokemon Sauvage. PV de ton Pokémon " + pvD);
						}
						
						if (pvS <= 0) {
							JLabel fin = new JLabel ("Le combat est terminé; tu peux maintenant capturer le pokemon");
							infoCombat.add(fin);
						}
						
						if (pvD <= 0) {
							JLabel fin = new JLabel ("Tu as perdu !");
							infoCombat.add(fin);
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
				
			//}
				
				//Boutton pour fuir
				JButton fuir = new JButton("fuir");
				fuir.setBounds(50, 50, 20, 100);
				infoCombat.add(fuir);   
				fuir.setVisible(true);
				
				fuir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JLabel fuite = new JLabel ("Tu abandonnes le combat");
						System.out.println("fuite");
						infoCombat.add(fuite);
						}
				});
				
			}
			
		});
        
	}

}
