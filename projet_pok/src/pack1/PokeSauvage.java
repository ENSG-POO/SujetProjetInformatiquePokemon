package pack1;

public class PokeSauvage  {
	
	public PokeCharacter p1;
	
	public PokeSauvage (String name) {
		ListePokeChara l1 = new ListePokeChara();
		PokeCharacter p1 = l1.GetPoke(name);
		this.p1 = p1;

    }
	public PokeCharacter toPokeCharacter() {
		return p1;
		
	}
	
	@Override
	public String toString() {
		return this.p1.name;
	}
	
	public double getPV () {
		return this.p1.HP;
	}
	
	public String getType1() {
		return this.p1.type1;
	}

}
