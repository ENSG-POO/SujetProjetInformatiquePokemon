package GUI;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainApplication extends JFrame{
	
	public MainApplication() {
		JFrame frame = new JFrame(); 
		ImageIcon mapIcon = new ImageIcon("../images/carte_pokemon.jpg");
		final CartePanel2 panel = new CartePanel2(5,5);
    	
		frame.add(new JLabel(mapIcon));
		frame.pack();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Jeu Pokémon");
		//frame.setSize(600, 600);
        frame.setVisible(true);
        
    	frame.add(panel);
		
	}
	
	public static void main(String[] args) {
		new MainApplication();
		
	}

}
