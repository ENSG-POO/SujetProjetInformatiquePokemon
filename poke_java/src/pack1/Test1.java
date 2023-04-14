package pack1;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		
		Dresseur d = new Dresseur("sacha", null, null);
		PokeSauvage s = new PokeSauvage("naame", "type1", 100, 100, 52, 14, 7, 3, 10, -1, true, null);
		List<PokeSauvage> listPokeS = new ArrayList<>();
		 listPokeS.add(s);
		
		 Jeu j = new Jeu(listPokeS);
		 j.afficherPoke(d);

	}

}
