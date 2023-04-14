package pokemons;
public class Attaques {
	private String attaque_neutre;
	private int pv_attaque_neutre;
	private String attaque_type1;
	private int pv_attaque_type1;

	
	public Attaques(String attaque_neutre, int pv_attaque_neutre, String attaque_type1, int pv_attaque_type1) {
		this.attaque_neutre = attaque_neutre;
		this.pv_attaque_neutre = pv_attaque_neutre;
		this.attaque_type1 = attaque_type1;
		this.pv_attaque_type1 = pv_attaque_type1;
	}

}
