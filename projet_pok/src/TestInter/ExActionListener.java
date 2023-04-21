package TestInter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ExActionListener {
	
	    private int variableAModifier = 0;

	    public static void main(String[] args) {
	        // Création de la fenêtre et des composants
	        JFrame frame = new JFrame("Exemple ActionListener");
	        JButton button = new JButton("Cliquez ici");

	        // Création de l'instance de la classe Main
	        Main mainInstance = new Main();

	        // Ajout de l'ActionListener au bouton
	        button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Modification de la variable en utilisant l'instance de Mai
	                
	            }
	        });

	        // Ajout du bouton à la fenêtre
	        frame.add(button);

	        // Affichage de la fenêtre
	        frame.pack();
	        frame.setVisible(true);
	    }
}
