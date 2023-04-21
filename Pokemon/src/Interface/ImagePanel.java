package Interface;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends  JPanel{

		
		private Image mapImage;
		
		public ImagePanel(){
			try {
				mapImage=ImageIO.read( new File("../battle_screen_background.jpg"));
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (mapImage !=null) {
				g.drawImage(mapImage, 0, 0, this);
			}
		}

	}

	

