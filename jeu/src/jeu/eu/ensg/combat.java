package jeu.eu.ensg;

public class combat {
	

	public static void round(pokemonprovisoire a, pokemonprovisoire b) {
		double degat ;
		degat = a.getAttaque().getDegat()* a.getAttaque().getType().faiblesse(b.getType());
		b.setPv(b.getPv()-degat);

	}
}
