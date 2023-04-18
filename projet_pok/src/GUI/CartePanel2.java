package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
 
public class CartePanel2 extends JPanel {
 
	public Image mapImage = Toolkit.getDefaultToolkit().getImage("../images/carte_pokemon.jpg");
	BorderLayout borderLayout1 = new BorderLayout();
	public int rows;
	public int cols;
    private Point point;

 
   public CartePanel2(int rows, int cols) {
	   JPanel fond = new JPanel();	   
	   fond.setLayout(new GridLayout(rows, cols));
	   
	   /*
	   mapImage = Toolkit.getDefaultToolkit().getImage("../images/carte_pokemon.jpg");
	   int imageWidth = mapImage.getWidth(this);
	   int imageHeight = mapImage.getHeight(this);
	   this.setSize (imageWidth,imageHeight);
	   */
	   
	   for (int i = 0; i < rows*cols; i++) {
		    JButton button = new JButton("Zone " + i); 
		    button.setOpaque(false);
		    button.setContentAreaFilled(false);
		    button.setBorderPainted(false);
		    fond.add(button);
		    
		    button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.out.println(button.getText() + " cliquée !");
	            }
	        });
	   }
	   
	   this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	   this.add(fond); 
	   
   }
   /*
   public void paintComponent(Graphics g) {
     super.paintComponent(g);
     g.drawImage (mapImage, 0, 0, null);
     repaint();
   }*/
 
}
