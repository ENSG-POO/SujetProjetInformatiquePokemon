package Interface;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pilotejeu.PokemonSauvage;
/**
* Exemple de panneau contenant un bouton avec un évènement sur un autre panneau 
* qui est passé en paramètre dans le constructeur.
* 
*
*/

public class ControlPanel extends JPanel implements KeyListener{
	
	private static final long serialVersionUID = 1L;
	protected int x;
	protected int y;
	int n = 167;
	protected String[][] pokemonSauvage;
	PokemonSauvage ps = new PokemonSauvage();
	protected BufferedImage map;
	protected BufferedImage joueur;
	
	
	public ControlPanel() {
		
		JPanel panel = new JPanel(new BorderLayout()); 
		pokemonSauvage = ps.pokemon_s_with_coords();
		x=100;
		y=100;
		panel.setSize(1000, 800);
		
		
		
		// On construit 4 boutons pour se déplacer 
		JButton clic1 = new JButton("gauche");
		clic1.setBounds(50, 50, 20, 100);
		clic1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					x -= 10;
					repaint();
			}
		});
		this.add(clic1); 
		
		
		JButton clic2 = new JButton("haut");
		clic2.setBounds(50, 50, 20, 100);
		clic2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				y -= 10;
				repaint();
			}
		});
		this.add(clic2);
		
		
		JButton clic3= new JButton("bas");
		clic3.setBounds(50, 50, 20, 100);
		clic3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				y += 10;
				repaint();
			}
		});
		this.add(clic3);
		
		
		JButton clic4 = new JButton("droite");
		clic4.setBounds(50, 50, 20, 100);
		clic4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x += 10;
				repaint();
			}
		});
		this.add(clic4); 
		
		
		clic1.setVisible(true);
		clic2.setVisible(true);
		clic3.setVisible(true);
		clic4.setVisible(true);
		
		addKeyListener(this);
		setFocusable(true);
		
		// on importe les images qui vont nous servir de fond et de personnage 
			try {
				map=ImageIO.read(new File("../Map_background.jpg"));
			}
			catch(IOException e) {
				e.printStackTrace(); 
			}
			try {
				joueur=ImageIO.read(new File("../Bonhomme.jpg"));
			}
			catch(IOException e) {
				e.printStackTrace(); 
			}
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
		public void keyPressed(KeyEvent e) {
			// on permet au joueur de se déplacer avec les flèches du clavier également 
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				x -= 5;
				break;
			case KeyEvent.VK_RIGHT:
				x += 5;
				break;
			case KeyEvent.VK_UP:
				y -= 5;
				break;
			case KeyEvent.VK_DOWN:
				y += 5;
				break;
			}
			repaint();
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// Do nothing
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// Do nothing
		} 
		@Override
		public void paintComponent(Graphics g) {
			// méthode qui nous permet de créer tous nos objets(joueur, fond, pokemons)
			Graphics2D g2D = (Graphics2D) g;
			super.paintComponent(g);
			if(map != null) {
				g.drawImage(map,0,0,1000,800,this);
			}
			g2D.setPaint(Color.red);
			if(map != null) {
				g.drawImage(joueur,x,y,20,20,this);
			}
			//g.fillRect(x, y, 12, 12);
			Color darkBlue = new Color(0, 0, 128);
			g2D.setColor(darkBlue);
			ArrayList<Point> points = new ArrayList<Point>(); 
			for(int i=1; i<167; i++) {
				if(distance(x, y, Integer.parseInt(pokemonSauvage[i][11])*18 + 100,Integer.parseInt(pokemonSauvage[i][12])*18 + 100) < 20) {
					g.fillOval(Integer.parseInt(pokemonSauvage[i][11])*18 + 100, Integer.parseInt(pokemonSauvage[i][12])*18 + 100 , 10, 10);
					JLabel nom = new JLabel(pokemonSauvage[i][1]);
					
					setVisible(true);
					
					points.add(new Point(Integer.parseInt(pokemonSauvage[i][11])*18 + 100, Integer.parseInt(pokemonSauvage[i][12])*18 + 100));
				}
			}
			
		    
		    
		    
			for (Point pt : points) {
				if (distance(x, y, pt.x, pt.y)<2) {
					JButton combatbtn = new JButton("Combatre");
					combatbtn.setBounds(10, 10, 20, 100);
					combatbtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println(" A L'ATTAQUE !");
						}
					});
					combatbtn.setVisible(true);
				}
			} 
			revalidate();
			repaint();
		}
		public static double distance(double x1, double y1, double x2, double y2) {
			double xDiff = x2 - x1;
			double yDiff = y2 - y1;
			return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
		}
	}



