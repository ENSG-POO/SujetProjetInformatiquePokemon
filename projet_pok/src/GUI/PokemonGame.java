package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PokemonGame extends JFrame{
	
	public static void main(String[] args) {
		
		final JFrame fen = new JFrame();
		fen.setSize(1000,1000);
		
		final MapPanel mapPanel = new MapPanel();
		
		fen.add(BorderLayout.CENTER, mapPanel);
		
		fen.setLocationRelativeTo(null);
		fen.setResizable(false);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setTitle("Pokemon Game");
		fen.setVisible(true);
		
		new PokemonGame();

	}
	

}
