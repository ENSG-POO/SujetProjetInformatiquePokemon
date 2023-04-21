package jeu.eu.ensg;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*; // import pour les coordonnée de la souris
import java.util.*;
import javax.swing.*;

import jeu.eu.ensg.gui.CartePanel;
import jeu.eu.ensg.gui.ControlePanel;
import jeu.eu.ensg.gui.FenetreCombat;
import jeu.eu.ensg.gui.FichePanel;
import jeu.eu.ensg.gui.Carte;


public class MainApp {

	public static void xaxa(Trainer t,ArrayList<Pokemon> listePokemonSauvages) {
		// Look and Feel dépend de l'OS.
		try {
			String os = System.getProperty("os.name").toLowerCase();
			
			// For windows os
			if (os.contains("windows")) {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			}
			// For linux os
			if ((os.contains("linux")) || (os.contains("unix"))) {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			}
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}


		final JFrame fen = new JFrame();
		fen.setSize(1200, 800);

		// just a JPanel extension, add to any swing/awt container
		final Carte map = new Carte(); 
		final CartePanel mapPanel = new CartePanel(); 


		fen.setLayout(new BorderLayout());
		
		fen.add(BorderLayout.CENTER, map);
		fen.add(BorderLayout.EAST, new FichePanel());
		fen.add(BorderLayout.SOUTH, new ControlePanel(mapPanel));
		
		
		fen.setLocationRelativeTo(null);
		fen.setResizable(false);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setTitle("Jeu Pokémon");
		
		// récupération coordonnée de la souris		
		fen.addMouseListener(new MouseAdapter() {
		    @Override 
		    public void mousePressed(MouseEvent e) {
				System.out.println("X=" + e.getX() + " ,Y=" + e.getY());
				Double X =(double) e.getX();
				Double Y =(double) e.getY();
				Coordinates C = new Coordinates(X,Y);

				
				
				ArrayList<Pokemon> pok = t.getEquipe();

				List<String> nom_pok = new ArrayList<String>();
					for (int i=0;i<pok.size();i++) {
						nom_pok.add(pok.get(i).getNom());
					}
				
				List<Pokemon> Listeproxi = C.listePokemonsProximite(listePokemonSauvages, 100);
				List<String> nom = new ArrayList<String>();
				for (int i=0;i<Listeproxi.size();i++) {
					nom.add(Listeproxi.get(i).getNom());
				}
				
				JComboBox<String> cb = new JComboBox<String>(new Vector<String>(nom));
				JFrame selec = new JFrame();
				selec.add(cb);

				selec.setSize(new Dimension(200,200));

				selec.pack();
				selec.setVisible(true);
				selec.setTitle("Choisir Pokemon enemi");
				
				cb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String selectedOption = (String) cb.getSelectedItem();
						System.out.println("Selected option: " + selectedOption);
						selec.dispose();
						
						Pokemon pok_enemi = Listeproxi.get(Pokemon.FindbyName(Listeproxi, selectedOption));
						JFrame selec2 = new JFrame();
						selec2.setSize(2000,2000);
						selec2.setVisible(true);
						selec2.setTitle("Choisir Pokemon dresseur");
						JComboBox<String> cb2 = new JComboBox<String>(new Vector<String>(nom_pok));
						selec2.add(cb2);
						selec2.pack();
						cb2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent f) {
								String selectedOption2 = (String) cb2.getSelectedItem();
								selec2.dispose();
								
								Pokemon pok_allie = pok.get(Pokemon.FindbyName(pok, selectedOption2));
								Combat ca = new Combat(pok_allie,pok_enemi,false,t,listePokemonSauvages);
								
								FenetreCombat fen = new FenetreCombat(t, ca.getPJ(), ca,listePokemonSauvages);
								fen.setVisible(true);

								System.out.println("Debut du combat!");
								System.out.println("Votre Pokemon: " +ca.getPJ().getNom()+ " ,Niveau : " + Integer.toString(ca.getPJ().getStats().getLvl()));
								System.out.println("Pokemon Ennemi: " +ca.getPS().getNom()+ " ,Niveau : " + Integer.toString(ca.getPS().getStats().getLvl()));

								while (ca.getPS().getHP()>=0) {

									//Au debut du combat , PJ doit etre retirée de l'équipe sinon il est dupliqué
									ArrayList<Pokemon> Tem = t.getEquipe();
									Tem.remove(ca.getPJ());
									t.setEquipe(Tem);
									fen.PVJ.setText(ca.getPJ().getNom() + " " + ca.getPJ().getHP()+"/"+ca.getPJ().getStats().getHpMax());
									fen.PVS.setText(ca.getPS().getNom() + " " + ca.getPS().getHP()+"/"+ca.getPS().getStats().getHpMax());

									if (ca.getPS().getStats().getSpeed()>ca.getPJ().getStats().getSpeed()) {
										System.out.println("L'ennemei est plus rapide que vous est attaque en premier !");
										ca.attaque_enemi();
									}

									System.out.println("C'est votre tour!");



									//ACTIVATION DES BOUTTONS
									fen.Main.setEnabled(true);


								}
								fen.setVisible(false);


								
					










































		    	    	  }
		    	      });

		    	  }
		      });
		 }});

		fen.setVisible(true);
	}

}