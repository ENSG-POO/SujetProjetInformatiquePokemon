package jeu.eu.ensg;

import java.util.ArrayList;

public class Trainer {
	
	private Coordinates position; // position du dresseur
	private ArrayList<Pokemon> equipe; // équipe de Pokémon du dresseur
	
	// Constructeur de la classe Trainer
	public Trainer(Coordinates position, ArrayList<Pokemon> équipe) {
		super();
		this.position = position;
		this.equipe = équipe;
	}
	
	// Méthode pour déplacer le dresseur
	public void translater(double dx, double dy) {
		this.position.translate(dx, dy);
	}
	
	// Méthode pour retourner le nombre de Pokémon dans l'équipe du dresseur
	public int nbEquipe() {
		return equipe.size();
	}
	
	// Méthode pour tester si l'équipe du dresseur est KO (vide)
	public boolean testEquipeKo() {
		return equipe.isEmpty();
	}
	
	// Méthode pour retourner une liste de Pokémon sauvages se trouvant à proximité du dresseur
	public ArrayList<Pokemon> listePokemonsProximite(ArrayList<Pokemon> listePokemonSauvages, int rayon) {
		ArrayList<Pokemon> listePokemonsProximite = new ArrayList<Pokemon>(); // initialisation d'une nouvelle liste de Pokémon
		for (int i =0 ; i< listePokemonSauvages.size(); i++) { // pour chaque Pokémon sauvage dans la liste des Pokémon sauvages
				if(this.getPosition().isNear(listePokemonSauvages.get(i).getPosition(), rayon)) { // si le Pokémon sauvage est à proximité du dresseur
					listePokemonsProximite.add(listePokemonSauvages.get(i)); // on ajoute le Pokémon à la liste des Pokémon à proximité du dresseur
				}
		}
		return listePokemonsProximite; // on retourne la liste des Pokémon à proximité du dresseur
	}

	// Getter pour la position du dresseur
	public Coordinates getPosition() {
		return this.position;
	}

	// Setter pour la position du dresseur
	public void setPosition(Coordinates position) {
		this.position = position;
	}

	// Getter pour l'équipe de Pokémon du dresseur
	public ArrayList<Pokemon> getEquipe() {
		return this.equipe;
	}

	// Setter pour l'équipe de Pokémon du dresseur
	public void setEquipe(ArrayList<Pokemon> equipe) {
		this.equipe = equipe;
	}

}