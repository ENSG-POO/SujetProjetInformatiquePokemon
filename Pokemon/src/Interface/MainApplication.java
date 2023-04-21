package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Combat.Rencontre;
import Interface.ControlPanel;
import pilotejeu.pokemon;

/**
* Lancement de l'application graphique
* 
* @author Marie-Dominique
*
*/

public class MainApplication extends JPanel{
	
	
	/**
	* Méthode main pour lancer le programme.
	* @param args
	*/
	
	public static void main (String[] args) {
	// Look and Feel dépend de l'OS.
	try {
	String os = System.getProperty("os.name").toLowerCase();
	// For windows os
	if (os.contains("windows")) {
	UIManager.setLookAndFeel(new NimbusLookAndFeel());
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
	
	
	 JFrame fr = new JFrame();
		fr.setSize(1000,600);
		fr.setLayout(new BorderLayout());
		
		ImagePanel image = new ImagePanel();  
		fr.add(BorderLayout.CENTER, image);
		
		fr.setLocationRelativeTo(null);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setTitle("Image de fond");
		
		JButton bouton1 = new JButton("Fuite");
		bouton1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  System.out.println("Vous prenez la fuite");
		    	  fr.dispose();
		      }
		      });
	
		JButton bouton2 = new JButton("Attaque");
		bouton2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	fr.dispose();
		    	  
		    	pokemon Magneton = new pokemon("Magneton");
			    pokemon Nidoking = new pokemon("Nidoking");
			    System.out.println("type de Nidoking   1:" + Nidoking.getType1() + " 2 : " + Nidoking.getType2() );
			    System.out.println("type de Magneton   1:" + Magneton.getType1() + " 2 : " + Magneton.getType2() );
			    System.out.print(Rencontre.AttaqueFinal(Nidoking,Magneton));
		    	
		      }
		      });
		bouton2.setPreferredSize(new Dimension(50, 80));
		bouton1.setPreferredSize(new Dimension(50, 50));

		fr.add(BorderLayout.SOUTH , bouton2);
		fr.add(BorderLayout.NORTH , bouton1);
		
		
		fr.setVisible(true);
		
		
		
		
	final JFrame fen = new JFrame();
	fen.setSize(1000,800);
	fen.setLayout(new BorderLayout());
	ControlPanel controlpanel = new ControlPanel();
	fen.add(controlpanel);
	fen.setLocationRelativeTo(null);
	fen.setResizable(false);
	fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fen.setTitle("Jeu Pokémon");
	JButton bouton = new JButton("Si tu rencontres un pokemon clique!");
    //Définition de l'action du bouton
    bouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
    	  System.out.println("Vous rencontrez un Magnéton!");
    	  fen.dispose();
      }
    });

    fen.add(BorderLayout.NORTH , bouton);
    bouton.setPreferredSize(new Dimension(100, 100));
    
    fen.setVisible(true);
	
   

	
	
	
    
	}
	}



