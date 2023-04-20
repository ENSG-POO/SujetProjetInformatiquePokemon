package pack1;

public class PokeSauvage {
	
	public PokeCharacter p1;
	
	public PokeSauvage (String name) {
		ListePokeChara l1 = new ListePokeChara();
		PokeCharacter p1 = l1.GetPoke(name);
		this.p1 = p1;

    }
	
	@Override
	public String toString() {
		return this.p1.name+" est un pokémon sauvage, il est de type "+this.p1.type1+" il a "+this.p1.HP +"point de vie";
	}
	

}
