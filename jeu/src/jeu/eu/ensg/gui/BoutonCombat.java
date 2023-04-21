package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jeu.eu.ensg.Attaque;
import jeu.eu.ensg.Pokemon;



public class BoutonCombat extends JPanel{
		
	public BoutonCombat(JFrame window) {
			
		this.setSize(1000, 200);
			
		// On construit un bouton
		JButton fuite = new JButton("Fuir");
		fuite.setBounds(50, 50, 20, 100);
		this.add(fuite);  
		fuite.setVisible(true);
	
		// On ajoute un évènement sur le bouton
		fuite.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                window.dispose();
	            }
	        });
		
		// On construit un bouton
		JButton attaque = new JButton("Attaque STAB");
		attaque.setBounds(50, 50, 20, 100);
		this.add(attaque);  
		attaque.setVisible(true);
		
		attaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	assault(Attaque atk,Combat.getPJ(),Pokemon def);
            }
        });

		
		// On construit un bouton
		JButton attaque1 = new JButton("Attaque de base");
		attaque1.setBounds(50, 50, 20, 100);
		this.add(attaque1);  
		attaque1.setVisible(true);
		
		// On construit un bouton
		JButton change = new JButton("Changer de pokémon");
		change.setBounds(50, 50, 20, 100);
		this.add(change);  
		change.setVisible(true);
					
	}
		
}

