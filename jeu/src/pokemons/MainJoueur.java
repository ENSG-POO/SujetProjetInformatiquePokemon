package pokemons;

import java.util.ArrayList;

public class MainJoueur {

	public static void main(String[] args) {
		ArrayList<Pokemon> lst = new ArrayList<Pokemon>();
		
		lst.add(new Pokemon("Arceus", new Type("Fairy"), 200, 30, 50, 40));
		lst.add(new Pokemon("Pikapika", new Type("Electric"), 500, 56, 70, 50));
		lst.add(new Pokemon("Dialga", new Type("Fire"), 180, 45, 70, 54));

		Joueur j1 = new Joueur("Joanna", 3, lst);
		
		System.out.println(j1);
		
	}

}
