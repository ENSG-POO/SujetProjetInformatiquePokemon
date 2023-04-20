package pack1;

public class PokeCharacter extends Pokemon {
	public int id;
	public String type1; 
	public double HP; 

	
	public PokeCharacter (int id, String name, coord position, String type1, double HP) {
		super(name,position);
		this.id = id;
		this.type1 = type1; 
		this.HP = HP; 
	}
	
	public String toString() {
        return "Pokemon " + this.name + "ses coordonnées sont " + this.position +".Description"+ this.id+","+this.type1+","+this.HP;
}
}
