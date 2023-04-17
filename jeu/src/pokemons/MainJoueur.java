package pokemons;

import java.util.ArrayList;

public class MainJoueur {

	public static void main(String[] args) {
		ArrayList<Pokemon> lst = new ArrayList<Pokemon>();
		
		lst.add(new Pokemon("Arceus", "Glace", 200, 30, 50, 40));
		lst.add(new Pokemon("Pikapika", "Electrique", 500, 56, 70, 50));
		lst.add(new Pokemon("Dialga", "Eau", 180, 45, 70, 54));

		Joueur j1 = new Joueur("Joanna", 3, lst);
		
		System.out.println(j1);
		
	}

}
