package Pokemon;
import java.util.ArrayList;
import java.util.List;


public class Joueur {
	private String name;
	private int nbPokemon;
	private List<Pokemon> lstPokemons;
	
	public Joueur(String name, int nbPokemon){
		this.name = name;
		this.nbPokemon = nbPokemon;
		this.lstPokemons = new ArrayList<Pokemon>();
	}
	
	public Joueur(String name, int nbPokemon, List<Pokemon> lstPokemons){
		this.name = name;
		this.nbPokemon = nbPokemon;
		this.lstPokemons = lstPokemons;
	}
	
	public void addPokemon(Pokemon newPokemon) {
		lstPokemons.add(newPokemon);
	}

	public String toString() {
		String str = name + " possede " + nbPokemon + " pokemons:\n" + lstPokemons;
		return str;
	}
}
