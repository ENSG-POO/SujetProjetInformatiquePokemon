package Type.CODES_ELIOT;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Exemple de panneau contenant un bouton avec un évènement sur un autre panneau 
 * qui est passé en paramètre dans le constructeur.
 * 
 *
 */

 
public class ControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	 protected int x;
	 protected int y;
	 
	public ControlPanel() {
		
		x=400;
		y=400;
		
		// On construit 4 boutons
		JButton clic1 = new JButton("droite");
		clic1.setBounds(50, 50, 20, 100);
		clic1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cartePanel.ajoutMessage("on va à droite !");
				x += 1;
				repaint();
			}
		});
		this.add(clic1); 
		
		
		JButton clic2 = new JButton("gauche");
		clic2.setBounds(50, 50, 20, 100);
		clic2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cartePanel.ajoutMessage("on va à gauche !");
				x -= 1;
				repaint();
			}
		});
		this.add(clic2);
		
		
		JButton clic3= new JButton("haut");
		clic3.setBounds(50, 50, 20, 100);
		clic3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cartePanel.ajoutMessage("on va en haut !");
				y += 1;
				repaint();
			}
		});
		this.add(clic3);
		
		
		JButton clic4 = new JButton("bas");
		clic4.setBounds(50, 50, 20, 100);
		clic4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	cartePanel.ajoutMessage("on va en bas !");
				y -= 1;
				repaint();
			}
		});
		this.add(clic4);	
		
		
		 
		clic1.setVisible(true);
		clic2.setVisible(true);
		clic3.setVisible(true);
		clic4.setVisible(true);
	}	
	
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
	    super.paintComponent(g);
        g2D.setPaint(Color.red);
        g.drawOval(x, y, 20, 20);
        
    } 

		
		// On ajoute un évènement sur chaque bouton
			/*clic1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//cartePanel.ajoutMessage("on va à droite !");
					x += 1;
					repaint();
				}
			});
			
			/*clic2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//cartePanel.ajoutMessage("on va à gauche !");
					x -= 1;
					repaint();
				}
			});
			
			clic3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//cartePanel.ajoutMessage("on va en haut !");
					y += 1;
					repaint();
				}
			});
			
			clic4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				//	cartePanel.ajoutMessage("on va en bas !");
					y -= 1;
					repaint();
				}
			});*/

	
	public ControlPanel(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
}


//private JPanel barmessage() {
	//JPanel barmessage = new JPanel( new FlowLayout(FlowLayout.LEFT));
	
	//JLabel point = new JLabel("Vous êtes le point rouge");
//	point.setPreferredSize(new Dimension(100,50));
	//barmessage.add(point);
	//return barmessage;

//}

