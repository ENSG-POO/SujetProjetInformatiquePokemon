package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import jeu.eu.ensg.Carte;
import jeu.eu.ensg.Coordonnee;
import jeu.eu.ensg.Dresseur;
import jeu.eu.ensg.Localisation;
import jeu.eu.ensg.Pokemon;

/**
 * Exemple de panneau contenant un espace où on peut dessiner.
 * 
 *
 */
public class CartePanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private Image fond;
	private Carte carte;
	private List<Localisation> pokemons_proches;
	private Dresseur dresseur;

	/**
	 * Constructeur.
	 * 
	 * @throws Exception
	 */
	public CartePanel() throws Exception {
		ImageIcon ii = new ImageIcon("../../data/Images/fond.jpg");
		this.fond = ii.getImage(); // on recupere l'Image de l'icon
		this.carte = new Carte();
		this.addMouseListener(this);
		this.dresseur = new Dresseur("moi");
		//this.fiche = new FichePanel();
	}

	public CartePanel(Carte carte) throws Exception {
		ImageIcon ii = new ImageIcon("../../data/Images/fond.jpg");
		this.fond = ii.getImage(); // on recupere l'Image de l'icon
		this.carte = carte;
		this.addMouseListener(this);
	}

	/**
	 * Méthodes de dessin appelée après le constructeur ou quand on appelle la
	 * méthode repaint
	 * 
	 * @throws Exception
	 */

	public void affiche_pokemons(Graphics2D g2D) throws Exception {
		List<Localisation> localisations = this.carte.getPokemons();
		String chemin;
		for (Localisation loc : localisations) {
			/*g2D.setPaint(Color.red);
			g2D.fillOval(loc.getPosition().getX(), loc.getPosition().getY(), 10, 10);*/
			chemin = "../../data/Images/pokepedia/"+loc.getNom() + ".png";
			Image image = new ImageIcon(chemin).getImage();
			g2D.drawImage(image, loc.getPosition().getX(), loc.getPosition().getY(), 30, 30, getFocusCycleRootAncestor());
			
		}
	}

	public void mouseClicked(MouseEvent e){
		int x = e.getX(); // obtention des coordonnées de l'évènement
		int y = e.getY();
		Coordonnee clic = new Coordonnee(x, y);
		/*List<Pokemon> inventaire = new ArrayList<Pokemon>();
		Pokemon p1 = new Pokemon(1,"Bulbasaur","Plante","Poison",318,45,49,49,65,65,45,1,"legendaire",3);
		Pokemon p2 = new Pokemon(2,"Ivysaur","Plante","Poison",405,60,62,63,80,80,60,1,"legendaire",1);
		inventaire.add(p1);
		inventaire.add(p2);
		Dresseur dresseur = new Dresseur("moi", clic, inventaire);*/
		Coordonnee c = new Coordonnee(x, y);
		this.dresseur.setCoord(c);
		dresseur.getNomsPokemons();
		List<Localisation> proches = dresseur.PokemonsProches(carte);
		this.pokemons_proches = proches;
		System.out.println(proches);
		System.out.println(this);
		int taille = proches.size();
		String[] pok = new String[taille+1];
		pok[0] = "";
		for (int i = 0; i < taille; i++) {
			pok[i+1] = proches.get(i).getNom();
		}
		MenuDeroulant menu = new MenuDeroulant(pok, dresseur);

	}

	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;

		Image fond = this.fond;
		g2D.drawImage(fond, 0, 0, 1600, 800, getFocusCycleRootAncestor()); // on affiche le background

		try {
			affiche_pokemons(g2D);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * if (!this.message.equals("")) { g2D.setColor(Color.RED); g2D.setFont(new
		 * Font("TimesRoman", Font.PLAIN, 36)); g.drawString(message, 250, 50); }
		 */
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "CartePanel [fond=" + fond + ", carte=" + carte + ", pokemons_proches=" + pokemons_proches + "]";
	}

}
