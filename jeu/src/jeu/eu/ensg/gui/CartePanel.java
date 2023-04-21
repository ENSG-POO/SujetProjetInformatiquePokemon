package jeu.eu.ensg.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import jeu.eu.ensg.Carte;
import jeu.eu.ensg.Coordonnee;
import jeu.eu.ensg.Dresseur;
import jeu.eu.ensg.Localisation;

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
			chemin = "../../data/Images/pokepedia/" + loc.getNom() + ".png";
			Image image = new ImageIcon(chemin).getImage();
			g2D.drawImage(image, loc.getPosition().getX(), loc.getPosition().getY(), 30, 30,
					getFocusCycleRootAncestor());

		}
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX(); // obtention des coordonnées de l'évènement
		int y = e.getY();
		Coordonnee clic = new Coordonnee(x, y);

		Coordonnee c = new Coordonnee(x, y);
		this.dresseur.setCoord(c);
		dresseur.getNomsPokemons();
		List<Localisation> proches = dresseur.PokemonsProches(carte);
		this.pokemons_proches = proches;
		int taille = proches.size();
		String[] pok = new String[taille + 1];
		pok[0] = "";
		for (int i = 0; i < taille; i++) {
			pok[i + 1] = proches.get(i).getNom();
		}
		MenuDeroulant menu = new MenuDeroulant(pok, dresseur);
		
		//Combat_temporaire combat = new Combat_temporaire(menu.getPokemon_joueur(), menu.getPokemon_sauvage(), menu.getId_pokemon_joueur(), menu.getId_pokemon_sauvage());

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
