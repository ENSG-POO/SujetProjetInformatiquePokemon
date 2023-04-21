package pack1;

import java.util.ArrayList;

import gestion_jeu.Joueur;

//classe qui permet de générer une Attaque: les attributs sont un pokémon qui défend et 
// un qui attaque: ces deux pokémons sont de type PokeCharacter, car il faut un type qui confonde 
// pokémon domestique et pokémon sauvage afin d'alterner le pokémon qui attaque et celui qui défend dans les combats 

public class Attaque {
	
	public PokeCharacter pokeAt; 
	public PokeCharacter pokeDef;
	
	public Attaque (PokeCharacter pokeAt, PokeCharacter pokeDef) {
		this.pokeAt = pokeAt; 
		this.pokeDef = pokeDef;
	}
	
	public Attaque() { // constructeur utile lorsque l'on fait une attaque neutre: en effet, peut importe le type du pokémon
		 			// qui attaque, le dégat d'une attaque neutre est de -5 pv
		
	}
	
	public double attackN () { // une attaque neutre provoque 5 points de dégats, peu importe 
		 					// le type des pokémons qui combattent. Return les dégats de l'attaque 
		double cout = 5;
		return cout;
	
	}
	
	public double GetCoeff(int a, int b) {
		//fonction qui permet d'obtenir le coefficients multiplicateur des attaques spéciales en fonction des types
		// des pokémons qui attaquent et défendent
	 double[][] tab;
	        tab = new double[18][18];
	        for (int i = 0; i < tab.length; i++) {
	            for (int j = 0; j < tab[i].length; j++) {
	                tab[i][j] = 1;
	            }
	        }
	        tab[0][0] = 0.5 ;
	        tab[0][3] = 0.5 ;
	        tab[0][4] = 0.5 ;
	        tab[0][5] = 0.5 ;
	        tab[1][6] = 0.5 ;
	        tab[1][8] = 0.5 ;
	        tab[1][11] = 0.5 ;
	        tab[1][17] = 0.5 ;
	        tab[2][0] = 0.5 ;
	        tab[3][2] = 0.5 ;
	        tab[3][3] = 0.5 ;
	        tab[3][10] = 0.5 ;
	        tab[4][2] = 0.5 ;
	        tab[4][5] = 0.5 ;
	        tab[4][10] = 0.5 ;
	        tab[5][2] = 0.5 ;
	        tab[5][3] = 0.5 ;
	        tab[5][4] = 0.5 ;
	        tab[5][13] = 0.5 ;
	        tab[6][0] = 0.5 ;
	        tab[6][4] = 0.5 ;
	        tab[6][11] = 0.5 ;
	        tab[7][0] = 0.5 ;
	        tab[7][3] = 0.5 ;
	        tab[7][4] = 0.5 ;
	        tab[7][7] = 0.5 ;
	        tab[8][0] = 0.5 ;
	        tab[8][1] = 0.5 ;
	        tab[8][4] = 0.5 ;
	        tab[8][6] = 0.5 ;
	        tab[8][11] = 0.5 ;
	        tab[8][15] = 0.5 ;
	        tab[8][17] = 0.5 ;
	        tab[9][0] = 0.5 ;
	        tab[9][13] = 0.5 ;
	        tab[10][0] = 0.5 ;
	        tab[10][2] = 0.5 ;
	        tab[10][4] = 0.5 ;
	        tab[10][8] = 0.5 ;
	        tab[10][10] = 0.5 ;
	        tab[10][11] = 0.5 ;
	        tab[10][17] = 0.5 ;
	        tab[11][11] = 0.5 ;
	        tab[11][13] = 0.5 ;
	        tab[11][14] = 0.5 ;
	        tab[11][15] = 0.5 ;
	        tab[12][0] = 0.5 ;
	        tab[12][12] = 0.5 ;
	        tab[13][0] = 0.5 ;
	        tab[13][1] = 0.5 ;
	        tab[13][14] = 0.5 ;
	        tab[14][8] = 0.5 ;
	        tab[14][10] = 0.5 ;
	        tab[15][16] = 0.5 ;
	        tab[16][1] = 0.5 ;
	        tab[16][7] = 0.5 ;
	        tab[16][16] = 0.5 ;
	        tab[17][0] = 0.5 ;
	        tab[17][5] = 0.5 ;
	        tab[17][13] = 0.5 ;
	        
	        tab[0][6] = 2;
	        tab[0][7] = 2;
	        tab[0][13] = 2;
	        tab[1][0] = 2;
	        tab[1][7] = 2;
	        tab[1][9] = 2;
	        tab[1][13] = 2;
	        tab[1][16] = 2;
	        tab[2][2] = 2;
	        tab[3][4] = 2;
	        tab[3][13] = 2;
	        tab[3][14] = 2;
	        tab[4][3] = 2;
	        tab[4][17] = 2;
	        tab[5][0] = 2;
	        tab[5][7] = 2;
	        tab[5][8] = 2;
	        tab[5][10] = 2;
	        tab[6][1] = 2;
	        tab[6][2] = 2;
	        tab[6][16] = 2;
	        tab[7][2] = 2;
	        tab[7][10] = 2;
	        tab[7][14] = 2;
	        tab[7][17] = 2;
	        tab[8][10] = 2;
	        tab[8][12] = 2;
	        tab[8][16] = 2;
	        tab[10][3] = 2;
	        tab[10][12] = 2;
	        tab[10][13] = 2;
	        tab[11][6] = 2;
	        tab[11][10] = 2;
	        tab[12][2] = 2;
	        tab[12][11] = 2;
	        tab[13][4] = 2;
	        tab[13][7] = 2;
	        tab[13][8] = 2;
	        tab[13][17] = 2;
	        tab[14][0] = 2;
	        tab[14][4] = 2;
	        tab[14][5] = 2;
	        tab[14][11] = 2;
	        tab[14][13] = 2;
	        tab[15][12] = 2;
	        tab[15][15] = 2;
	        tab[16][12] = 2;
	        tab[16][15] = 2;
	        tab[15][12] = 2;
	        tab[17][1] = 2;
	        tab[17][8] = 2;
	        tab[17][10] = 2;  
	        
	        tab[1][15] = 0;
	        tab[2][6] = 0;
	        tab[4][14] = 0;
	        tab[9][15] = 0;
	        tab[11][0] = 0;
	        tab[12][16] = 0;
	        tab[14][17] = 0;
	        tab[15][8] = 0;
	    
	    
	    
	    
	    	return tab[a][b];
	}
	
	public double attackS() {
		//une attaque spécifique provoque 10*k dégats, k dépendant du type du pokémon qui attaque et de celui qui défend
		// return les dégats
		Type y1 = new Type();
		
		int inta = y1.idType(this.pokeAt.type1);
		int intb = y1.idType(this.pokeDef.type1);
		
		double k = GetCoeff(inta,intb);
		double new_PV = 10*k;
		
		return new_PV;
		
		
		//this.pokeDef.HP = this.pokeDef.HP-10*k;
	}
	
	@Override 
	public String toString() {
		return this.pokeAt + " attaque " + this.pokeDef;
	}
	
	
	
	

}
