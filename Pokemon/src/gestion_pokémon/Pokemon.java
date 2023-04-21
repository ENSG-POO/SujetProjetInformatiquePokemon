package gestion_pokémon;

import java.util.Scanner;

import déroulé_jeu.Coordinate;

import java.util.Random;

public class Pokemon implements coefficients,Dico_types {
	public String name ;
	public String type1;
	public String type2;
	public double HPMax;
	public double HP;
	public double attack;
	public double speed;
	public Boolean legendary;
	public String etat;
	public Coordinate coord;

	public Pokemon (String name, String type1, String type2, double HP, double attack, double speed, Boolean legendary) {
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.HP = HP;
		this.HPMax = HP;
		this.attack = attack/2;
		this.speed = speed;
		this.legendary = legendary;
		this.etat =  "sauvage";
		Coordinate coord = new Coordinate (-1, -1);
		this.coord = coord;
	}


	public Pokemon (String name, String type1, String type2, double HP, double attack, double speed, Boolean legendary, int CoordX, int CoordY) {
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.HP = HP;
		this.HPMax = HP;
		this.attack = attack/2;
		this.speed = speed;
		this.legendary = legendary;
		this.etat =  "sauvage";
		Coordinate coord = new Coordinate (CoordX, CoordY);
		this.coord = coord;
	}


	@Override
	public String toString () {
		
		if (!(this.type2.equals(""))){
			return this.name + " de types:" + this.type1 + " | "+ this.type2;
		}
		else {return this.name + " de type: " + this.type1;}
	
	}
	
	public void Deviens_poss () {
		this.etat="possédé";
		Coordinate coord = new Coordinate (-1, -1);
		this.coord = coord;
	}
	

	
	public void Deviens_utilisable () {
		this.etat="utilisable";
	}
	
	
	//Calcul les dégats d'un pokemon sur l'autre.
	public double Degat (Pokemon defenseur, boolean Sauvage) {
		
		double degat = 0;
		int d = 0;
		
		if (!Sauvage) {
			Scanner scann= new Scanner(System.in);    
			System.out.print("entrer 0 : attaque neutre | entrer 1 : attaque de type " + this.type1 +".");  
			d = scann.nextInt();
			while (!(d >= 0 && d <=1)) {
		    	System.out.println("Choix invalide. Veuillez réessayer.");
		    	scann= new Scanner(System.in);    
				System.out.print("entrer 0 : attaque neutre | entrer 1 : attaque de type " + this.type1+".");  
				d = scann.nextInt();
			}
		}
		
		else {
			Random r = new Random();
			d = r.nextInt(2);}
		
		if (d==0) {degat = this.attack;System.out.println(this.name + " utilise une attaque de type normal sur " + defenseur.name+".");}
		
		if (d==1) {
			System.out.println(this.name + " utilise une attaque de type " + this.type1 + " sur " + defenseur.name+".");
			degat = this.attack*Coeff[TypeInt.get(this.type1)][TypeInt.get(defenseur.type1)];
			if (defenseur.type2!="") {degat *= this.attack*Coeff[TypeInt.get(this.type1)][TypeInt.get(defenseur.type2)];}
				
			if ((this.type1.equals(defenseur.type1)||(this.type1.equals(defenseur.type2)))) {degat *= 1.5;}
			}
			if (degat/this.attack!=1) {System.out.println("Dégats mutlipliés par " + degat/this.attack);}
		return degat;
	}


	public String getNom() {
		return this.name;
	}

}
