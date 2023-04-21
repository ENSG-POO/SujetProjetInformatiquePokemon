package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.eu.ensg.AttaqueList;
import jeu.eu.ensg.Dresseur;
import jeu.eu.ensg.PokeListe;
import jeu.eu.ensg.combat;

public class Combat_temporaire extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Combat_temporaire(String pokemon_inventaire, String adversaire, int id_pokemon, int id_adversaire, Dresseur dresseur)  {
		PokeListe poke = null;
		AttaqueList att = null;
		try {
			poke = new PokeListe();
			att = new AttaqueList();
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println(dresseur);
		final JFrame fen = new JFrame();
		fen.setSize(1000, 1000);
		fen.setTitle("Choix Pokemon");
		fen.setVisible(true);

		JPanel infoPokemon = new JPanel(new GridLayout(1, 3));
		infoPokemon.setSize(200, 600);
		infoPokemon.setBackground(Color.PINK);
		String chemin1 ="";
		String chemin2="";
		  // code pouvant lancer une exception
		chemin1 = "../../data/Images/pokepedia/"+poke.getPokemon(id_pokemon).getName() + ".png";
		chemin2 = "../../data/Images/pokepedia/"+poke.getPokemon(id_adversaire).getName() + ".png";

		
        ImageIcon image1 = new ImageIcon(chemin1);
        ImageIcon image2 = new ImageIcon(chemin2);

        // Créer les JLabels pour chaque image
        JLabel label1 = new JLabel(image1);
        JLabel label2 = new JLabel(image2);

        // Créer les boutons

        JButton button1 = new JButton(att.getattaque(poke.getPokemon(id_pokemon).getAttack()).getName());
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	PokeListe poke = null;
        		
        		try {
        			poke = new PokeListe();
        			
        		} catch (Exception a) {

        			a.printStackTrace();
        		}

                
                combat.combattotal(poke.getPokemon(id_pokemon), poke.getPokemon(id_adversaire),poke.getPokemon(id_pokemon).getAttaqueID(),poke.getPokemon(id_adversaire).getAttaqueID());
            }
        });
        JButton button2 = new JButton(att.getattaque(poke.getPokemon(id_pokemon).getAttaqueID2()).getName());
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
PokeListe poke = null;
        		
        		try {
        			poke = new PokeListe();
        			
        		} catch (Exception a) {

        			a.printStackTrace();
        		}

                
                combat.combattotal(poke.getPokemon(id_pokemon), poke.getPokemon(id_adversaire),poke.getPokemon(id_pokemon).getAttaqueID2(),poke.getPokemon(id_adversaire).getAttaqueID());
            }
        });
        JButton button3 = new JButton(att.getattaque(poke.getPokemon(id_pokemon).getAttaqueID3()).getName());
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
PokeListe poke = null;
        		
        		try {
        			poke = new PokeListe();
        			
        		} catch (Exception a) {

        			a.printStackTrace();
        		}

                
                combat.combattotal(poke.getPokemon(id_pokemon), poke.getPokemon(id_adversaire),poke.getPokemon(id_pokemon).getAttaqueID3(),poke.getPokemon(id_adversaire).getAttaqueID());
            }
        });
        JButton button4 = new JButton(att.getattaque(poke.getPokemon(id_pokemon).getAttaqueID4()).getName());
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
PokeListe poke = null;
        		
        		try {
        			poke = new PokeListe();
        			
        		} catch (Exception a) {

        			a.printStackTrace();
        		}

                
                combat.combattotal(poke.getPokemon(id_pokemon), poke.getPokemon(id_adversaire),poke.getPokemon(id_pokemon).getAttaqueID4(),poke.getPokemon(id_adversaire).getAttaqueID());
            }
        });
        JButton fuiteButton = new JButton("Fuite");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le boutonf a été cliqué !");
            }
        });

        // Créer un conteneur pour chaque paire d'image et de boutons
        JPanel imagePanel1 = new JPanel();
        imagePanel1.setLayout(new BoxLayout(imagePanel1, BoxLayout.PAGE_AXIS));
        imagePanel1.add(label1);
        imagePanel1.add(button1);
        imagePanel1.add(button2);

        JPanel imagePanel2 = new JPanel();
        imagePanel2.setLayout(new BoxLayout(imagePanel2, BoxLayout.PAGE_AXIS));
        imagePanel2.add(label2);
        imagePanel2.add(button3);
        imagePanel2.add(button4);

        // Créer un conteneur pour les boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(fuiteButton);

        // Créer un conteneur pour les deux panneaux d'images et les boutons
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(imagePanel1);
        mainPanel.add(imagePanel2);
        mainPanel.add(buttonPanel);

        // Créer la fenêtre et ajouter le conteneur principal
        JFrame frame = new JFrame();
        frame.add(mainPanel);

        // Configurer la fenêtre
        frame.setTitle("Interface");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
		JLabel labelNom = new JLabel("<html>     "+pokemon_inventaire+"<br><br>    " + id_pokemon +"</html>");
		infoPokemon.add(labelNom);
		JLabel labelNom2 = new JLabel("<html>"+adversaire+"<br><br>" + id_adversaire +"</html>");
		infoPokemon.add(labelNom2);
		JLabel versus = new JLabel("versus");
		infoPokemon.add(versus);
		infoPokemon.add(labelNom2);
		fen.add(infoPokemon);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
