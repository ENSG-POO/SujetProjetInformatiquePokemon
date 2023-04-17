package jeu.eu.ensg;

import java.util.ArrayList;

public class Trainer {
	
	private Coordonnee position;
	private ArrayList<Pokemon> equipe;
	
	public Trainer(Coordonnee position, ArrayList<Pokemon> équipe) {
		super();
		this.position = position;
		this.equipe = équipe;
	}
	
	public void translater(double dx, double dy) {
		this.position.translate(dx, dy);
	}
	
	public int nbEquipe() {
		return equipe.size();
	}
	
	public boolean testEquipeKo() {
		return equipe.isEmpty();
	}
	

}
