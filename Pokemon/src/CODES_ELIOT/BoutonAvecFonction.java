package Type.CODES_ELIOT;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Combat.Stats;
import Type.Acier;

public class BoutonAvecFonction extends JFrame{
	
	public JPanel getBoutonPanel() {
		
		setTitle("Panneau avec boutons");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(300, 200);

	    JPanel panel = new JPanel();

	    JButton bouton = new JButton("Attaque typé");
	    bouton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        // Mettez ici le code de la fonction que vous voulez déclencher
	        System.out.println(Acier.AttaquePokemonDtype("Magneti" , Stats.statAtt(45) ,"Salameche", "Feu", Stats.statHP(50) , Stats.statDef(20)));
	      }
	    });

	    panel.add(bouton);
	    getContentPane().add(panel);
	  
	
	JButton bouton2 = new JButton("Attaque neutre");
    bouton2.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        // Mettez ici le code de la fonction que vous voulez déclencher
	        System.out.println(Acier.AttaquePokemonDNeutre( "Magneti" , Stats.statAtt(45) ,"Salameche", "Feu", Stats.statHP(50) , Stats.statDef(20)));
	      }
	    });

	    panel.add(bouton2);
	    getContentPane().add(panel);
	    return panel;
	    		}

	  public static void main(String[] args) {
	    BoutonAvecFonction fenetre = new BoutonAvecFonction();
	    fenetre.setVisible(true);
	  }
	}


