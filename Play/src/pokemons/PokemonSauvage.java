package pokemons;

public class PokemonSauvage extends Pokemon {
	public Coordonnee coord;
	
	public PokemonSauvage(String nom, String type, Coordonnee coord) {
		super(nom, type);
		this.coord = coord;
	}
	
	public PokemonSauvage(String nom, String type, int pv, int attack, int defense, int speed, Coordonnee coord) {
		super(nom, type, pv, attack, defense, speed);
		this.coord = coord;
		
	}

}
