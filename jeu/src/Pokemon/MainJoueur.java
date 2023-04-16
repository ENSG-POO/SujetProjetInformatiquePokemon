package Pokemon;

import java.util.ArrayList;

public class MainJoueur {

	public static void main(String[] args) {
		ArrayList<Pokemon> lst = new ArrayList<Pokemon>();
		
		lst.add(new Pokemon("Arceus", new Type("Fairy"), 200));
		lst.add(new Pokemon("Pikapika", new Type("Electric"), 500));
		lst.add(new Pokemon("Dialga", new Type("Fire"),  180));

		Joueur j1 = new Joueur("Joanna", 3, lst);
		
		System.out.println(j1);
		
	}

}
