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
	public PokeCharacter toPokeCharacter() {
		return p1;
	}
	
	@Override // on redéfinit la méthode pour qu'elle affiche seulement le nom, sinon mauvais affichage dans les boutons 
	public String toString() {
		return this.name;
	}
	
	public double getPVd() {
		return this.p1.HP;
	}
	
	public String getType() {
		return this.p1.type1;
	}
	
	}


