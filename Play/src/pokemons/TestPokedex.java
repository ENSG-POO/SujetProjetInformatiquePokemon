package pokemons;

public class TestPokedex {

	public static void main(String[] args) {
		String filename = "C:/Users/gosse/Documents/GitHub/Correia_Gosse_Liu/Play/src/pokemons/pokemon_first_gen.csv";
		String filecoord = "C:/Users/gosse/Documents/GitHub/Correia_Gosse_Liu/Play/src/pokemons/pokemon_coordinates.csv";
		//Pokedex pokedex = new Pokedex(filename);
		PokedexS pokedexS = new PokedexS(filecoord);
		//System.out.println(pokedex);
		System.out.println(pokedexS);
	}

}
