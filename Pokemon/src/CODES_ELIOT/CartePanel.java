package Type.CODES_ELIOT;
import java.awt.event.*;  
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Exemple de panneau contenant un espace où on peut dessiner.
 * 
 *
 */
public class CartePanel extends ControlPanel {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructeur.
	 */
	
	  public CartePanel( int x, int y ) {
		  super(x , y);  
	  }
	  
	  public CartePanel() {
	  }  

	/**
	 * Méthodes de dessin appelée après le constructeur
	 * ou quand on appelle la méthode repaint
	 */
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		
		
		// Crée une couleur verte foncée avec les valeurs RGB correspondantes
		Color vertFonce = new Color(0, 100, 0);

		// Utilise la couleur verte foncée pour dessiner un rectangle
		g.setColor(vertFonce);
	
		
		// On dessine 10 points verts
		// on doit recuper dans un tableau toutes les coord des pokemons a mettre sur la map 
				
			//	int min = 0;
				//int max1 = 30;
				//int max2 = 10;
				//int range1 = (max1 -min) +1;
				//int range2 = (max2 -min) +1;
				
				//for(int i = 0; i<100; i++) {
					//int r1 = (int)(Math.random()*range1);
					//int r2 = (int)(Math.random()*range2);
					//g2D.setColor(vertFonce);
					//g.fillOval(r1 *18 + 100  , r2 *50 + 100, 15, 15); 
				//}
				
				//for (int i = 0; i < n; i++) {
						//g2D.setColor(vertFonce);
						//g.fillOval(tableau[i][0]*15 + 200  , tableau[i][1] *30 + 200, 10, 10); 
				//}
			
		
			//int X = super.x;
			//int Y =(int)super.joueur.getY();
			//g2D.setPaint(Color.red);
			//g.fillOval(super.x , super.y, 10, 10);
	

		
		if (!this.message.equals("")) {
			g2D.setColor(Color.RED);
			g2D.setFont(new Font("Pokemon Classic", Font.PLAIN, 36)); 
			g.drawString(message, 250, 50);
		}
	}
	
	
	
	
	private String message = "";
	
	public void ajoutMessage(String message) {
		this.message = message;
		this.repaint();
	}
	
}
