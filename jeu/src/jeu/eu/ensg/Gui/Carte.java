package jeu.eu.ensg.Gui;

import jeu.eu.ensg.GestionPokemon.*;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Carte extends JPanel {


	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point clickPoint = null;
	public List<Point2D.Double> bluePoints = new ArrayList<Point2D.Double>();
	public List<Point2D.Double> orangePoints = new ArrayList<Point2D.Double>();	    
	public List<Grille> Listpoke = Grille.SauvageList ();
	private Image backgroundImage;
	private BufferedImage image;
	public String csvFilePath = "D:\\\\DeBockRosierMiras\\\\data\\\\pokemon_first_gen.csv";
	public List<Pokemon> pokemonList = TablePokemon.readPokemonCSV(csvFilePath);

	public Carte(List<Point2D.Double> bluePoints,List<Point2D.Double> orangePoints) {//Construit un panel dans une frame en dessinnant ce que donne paintComponement()
		setPreferredSize(new Dimension(4000, 1000));
		loadBackgroudImage();
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {// Boucle attendant chaque clic
				clickPoint = e.getPoint();
				repaint();// lance paintComponent
			}
		});
		this.bluePoints=bluePoints;
		this.orangePoints=orangePoints;
	}
	
	protected void paintComponent(Graphics g) { // crée les dessins au démarrage et à chaque clic
		super.paintComponent(g);		
		if (backgroundImage != null) {// Mets l'image de fond
			g.drawImage(backgroundImage, 0, 0, null);	            
		}
		g.setColor(Color.RED);// dessine les pokemons déja révélés
		for (Point2D.Double pointblue : bluePoints) {
			g.fillOval((int) pointblue.x - 5, (int) pointblue.y - 5, 10, 10);
		}
		g.setColor(Color.ORANGE);// dessine les pokemons révélés et capturés
		for (Point2D.Double pointorange : orangePoints) {
			g.fillOval((int) pointorange.x - 5, (int) pointorange.y - 5, 10, 10);
		}
		LoadSpriteBlue(g);
		LoadSpriteOrange(g);
		if (clickPoint != null) {// à chaque clic
			Graphics2D g2d = (Graphics2D) g;
			AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f); // Opacité de 25%
			g2d.setComposite(alpha);
			g2d.setColor(Color.BLUE); 
			g2d.fillOval(clickPoint.x -50, clickPoint.y -50, 100, 100);//dessine le cercle de détection autour du clic
			alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
			g2d.setComposite(alpha);
			for (int i=0;i<Listpoke.size();i++) {// boucle qui détecte les pokemons dans le rayon de détection
				Point2D.Double point = new Point2D.Double(Listpoke.get(i).getX(),Listpoke.get(i).getY());
				double distance = point.distance(clickPoint);
				if ((distance <= 50)&&(bluePoints.contains(point)==false)) {
					bluePoints.add(point);
				}
			}
			g.setColor(Color.RED);// dessine les nouveaux points révélés
			for (Point2D.Double point : bluePoints) {
				g.fillOval((int) point.x - 5, (int) point.y - 5, 10, 10);
			}
			g.setColor(Color.ORANGE);// dessine les nouvelles captures
			for (Point2D.Double point : orangePoints) {
				g.fillOval((int) point.x - 5, (int) point.y - 5, 10, 10);
			}
		}
		LoadSpriteBlue(g);
		LoadSpriteOrange(g);	
	}	        	
	    
	public Pokemon lance_combat (List<Pokemon> equipe) {// détermine si le clic est suffisamment proche d'un pokemon et que le pokemon n'est pas déja capturé pour le renvoyer
		if (clickPoint != null) {
			for (Point2D.Double point : bluePoints) {
				double d_combat = point.distance(clickPoint);
				if (d_combat <= 5) {// détermine si le clic est dans le rond du pokemon
					for (Grille pokemon : Listpoke) {
						Point2D.Double coordpoke = new Point2D.Double(pokemon.getX(), pokemon.getY());
						if (coordpoke.distance(clickPoint) <= 5) {// cherche le nom du pokemon associé au coordonnées
							String pokemonName = pokemon.getNom();
							for (Pokemon poke : equipe) {// vérification de sa présence dans équipe
								if (poke.getName().equals(pokemonName)) {
									return null;
								}
							}
							return TablePokemon.getPokemonByName(pokemonName, pokemonList);
						}
					}
				}
			}
		}
		return null;
	}	

	    
	public void Vérifie_capture (List<Point2D.Double> bluePoints,List<Pokemon> equipe) {  // détermine si le pokémon est capturé
		for (Point2D.Double point : bluePoints) {
			for (Grille pokemon : Listpoke) {// parcourt les points pour déterminer le pokémon
				Point2D.Double coordpoke=new Point2D.Double(pokemon.getX(),pokemon.getY());
				if (coordpoke.distance(point) <= 1) {
					String pokemonName = pokemon.getNom();
					for (Pokemon poke : equipe) {
						if ((poke.getName().equals(pokemonName)==true)&&(orangePoints.contains(point)==false)) {// vérifie que le pokémon soit dans l'équipe
							orangePoints.add(point);
						}
					}
				}
			}
		}
	}
	
	public void LoadSpriteBlue (Graphics g) {  // chargement des images 
		for (Point2D.Double point : bluePoints) {
			for (Grille pokemon : Listpoke) {
				Point2D.Double coordpoke=new Point2D.Double(pokemon.getX(),pokemon.getY());
				Pokemon poke=TablePokemon.getPokemonByName(pokemon.getNom(), pokemonList);
				if ((coordpoke.distance(point)<=1)) {
					try {
						image = ImageIO.read(new File("D:\\\\DeBockRosierMiras\\\\data\\\\Sprite\\"+poke.getId()+".png"));
					} catch (IOException e) {
						System.out.println("Erreur lors du chargement de l'image de fond : " + e.getMessage());
					}
					g.drawImage(image,(int) point.x-15, (int) point.y-20,30,30, null);
				}
			}
		}
	}
	
	public void LoadSpriteOrange (Graphics g) {  // chargement des images si capturé
		for (Point2D.Double point : orangePoints) {
			for (Grille pokemon : Listpoke) {
				Point2D.Double coordpoke=new Point2D.Double(pokemon.getX(),pokemon.getY());
				Pokemon poke=TablePokemon.getPokemonByName(pokemon.getNom(), pokemonList);
				if ((coordpoke.distance(point)<=1)) {
					try {
						image = ImageIO.read(new File("D:\\\\DeBockRosierMiras\\\\data\\\\Sprite_NB\\"+poke.getId()+".png"));
					} catch (IOException e) {
						System.out.println("Erreur lors du chargement de l'image de fond : " + e.getMessage());
					}
					g.drawImage(image,(int) point.x-15, (int) point.y-20,30,30, null);
				}
			}
		}
	}
	
	public void loadBackgroudImage() {// charge l'image de fond 
		try {
			backgroundImage = ImageIO.read(new File("D:\\\\DeBockRosierMiras\\\\data\\\\parc-safari_test_4000_1000.png"));
	        	} catch (IOException e) {
	        		System.out.println("Erreur lors du chargement de l'image de fond : " + e.getMessage());
	        }	
	    }	
	
	
	public List<Grille> getListPoke() {
		return this.Listpoke;
	    	}
		}