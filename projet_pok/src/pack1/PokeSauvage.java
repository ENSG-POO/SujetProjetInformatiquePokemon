package pack1;

public class PokeSauvage extends Pokemon {
	
	// Un pokemon sauvage est créé en fonction de la liste des pokemons (ListePokeChara qui est une liste créée à partir
	//des données CSV et de leurs caractéréstiques: on entre seulement le nom dans le constructeur qui va chercher les caractéristiques 
	// dans la liste. Un Pokemon Sauvage se différencie d'un Pokémon Domestique avec sa position sur la carte
	
	public PokeCharacter p1;
	public String name;
	
	public PokeSauvage (String name) {
		super(name);
		ListePokeChara l1 = new ListePokeChara();
		PokeCharacter p1 = l1.GetPoke(name);
		this.p1 = p1;

    }
	public PokeCharacter toPokeCharacter() { //méthode importante pour l'utilisation de la classe Attaque: en effet, les attributs de 
										// cette classe sont un pokémon qui attaque et un autre qui défend: il fallait donc un type 
										// qui ne fasse pas la différence entre un pokémon domestique et un sauvage, afin
										// d'alterner les attaques
		return p1;
		
	}
	
	@Override
	public String toString() { // on redéfinit la méthode pour qu'elle affiche seulement le nom pour faciliter l'interface graphique:
								// lorsque l'on sélectionne un item dans un JComboBox
		return this.p1.name;
	}
	
	public double getPV () { //accesseur pour récupérer les points de vie
		return this.p1.HP;
	}
	
	public String getType1() { //accesseur pour récupérer le type 
		return this.p1.type1;
	}

}
