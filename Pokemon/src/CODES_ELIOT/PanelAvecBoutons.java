package Type.CODES_ELIOT;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelAvecBoutons  extends JFrame{
	
	
	public PanelAvecBoutons() {
	    setTitle("Panneau avec boutons");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(300, 200);

	    JPanel panel = new JPanel();

	    JButton bouton1 = new JButton("Attaquer");
	    JButton bouton2 = new JButton("Fuire");

	    panel.add(bouton1);
	    panel.add(bouton2);

	    getContentPane().add(panel);
	  }

	  public static void main(String[] args) {
	    PanelAvecBoutons fenetre = new PanelAvecBoutons();
	    fenetre.setVisible(true);
	  }
	}


