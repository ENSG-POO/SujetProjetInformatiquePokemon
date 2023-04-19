package GestionPokemon;
import java.util.*;
import java.io.*;

public class Pokemon{
	private int id;
	private String nom;
	private Type type1;
	private Type type2;
	private int hpMax;
	private int hp;
	private int atk;
	private int def;
	private int spAtk;
	private int spDef;
	private int spe;
	private double X;
	private double Y;
	private Capacite c1;
	private Capacite c2;
	private Capacite c3;
	private Capacite c4;
	
	// Builder
	public Pokemon(int id,String nom, Type t1, Type t2, int hpm, int a, int d, int spa, int spd, int spe) {
		this.id = id;
		this.nom = nom;
		this.type1 = t1;
		this.type2 = t2;
		this.hpMax = hpm+60;
		this.hp = hpm+60;
		this.atk = a;
		this.def = d;
		this.spAtk = spa;
		this.spDef = spd;
		this.spe = spe;
		this.X = 0;
		this.Y = 0;
	}
	
	// Builder
	public Pokemon(int id,String nom, Type t1, Type t2, int hpm, int a, int d, int spa, int spd, int spe, double x, double y, Capacite c1, Capacite c2, Capacite c3, Capacite c4) {
		this.id = id;
		this.nom = nom;
		this.type1 = t1;
		this.type2 = t2;
		this.hpMax = hpm+60;
		this.hp = hpm+60;
		this.atk = a;
		this.def = d;
		this.spAtk = spa;
		this.spDef = spd;
		this.spe = spe;
		this.X = x;
		this.Y = y;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
		this.c4 = c4;
	}
	
	
	// Builder
	public Pokemon(int id)  throws IOException{
		List<Pokemon> pokemonList = CsvParser.pokedexParse();
		this.id = id;
		this.nom = pokemonList.get(id-1).getNom();
		this.type1 = pokemonList.get(id-1).getType1();
		this.type2 = pokemonList.get(id-1).getType2();
		this.hpMax = pokemonList.get(id-1).getHpMax();
		this.hp = pokemonList.get(id-1).getHpMax();
		this.atk = pokemonList.get(id-1).getAtk();
		this.def = pokemonList.get(id-1).getDef();
		this.spAtk = pokemonList.get(id-1).getSpAtk();
		this.spDef = pokemonList.get(id-1).getSpDef();
		this.spe = pokemonList.get(id-1).getSpe();
		this.X = 0;
		this.Y = 0;
	}
	
	// Builder
	public Pokemon(int id, double x, double y)  throws IOException{
		List<Pokemon> pokemonList = CsvParser.pokedexParse();
		this.id = id;
		this.nom = pokemonList.get(id-1).getNom();
		this.type1 = pokemonList.get(id-1).getType1();
		this.type2 = pokemonList.get(id-1).getType2();
		this.hpMax = pokemonList.get(id-1).getHpMax();
		this.hp = pokemonList.get(id-1).getHpMax();
		this.atk = pokemonList.get(id-1).getAtk();
		this.def = pokemonList.get(id-1).getDef();
		this.spAtk = pokemonList.get(id-1).getSpAtk();
		this.spDef = pokemonList.get(id-1).getSpDef();
		this.spe = pokemonList.get(id-1).getSpe();
		this.X = x;
		this.Y = y;
	}
	
	// Définition d'une méthode renvoyant les dégâts reçus par le pokemon en prenant une attaque d'un pokemon donné utilisant une capacité donnée 
	public int Degats(Pokemon ennemi, Capacite capa) {
		
		// Changement des statistiques pour des calculs cohérents (celles de base donnent des résultats très déséquilibrés)
		int Atk = 2*ennemi.getAtk()*50/100+5;
		int spAtk = 2*ennemi.getSpAtk()*50/100+5;
		int Def = 2*this.getDef()*50/100+5;
		int spDef = 2*this.getSpDef()*50/100+5;
		
		// Prise en compte du STAB (si l'attaque a le type du pokemon qui la lance)
		double stab = 1;
		if (capa.getType().getClass() == ennemi.getType1().getClass() || capa.getType().getClass() == ennemi.getType2().getClass()) {
			stab = 1.5;
		}
		
		// Distinction attaques physiques et attaques spéciales, qui n'utilisent pas les mêmes statistique dans le calcul
		if (capa.getCategorie() == "Physical") {
			return (int) Math.floor(((((50*0.4+2)*Atk*capa.getPuissance()/Def)/50)+2)*stab*this.getEffectiveness(capa.getType()));
		}
		else {
			return (int) Math.floor(((((50*0.4+2)*spAtk*capa.getPuissance()/spDef)/50)+2)*stab*this.getEffectiveness(capa.getType()));
		}
	}
	
	
	// Méthode renvoyant un entier correspondant à l'efficacité de l'attaque donnée sur le pokemon
    public double getEffectiveness(Type type) {
    	if (this.type2 == null) {
    		return this.type1.getEffectiveness(type);
    	}
    	else {
    		return this.type1.getEffectiveness(type)*this.type2.getEffectiveness(type);
    	}
    }
    
    
    // Getters et Setters
    
    public int getid() {
		return id;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpAtk() {
		return spAtk;
	}

	public void setSpAtk(int spAtk) {
		this.spAtk = spAtk;
	}

	public int getSpDef() {
		return spDef;
	}

	public void setSpDef(int spDef) {
		this.spDef = spDef;
	}

	public int getSpe() {
		return spe;
	}

	public void setSpe(int spe) {
		this.spe = spe;
	}

	public String getNom() {
		return nom;
	}

	public Type getType1() {
		return type1;
	}

	public Type getType2() {
		return type2;
	}

	public int getHpMax() {
		return hpMax;
	}
	
	public double getX() {
		return X;
	}
	
	public double getY() {
		return Y;
	}

	public Capacite getC1() {
		return c1;
	}

	public void setC1(Capacite c1) {
		this.c1 = c1;
	}

	public Capacite getC2() {
		return c2;
	}

	public void setC2(Capacite c2) {
		this.c2 = c2;
	}

	public Capacite getC3() {
		return c3;
	}

	public void setC3(Capacite c3) {
		this.c3 = c3;
	}

	public Capacite getC4() {
		return c4;
	}

	public void setC4(Capacite c4) {
		this.c4 = c4;
	}
}
