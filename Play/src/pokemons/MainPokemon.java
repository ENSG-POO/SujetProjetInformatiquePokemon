package pokemons;

public class MainPokemon {

	public static void main(String[] args) {
		Pokemon dialga = new Pokemon("Dialga", 180, "Glace");
		Pokemon arceus = new Pokemon("Arceus", 200, "Feu");
		Pokemon geratina = new Pokemon("Geratina", 130, "Eau");
		
		
		System.out.println(dialga);
		System.out.println(arceus);
		System.out.println(geratina);
		System.out.println(geratina.pokemonAttributes());


	}

}
