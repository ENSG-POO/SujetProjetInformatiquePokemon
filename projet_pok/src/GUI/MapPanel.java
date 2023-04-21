package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import pack1.ListePoke;
import pack1.Pokemon;
import pack1.coord;

public class MapPanel extends JPanel {

	private Point point; 			// Point sélectionné par l'utilisateur
    private JButton validButton; 	// Bouton pour valider la position
    private Image mapImage; 		// Image de la carte
	private ListePoke listePoke;	// Liste des Pokemons sur la carte
	public int mouseX; 				// Position en X de la souris
	public int mouseY; 				// Position en Y de la souris
	

    public MapPanel(ListePoke listePoke) {
        this.listePoke = listePoke;
        point = new Point(0,0);

    	
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int step = 5;
                if (keyCode == KeyEvent.VK_UP) {
                    point.y -= step;
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    point.y += step;
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    point.x -= step;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    point.x += step;
                }
                List<Pokemon> pokemonsProches2 = trouverPokemonProche(5, point.x, point.y);
                System.out.println("Les Pokemons les plus proches sont : ");
                for (Pokemon p : pokemonsProches2) {
                    System.out.println("- " + p.getName() + " à une distance de " + p.getDistance());
                }
                repaint();
            }
            
            public Point getPoint() {
                return point;
            }
        });
        
        
        

        validButton = new JButton("Valider la position");
        validButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (point != null) {
                    System.out.println("Position du point : x=" + point.x + ", y=" + point.y);
                    requestFocusInWindow();
                }
            }
        });
        
        try {
            mapImage = ImageIO.read(new File("../images/carte_pokemon.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel controlPanel = new JPanel();
        controlPanel.add(validButton);
        add(controlPanel, BorderLayout.NORTH);
       
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY(); 
                point = new Point(mouseX, mouseY);
                List<Pokemon> pokemonsProches = trouverPokemonProche(5, mouseX, mouseY);
                System.out.println("Les Pokemons les plus proches sont : ");
                for (Pokemon p : pokemonsProches) {
                    System.out.println("- " + p.getName() + " à une distance de " + p.getDistance());
                }
                repaint();
            } 
        });
        setFocusable(true);   
    }
    
    public ListePoke getListePoke() {
        return listePoke;
    }
    
    public List<Pokemon> trouverPokemonProche(int k, int x, int y) {
        List<Pokemon> pokemons = Arrays.asList(listePoke.ListePoke);
        for (Pokemon p : pokemons) {
            double distance = Math.sqrt(Math.pow(p.getPosition().getX() - x, 2) + Math.pow(p.getPosition().getY() - y, 2));
            p.setDistance(distance);
        }
        Collections.sort(pokemons, new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2) {
                return Double.compare(p1.getDistance(), p2.getDistance());
            }
        });        
        return pokemons.subList(0, k);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(mapImage, 0, 0, getWidth(), getHeight(), this);
        
        if (mapImage != null) {
            int imageWidth = mapImage.getWidth(this);
            int imageHeight = mapImage.getHeight(this);
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            
            int maxX = Math.max(0, imageWidth - panelWidth);
            int maxY = Math.max(0, imageHeight - panelHeight);
            
            int xOffset = (panelWidth - imageWidth) / 2;
            int yOffset = (panelHeight - imageHeight) / 2;            
            g.drawImage(mapImage, xOffset, yOffset, this);

            int borderWidth = 10;
            int borderX = xOffset - borderWidth;
            int borderY = yOffset - borderWidth;
            int borderWidth2 = imageWidth + 2 * borderWidth;
            int borderHeight = imageHeight + 2 * borderWidth;

            g.setColor(Color.BLACK);
            g.drawRect(borderX, borderY, borderWidth2, borderHeight);
            
            /*
            List<Pokemon> pokemonsProches = trouverPokemonProche(5, mouseX, mouseY);
            if (pokemonsProches != null) {
                for (Pokemon pokemon : pokemonsProches) {
                    coord coord = pokemon.getPosition();
                    g.setColor(Color.BLUE);
                    int pokemonX = (int) (coord.getX());
                    int pokemonY = (int) (coord.getY());
                    if (pokemonX < borderX) pokemonX = borderX;
                    if (pokemonY < borderY) pokemonY = borderY;
                    if (pokemonX > borderX + borderWidth2) pokemonX = borderX + borderWidth2;
                    if (pokemonY > borderY + borderHeight) pokemonY = borderY + borderHeight;
                    g.fillOval(pokemonX - 5, pokemonY - 5, 10, 10);
                }
            }*/
            
            List<Pokemon> pokemonsProches2 = trouverPokemonProche(5, point.x, point.y);
            if (pokemonsProches2 != null) {
                for (Pokemon pokemon : pokemonsProches2) {
                    coord coord = pokemon.getPosition();
                    g.setColor(Color.BLUE);
                    int pokemonX = (int) (coord.getX()) + xOffset;
                    int pokemonY = (int) (coord.getY()) + yOffset;
                    if (pokemonX < borderX) pokemonX = borderX;
                    if (pokemonY < borderY) pokemonY = borderY;
                    if (pokemonX > borderX + borderWidth2) pokemonX = borderX + borderWidth2;
                    if (pokemonY > borderY + borderHeight) pokemonY = borderY + borderHeight;
                    g.fillOval(pokemonX - 5, pokemonY - 5, 10, 10);
                    g.drawString(pokemon.getName(), pokemonX + 10, pokemonY - 10);
                }
            }
            
            if (point != null) {
            	int pointX = point.x + xOffset;
                int pointY = point.y + yOffset;
                if (pointX < borderX) pointX = borderX;
                if (pointY < borderY) pointY = borderY;
                if (pointX > borderX + borderWidth2) pointX = borderX + borderWidth2;
                if (pointY > borderY + borderHeight) pointY = borderY + borderHeight;
                g.setColor(Color.RED);
                g.fillOval(pointX - 5, pointY - 5, 10, 10);
            
            }
        }
    }
        
}
