package pack1;

import gestion_jeu.Joueur;

public class Combat {
	
	public PokeDomestique pokeD;
	public PokeSauvage pokeS;
	
	public Combat (PokeDomestique pokeD, PokeSauvage pokeS) {
		this.pokeD= pokeD;
		this.pokeS = pokeS; 
	}
	
	public double savePVD () {
		double pvD = this.pokeD.p1.HP;
		return pvD;
	}
	
	public double savePVS () {
		double pvS = this.pokeS.p1.HP;
		return pvS;
	}
	
	public void changerpokeD(PokeDomestique new_pokeD) {
		this.pokeD = new_pokeD;
	}

}
