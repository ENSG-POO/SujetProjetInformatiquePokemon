package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Interface.ImagePanel;
import Combat.Rencontre;
import pilotejeu.pokemon;

public class Combat extends JFrame{
	
		
		public static void main(String[] args) {
			JFrame fr = new JFrame();
			fr.setSize(1000,600);
			fr.setLayout(new BorderLayout());
			
			ImagePanel image = new ImagePanel();  
			fr.add(BorderLayout.CENTER, image);
			
			fr.setLocationRelativeTo(null);
			fr.setResizable(false);
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fr.setTitle("Combat");
			
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
			
		
			
			 
		 }
			
	}



