package pokemons;

public class TestPokedex {

	public static void main(String[] args) {
		String filename = "C:/Users/gosse/Documents/GitHub/Correia_Gosse_Liu/data/pokemon_first_gen.csv";
		String filecoord = "C:/Users/gosse/Documents/GitHub/Correia_Gosse_Liu/data/pokemon_coordinates.csv";
		//Pokedex pokedex = new Pokedex(filename);
		PokedexS pokedexS = new PokedexS(filecoord, filename);
		//System.out.println(pokedex);
		System.out.println(pokedexS);
		
		// sysout + ctrl esp
	}

}
