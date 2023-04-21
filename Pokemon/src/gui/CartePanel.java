package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Exemple de panneau contenant un espace où on peut dessiner.
 * 
 *
 */
		

	/**
	 * Méthodes de dessin appelée après le constructeur
	 * ou quand on appelle la méthode repaint
	 */	
	
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CartePanel extends JPanel implements KeyListener {
	 private static final int TAILLE_CASE = 13;
	    private static final int NB_CASES = 70;
	    private static final int NB_CASES_NOIRES = 999;
	    
	    
	    private boolean[][] cases;
	    private int posX, posY;
  
    
    
    /**
	 * Constructeur.
	 */
	    public CartePanel() {
	        cases = new boolean[NB_CASES][NB_CASES];
	      
	        posX = 35;
	        posY = 35;
	        addKeyListener(this);
	        setFocusable(true);
	    }
    /* Méthodes
     * 
     */
	   
	    
	    public void paint(Graphics g) {
	        super.paintComponent(g);	       
     		
	        for (int i = 0; i < NB_CASES; i++) {
	            for (int j = 0; j < NB_CASES; j++) {
	                if (cases[i][j]) {
	                    if (i == posX && j == posY) {
	                        g.setColor(Color.RED);
	                    } else {
	                        g.setColor(Color.BLACK);
	                    }
	                } else {
	                    g.setColor(Color.WHITE);
	                }
	                g.fillRect(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
	            }
	        }
	     // dessiner le texte
    		g.setColor(Color.BLACK);
    		g.setFont(new Font("Arial", Font.BOLD, 16));
    		
    		String text = "carte monde ";
    		int textWidth = g.getFontMetrics().stringWidth(text);
            int textX = 150;
            int textY = 950;
            g.drawString(text, textX, textY);
	       
	        // position du centre de soin
     		g.setColor(Color.RED); 
     		int x = 60* TAILLE_CASE;
     		int y = 60 *TAILLE_CASE ;
     		g.fillRect(x, y, TAILLE_CASE, TAILLE_CASE);
     		// dessin du joueur
	        g.setColor(Color.BLUE);
	        g.fillRect(posX * TAILLE_CASE, posY * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
	    
	    
	    if (!this.message.equals("")) {
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 18)); 
			g.drawString(message, 500, 950);
			
		}
	}
	
	
	private String message = " carte du monde" ;
	

	    
	    public Dimension getPreferredSize() {
	        return new Dimension(NB_CASES * TAILLE_CASE, NB_CASES * TAILLE_CASE);
	    }
	    public void keyPressed(KeyEvent e) {
	        int key = e.getKeyCode();
	        switch (key) {
	            case KeyEvent.VK_NUMPAD4:
	                if (posX > 0 && !cases[posX-1][posY]) {
	                    posX--;
	                    repaint();
	                }
	                break;
	            case KeyEvent.VK_NUMPAD6:
	                if (posX < NB_CASES - 1 && !cases[posX+1][posY]) {
	                    posX++;
	                    repaint();
	                }
	                break;
	            case KeyEvent.VK_NUMPAD8:
	                if (posY > 0 && !cases[posX][posY-1]) {
	                    posY--;
	                    repaint();
	                }
	                break;
	            case KeyEvent.VK_NUMPAD5:
	                if (posY < NB_CASES - 1 && !cases[posX][posY+1]) {
	                    posY++;
	                    repaint();
	                }
	                break;
	            default:
	                break;
	        }
	        if (cases[posX][posY]) {
	            System.out.println("Mode combat !");
	            // Lancer le mode combat
	        }
	    }
	    public void keyReleased(KeyEvent e) {}
	    
		public void ajoutMessage(String message) {
			this.message = message;
			this.repaint();	
		}
		public void ajoutMessage1(String message1) {
			this.message = message1;
			this.repaint();
	    }
}