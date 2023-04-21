package pilotejeu;

import java.util.Scanner;


public class pokemon extends tableau {
	//Classe qui permet d'acceder aux pokemon ainsi qu'à leurs attributs
	
	
	String[] mon_pokemon = getPokemon();
	private double HP ;
	private double vitesse ;
	private String type1 ;
	private String type2;
	private double Att ;
	private double Def ;
	
	

	public pokemon(String nom ) {
		super (nom);
		this.HP= statHP(Double.parseDouble(mon_pokemon[5]));
		this.vitesse = statVit(Double.parseDouble(mon_pokemon[10]));
		this.type1 = mon_pokemon[2];
		this.type2 = mon_pokemon[3];
		this.Att = statAtt(Double.parseDouble(mon_pokemon[6]));
		this.Def = statDef(Double.parseDouble(mon_pokemon[7]));
		
	}
	
	public pokemon(String nom, double HP, double vitesse,String type1, String type2, double Att, double Def ) {
		super (nom);
		this.HP= statHP(Double.parseDouble(mon_pokemon[5]));
		this.vitesse = statVit(vitesse);
		this.type1 = type1;
		this.type2 = type2;
		this.Att = statAtt(Att);
		this.Def = statDef(Def);
	}
	
	
	
	public double statAtt(double attaque) {
		return (((2*attaque)*50)/100)+5;
	}

	public double statDef(double defense) {
		return (((2*defense)*50)/100)+5;
	}

	public double statHP(double HP) {
		return (((2*HP)*50)/100)+50+10;
	}

	public double statVit(double vitesse) {
		return (((2*vitesse)*50)/100)+5;
	}
// Ces fonctions retournent les statistiques des pokemon avec en argumet leur statistique de base	
	
	
	
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
	
	public void setHP(double HP) {
		this.HP=HP;
		
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

		
	

