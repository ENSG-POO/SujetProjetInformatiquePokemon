package pilotejeu;

import java.util.Scanner;

public class pokemon extends tableau {
	
	String[] mon_pokemon = getPokemon();
	protected double HP = Double.parseDouble(mon_pokemon[5]);
	protected double vitesse = Double.parseDouble(mon_pokemon[10]);
	protected String type1 = mon_pokemon[2];
	protected String type2 = mon_pokemon[3];
	protected double Att = Double.parseDouble(mon_pokemon[6]);
	protected double Def = Double.parseDouble(mon_pokemon[7]);
	

	public pokemon(String nom ) {
		super (nom);
		
	}
	
	public pokemon(String nom, double HP, double vitesse,String type1, String type2, double Att, double Def ) {
		super (nom);
		this.HP = HP;
		this.vitesse = vitesse;
		this.type1 = type1;
		this.type2 = type2;
		this.Att = Att;
		this.Def = Def;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getType1() {
		return this.type1;
	}
	
	public String getType2() {
		if (mon_pokemon[3].isEmpty()) {
			return "null";
		}
		else {
		return this.type2;}
	}
	
	public double getVitesse() {
		return this.vitesse;
	}
	
	public double getHP() {
		return this.HP;
	}
	
	public double getAtt() {
		return this.Att;
	}
	
	public double getDef() {
		return this.Def;
	}
	
	public String toString() {
		return ("Ton pokemon est  "+ this.nom +"; Type1 "+ this.type1 +"; Type2 "+ getType2() + "; Vitesse " + this.vitesse + "; HP "+ this.HP + "; Attaque " + this.Att + "; Défense " + this.Def );
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

	    System.out.print("Le pokémon est : ");
	    String chaine = scanner.nextLine();

	    System.out.println("Les caractéristiques du pokémon sont : " + chaine);
		
	    pokemon mon_pokemon = new pokemon(chaine);
	    
	    System.out.println(mon_pokemon.toString());
			
			
		
	    
	    
	    
		  }
	
	}	

		
	

