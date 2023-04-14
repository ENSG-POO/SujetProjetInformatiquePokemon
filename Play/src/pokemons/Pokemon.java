package pokemons;
//import java.util.List;

public class Pokemon {
	private String name;
	private int pv;
	private String type;
	//private List<Attaques> attaques;
	
	public Pokemon(String name, int pv, String type) { //List<Attaques> attaques
		this.name = name;
		this.pv = pv;
		this.type = type;
		//this.attaques = attaques;
	}
	
	public String toString() {
		return name + ": " + pv + "PV";
	}

}
