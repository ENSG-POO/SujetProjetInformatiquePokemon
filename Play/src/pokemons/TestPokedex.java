package pokemons;

public class TestPokedex {

	public static void main(String[] args) {
		String filename = "C:/Users/gosse/Documents/GitHub/Correia_Gosse_Liu/Play/src/pokemons/pokemon_first_gen.csv";
		Pokedex pokedex = new Pokedex(filename);
		System.out.println(pokedex);
	}

}
