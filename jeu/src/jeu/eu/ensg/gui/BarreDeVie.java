package jeu.eu.ensg.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class BarreDeVie extends JPanel {
	
	public BarreDeVie() {
		
		final JSplitPane split;
		//On crée deux conteneurs de couleurs différentes
	    JPanel pan = new JPanel();
	    pan.setSize(1000, 600);
	    pan.setBackground(Color.black);
	
	    JPanel pan2 = new JPanel();
	    pan2.setSize(1000, 600);
	    pan2.setBackground(Color.white);
	
	    //On construit notre séparateur
	    split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan, pan2);
	    split.setDividerSize(1);
	    
	    this.add(split);
	    split.setVisible(true);
	}

}
