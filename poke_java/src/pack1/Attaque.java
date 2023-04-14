package pack1;

public class Attaque {
	
	public Pokemon pokeAt; 
	public Pokemon pokeDef;
	public Dresseur joueur;
	
	public Attaque (Pokemon pokeAt, Pokemon pokeDef, Dresseur joueur) {
		this.pokeAt = pokeAt; 
		this.pokeDef = pokeDef;
		this.joueur = joueur; 
	}
	
	public double savePVA () {
		double pvA = this.pokeAt.HP;
		return pvA;
	}
	
	public double savePVD () {
		double pvD = this.pokeDef.HP;
		return pvD;
	}
	
	public void attackN () {
		this.pokeDef.HP = this.pokeDef.HP-5;
	
	}
	
	public void attackS() {
		double k = 0;
		this.pokeDef.HP = this.pokeDef.HP-10*k;
	}
	
	

}
