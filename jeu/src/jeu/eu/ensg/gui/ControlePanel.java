package jeu.eu.ensg.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Exemple de panneau contenant un bouton avec un évènement sur un autre panneau 
 * qui est passé en paramètre dans le constructeur.
 * 
 *
 */
public class ControlePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public ControlePanel(CartePanel cartePanel) {
		
		this.setSize(1000, 200);
		
		// On construit un bouton
		JButton clic = new JButton("Clic ici");
		clic.setBounds(50, 50, 20, 100);
		this.add(clic);  
		clic.setVisible(true);
		
		// On ajoute un évènement sur le bouton
		clic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cartePanel.ajoutMessage("Ici, hello !");
				JFrame fen = new JFrame();
		        fen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				fen.setSize(1200, 800);
				

				// just a JPanel extension, add to any swing/awt container
				final CartePanel mapPanel = new CartePanel(); 
				fen.add(BorderLayout.CENTER, mapPanel);


				fen.setLayout(new BorderLayout());
				
				fen.add(BorderLayout.CENTER, new ImageCombat());
				
				BarreDeVie barre = new BarreDeVie(100, 25);
				barre.setPreferredSize(new Dimension(200, 20));
				
				
				fen.add(BorderLayout.EAST, new ListePok());

				fen.add(BorderLayout.SOUTH, new BoutonCombat(fen));

				

				fen.setLocationRelativeTo(null);
				fen.setResizable(false);
				fen.setTitle("fenetre de combat");
				
				fen.setVisible(true); 
			 
			}
		});

	}
	
}
