package pack1;

import gestion_jeu.Joueur;

public class PokeDomestique extends Pokemon {
	
	// Un pokemon domestique est créé en fonction de la liste des pokemons (ListePokeChara qui est une liste créée à partir
	//des données CSV et de leurs caractéréstiques: on entre seulement le nom dans le constructeur qui va chercher les caractéristiques 
	// dans la liste. Un Pokemon Domestique se différencie d'un Pokémon Sauvage avec l'attribut joueur (dresseur)
	
	public Joueur joueur;
	public PokeCharacter p1;
	
	public PokeDomestique(String name, Joueur joueur) {
		super (name);
		this.joueur = joueur;
		ListePokeChara l1 = new ListePokeChara();
		PokeCharacter p1 = l1.GetPoke(name);
		this.p1 = p1;
	}
	
	public PokeCharacter toPokeCharacter() { //méthode importante pour l'utilisation de la classe attaque: en effet, les attributs de 
											// cette classe sont un pokémon qui attaque et un autre qui défend: il fallait donc un type 
											// qui ne fasse pas la différence entre un pokémon domestique et un sauvage, afin
											// d'alterner les attaques
		return p1;
	}
	
	@Override // on redéfinit la méthode pour qu'elle affiche seulement le nom pour faciliter l'interface graphique:
	 			// lorsque l'on sélectionne un item dans un JComboBox
	public String toString() {
		return this.name;
	}
	
	public double getPVd() { //accesseur pour récupérer les points de vie
		return this.p1.HP;
	}
	
	public String getType() {  //accesseur pour récupérer le type
		return this.p1.type1;
	}
	
	}


