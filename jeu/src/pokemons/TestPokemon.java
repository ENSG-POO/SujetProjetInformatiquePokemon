package pokemons;

public class TestPokemon {

	public static void main(String[] args) {
		Pokemon pika = new Pokemon("Pikachu", new Type("Fire"), 10, 10, 5,5);
		Pokemon bulbi = new Pokemon("Bulbi", new Type("Water"), 10, 10, 5,4);
		
		//System.out.println("Index pika // attaquant " + pika.type.aff.association(pika.type.nomT));
		//System.out.println("Index bulbi // defenseur " + pika.type.aff.association(bulbi.type.nomT));
		
		Attaque fight = new Attaque("Elementaire", new Type("Grass"));
		pika.attaquer(bulbi, fight);
		System.out.println("Point de vie restant: "+ bulbi.pv);
		
	}

}
