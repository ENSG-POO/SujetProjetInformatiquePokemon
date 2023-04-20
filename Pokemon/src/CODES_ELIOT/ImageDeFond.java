package Type.CODES_ELIOT;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageDeFond extends JFrame{
	
	public ImageDeFond() {
	    // Chargement de l'image
	    Image image = null;
	    try {
	      image = ImageIO.read(new File("C:/Users/alexa/git/EsteoulleCamboursBarriere/battle_screen_background.jpg"));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	    // Création de la JLabel contenant l'image
	    JLabel labelImage = new JLabel(new ImageIcon(image));
	    
	    // Ajout de la JLabel à l'arrière-plan du conteneur principal
	    this.getContentPane().setLayout(new BorderLayout());
	    this.getContentPane().add(labelImage, BorderLayout.CENTER);
	    
	    // Configuration de la JFrame
	    this.setSize(800, 600);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	  }
	  
	  public static void main(String[] args) {
	    new ImageDeFond();
	  }

}
