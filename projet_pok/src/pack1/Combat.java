package pack1;

public class Combat {
	
	// la classe Combat permet de construire un combat entre un pokémon Domestique du joueur 
	// et un pokémon sauvage qu'il croise sur la carte
	
	public PokeDomestique pokeD;
	public PokeSauvage pokeS;
	
	public Combat (PokeDomestique pokeD, PokeSauvage pokeS) {
		this.pokeD= pokeD;
		this.pokeS = pokeS; 
	}
	
	public double savePVD () { //méthode qui permet de garder dans une variable les points de vie: en effet, lors d'une attaque
							//il est plus facile de modifier cette variable pour voir l'avancement du combat, 
							// plutot que de modifier directement les PV du pokémons avec un mutateur 
		double pvD = this.pokeD.p1.HP;
		return pvD;
	}
	
	public double savePVS () {
		double pvS = this.pokeS.p1.HP;
		return pvS;
	}
	
	public void changerpokeD(PokeDomestique new_pokeD) { // méthode pour changer de pokémons lors d'un combat 
		this.pokeD = new_pokeD;
	}

}
