package pokemons;

import java.util.ArrayList;

public class MainJoueur {

	public static void main(String[] args) {
		ArrayList<Pokemon> lst = new ArrayList<Pokemon>();
		
		lst.add(new Pokemon("Arceus", 200, "Glace"));
		lst.add(new Pokemon("Pikapika", 500, "Feu"));
		lst.add(new Pokemon("Dialga", 180, "Eau"));

		Joueur j1 = new Joueur("Joanna", 3, lst);
		
		System.out.println(j1);
		
	}

}
