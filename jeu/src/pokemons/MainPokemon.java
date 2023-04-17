package pokemons;

public class MainPokemon {

	public static void main(String[] args) {
		/*
		 Pokemon dialga = new Pokemon("Dialga", "Grass", 180);
		 Pokemon arceus = new Pokemon("Arceus", "Electric", 200);
		 Pokemon geratina = new Pokemon("Geratina", "Fairy", 130);
		
		System.out.println(dialga);
		System.out.println(arceus);
		System.out.println(geratina);
	*/
		
		Type type1 = new Type("Electric");
		System.out.println(type1);
		Type type2 = new Type("Ground");
		System.out.println(type2);
		
		
		Pokemon pikachu = new Pokemon("Pikachu", type1, 200);
		Pokemon bulbi = new Pokemon("Bulbizard", type2, 200);


		System.out.println(bulbi.checkFaiblesse(pikachu));
		System.out.println(pikachu.checkFaiblesse(bulbi));
		
		System.out.println(bulbi.checkResistance(pikachu));
		System.out.println(pikachu.checkResistance(bulbi));
		
		

	}

}
