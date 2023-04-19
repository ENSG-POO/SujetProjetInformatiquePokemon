package jeu.eu.ensg;

import java.util.ArrayList;

public class Trainer {
	
	private Coordinates position;
	private ArrayList<Pokemon> equipe;
	
	public Trainer(Coordinates position, ArrayList<Pokemon> équipe) {
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
	
	public ArrayList<Pokemon> listePokemonsProximite(ArrayList<Pokemon> listePokemonSauvages, int rayon) {
		ArrayList<Pokemon> listePokemonsProximite = new ArrayList<Pokemon>();
		for (int i =0 ; i< listePokemonSauvages.size(); i++) {
				if(this.getPosition().isNear(listePokemonSauvages.get(i).getPosition(), rayon)) {
					listePokemonsProximite.add(listePokemonSauvages.get(i));
				}
		}
		return listePokemonsProximite;
	}

	public Coordinates getPosition() {
		return this.position;
	}

	public void setPosition(Coordinates position) {
		this.position = position;
	}

	public ArrayList<Pokemon> getEquipe() {
		return this.equipe;
	}

	public void setEquipe(ArrayList<Pokemon> equipe) {
		this.equipe = equipe;
	}

}
