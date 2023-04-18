package jeu.eu.ensg;


public class Test {
	public static void main(String[] args) throws Exception {
		Inventaire.charger_csv_pokemons();
		Inventaire.charger_csv_coords();
		Carte map = new Carte();
		System.out.println(map);
	}

}
