package pack1;

public class PokeCharacter extends Pokemon {
	public int id;
	public String type1; 
	public double HP; 

	
	//PokeCharacter est un type de pokémon: cette classe sert à stocker les données des CSV, mais aussi de confondre les pokémons 
	// domestique et sauvage, ce qui est utile pour la classe Attaque
	
	public PokeCharacter (int id, String name, coord position, String type1, double HP) {
		super(name,position);
		this.id = id;
		this.type1 = type1; 
		this.HP = HP; 
	}
	
	public String toString() { // on redéfinit la méthode toString pour afficher seulement le nom afin 
								// de simplifier l'interface graphique
        return this.name ;
}
	public String getType1() {
		return this.type1;
	}
}
