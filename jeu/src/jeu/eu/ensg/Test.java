package jeu.eu.ensg;

public class Test {
	public static void main(String[] args) throws Exception {
		Inventaire.charger_csv_pokemons();
		
		Carte map = new Carte();
		System.out.println(map);
	}

}
