package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CartePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String message = "";
	private Random random = new Random();


	public CartePanel() {
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		ImageIcon mapIcon = new ImageIcon("../images/carte_pokemon.jpg");
		Image mapImage = mapIcon.getImage();
		g.drawImage(mapImage, 0, 0, this);

		Graphics2D g2D = (Graphics2D) g;

		g2D.setPaint(Color.blue);
		for (int i = 0; i < 998; i++) {
			int x = random.nextInt(mapIcon.getIconWidth() - 10);
			int y = random.nextInt(mapIcon.getIconHeight() - 10);
			g.fillOval(x, y, 10, 10);
		}

		if (!this.message.equals("")) {
			g2D.setColor(Color.RED);
			g2D.setFont(new Font("TimesRoman", Font.PLAIN, 36));
			g.drawString(message, 250, 50);
		}
	}

	public void ajoutMessage(String message) {
		this.message = message;
		this.repaint();
	}

}
