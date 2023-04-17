package jeu.eu.ensg.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Exemple de panneau contenant un bouton avec un �v�nement sur un autre panneau 
 * qui est pass� en param�tre dans le constructeur.
 * 
 *
 */
public class ControlePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	//rajout du mot final pour faire foncitonner le programme
	public ControlePanel(final CartePanel cartePanel) {
		
		this.setSize(1000, 200);
		
		// On construit un bouton
		JButton clic = new JButton("Clic ici");
		clic.setBounds(50, 50, 20, 100);
		this.add(clic);  
		clic.setVisible(true);
		
		// On ajoute un �v�nement sur le bouton
		clic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartePanel.ajoutMessage("Ici, hello !");
			}
		});

	}
	
}
