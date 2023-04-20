package pack1;

import gestion_jeu.Joueur;

public class PokeDomestique extends Pokemon {
	
	public Joueur joueur;
	public PokeCharacter p1;
	
	public PokeDomestique(String name, Joueur joueur) {
		super (name);
		this.joueur = joueur;
		ListePokeChara l1 = new ListePokeChara();
		PokeCharacter p1 = l1.GetPoke(name);
		this.p1 = p1;
	}
	
	@Override
	public String toString() {
		return this.name+" est ton pokémon, il est de type "+this.p1.type1+" il a "+this.p1.HP;
	}

}
