package jeu.eu.ensg.GestionPokemon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combat {
    public Pokemon pokemonATQ;
    public Pokemon pokemonDEF;
    public boolean EtatCombat;
	public List<Pokemon> equipe;
	String csvFilePath = "D:\\DeBockRosierMiras\\data\\pokemon_first_gen.csv";
    List<Pokemon> pokemonList = TablePokemon.readPokemonCSV(csvFilePath);

	//constructeur indiquant qu'un combat nécéssite un pokemon en attaque et un pokémon en défense, l'équipe du joueur et l'état du combat (fini ou non)
	public Combat(Pokemon pokemonATQ,Pokemon pokemonDEF,List<Pokemon> equipe,boolean EtatCombat) {
		this.pokemonATQ = pokemonATQ;
		this.pokemonDEF = pokemonDEF;
		this.equipe = equipe;
		this.EtatCombat = true;
	}
	
	//Getters
    public Pokemon getPokemonATQ() {
        return this.pokemonATQ;
    }

    public Pokemon getPokemonDEF() {
        return this.pokemonDEF;
    }

    public List<Pokemon> getEquipe() {
        return this.equipe;
    }

    public boolean getEtatCombat() {
        return this.EtatCombat;
    }

    // Setters
    public void setPokemonATQ(Pokemon pokemonATQ) {
        this.pokemonATQ = pokemonATQ;
    }

    public void setPokemonDEF(Pokemon pokemonDEF) {
        this.pokemonDEF = pokemonDEF;
    }

    public void setEquipe(List<Pokemon> equipe) {
        this.equipe = equipe;
    }

    public void setEtatCombat(boolean EtatCombat) {
        this.EtatCombat = EtatCombat;
    }
		
	//méthode renvoyant le coefficient a appliquer lors d'une attaque élémentaire
	public static double getCoef(Pokemon pokemonATQ,Pokemon pokemonDEF) {
		String[] type = {"Normal","Fire","Water","Electric","Grass","Ice","Fighting","Poison","Ground","Flying","Psychic","Bug","Rock","Ghost","Dragon","Fairy","Steel"};
		
		//chart représente la matrice des forces et faiblesses des différents types dans pokémon
		double[][] chart = {
				{1,1,1,1,1,1,1,1,1,1,1,1,0.5,0,1,1,0.5},
				{1,0.5,0.5,1,2,2,1,1,1,1,1,2,0.5,1,0.5,1,2},
				{1,2,0.5,1,0.5,1,1,1,2,1,1,1,2,1,0.5,1,1},
				{1,1,2,0.5,0.5,1,1,1,0,2,1,1,1,1,0.5,1,1},
				{1,0.5,2,1,0.5,1,1,0.5,2,0.5,1,0.5,2,1,0.5,1,0.5},
				{1,1,0.5,1,2,0.5,1,1,2,2,1,1,1,1,2,1,0.5},
				{2,1,1,1,1,2,1,0.5,1,0.5,0.5,0.5,2,0,1,0.5,2},
				{1,1,1,1,2,1,1,0.5,0.5,1,1,2,0.5,0.5,1,2,0},
				{1,2,1,2,0.5,1,1,2,1,0,1,0.5,2,1,1,1,2},
				{1,1,1,0.5,2,1,2,1,1,1,1,2,0.5,1,1,1,0.5},
				{1,1,1,1,1,1,2,2,1,1,0.5,1,1,1,1,1,0.5},
				{1,0.5,1,1,2,1,0.5,2,1,0.5,2,1,1,0.5,1,0.5,0.5},
				{1,2,1,1,1,2,0.5,1,0.5,2,1,2,1,1,1,1,0.5},
				{0,1,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,0,0.5},
				{1,0.5,1,1,1,1,2,0.5,1,1,1,1,1,1,2,1,0.5},
				{1,0.5,0.5,0.5,1,2,1,1,1,1,1,1,2,1,1,2,0.5}
		};
		
		String type1PokA = pokemonATQ.getType1();
		
		String type1PokD = pokemonDEF.getType1();
		String type2PokD = pokemonDEF.getType2();
		
		//premier cas lorsque le pokémon en défense n'a qu'un seul type
		if (type2PokD.equals("")) {
			int iPA1 = Arrays.asList(type).indexOf(type1PokA);
			int iPD1 = Arrays.asList(type).indexOf(type1PokD);
			
			double coef =  chart[iPA1][iPD1];
			return coef;
		//cas ou le pokémon en défense a deux types
		}else {
			int iPA1 = Arrays.asList(type).indexOf(type1PokA);
			int iPD1 = Arrays.asList(type).indexOf(type1PokD);
			int iPD2 = Arrays.asList(type).indexOf(type2PokD);
			
			//lors d'un double type le coefficient est le produits des deux coefficients
			double coef =  chart[iPA1][iPD1]*chart[iPA1][iPD2];
			return coef;
		}
	}

	//méthode permettant d'effecture une attaque Spe au pokémon adverse, avec une formule trouvé sur internet et légèremenent modifié pour équilibrer le jeu
	public void AtqSpe(Pokemon pokemonDEF) {
		Pokemon pokemonATQ = equipe.get(0);//prends le premier pokémon e l'équipe
		double coef = getCoef(pokemonATQ,pokemonDEF);
		int atq = pokemonATQ.getSpAtk();
		int pui = (int) Math.round(atq/1.5);
		double dgt = (double) (((((50*0.4+2)*atq*pui)/pokemonDEF.getSpDef())/50)+2)*coef*1.5;
		int dg = pokemonDEF.getHp() - Math.round((int) dgt);
		if(dg<=0) {pokemonDEF.setHp(0);}
	    else{pokemonDEF.setHp(dg);}//retire directement des points de vie au pokémon a l'aide du setters setHp
	}
	
	//méthode quasiment identique a la prcédente sauf qu'on ne multiplie pas par le coefficient de type.
	public void AtqNeutre( Pokemon pokemonDEF) {
		Pokemon pokemonATQ = equipe.get(0);
	    int atq = pokemonATQ.getAttack();
	    int pui = (int) Math.round(atq/1.5);
	    double dgt = (double) ((((50*0.4+2)*atq*pui)/pokemonDEF.getDefense())/50)+2;
	    int dg = pokemonDEF.getHp() - (int) Math.round(dgt);
	    if(dg<=0) {pokemonDEF.setHp(0);}
	    else{pokemonDEF.setHp(dg);}
	}
	
	public void AtqEnnemie() {
		int atq = pokemonDEF.getAttack();
	    int pui = (int) Math.round(atq/1.5);
	    double dgt = (double) ((((50*0.4+2)*atq*pui)/pokemonATQ.getDefense())/50)+2;
	    int dg = equipe.get(0).getHp() - (int) Math.round(dgt);
	    if(dg<=0) {equipe.get(0).setHp(0);}
	    else{equipe.get(0).setHp(dg);}
	}
	
	//méthode permettant de changer son pokémon avec un autre pokémon de son équipe seulement si il est dans l'équipe
	public void Switch(Pokemon pokemonEch) {
	    if(equipe.contains(pokemonEch)) {
	        int iPokEch = equipe.indexOf(pokemonEch);
	        Collections.swap(equipe, 0, iPokEch);//permet d'échanger deux éléments dans une liste
	    }
	}
	
	//méthode permettant de vérifier si un pokémons est vivant
	public boolean EstVivant() {
		Pokemon pokemon = equipe.get(0);
		int hp = pokemon.getHp();
		if(hp>0) {return true;
		}else {return false;}		
	}
	
	public void fuite(Combat combat) {
		combat.setEtatCombat(false);
	}
	
	
	//méthode permettant de capturer le pokémon que l'on viens de tuer et de l'ajouter a la lsite équipe
	public void Capturer(Pokemon pokemonCapt) {
		if(!equipe.contains(pokemonCapt)) {
			equipe.add(pokemonCapt);
			pokemonCapt.setEtatPokemon(true);
			}
		
		
	}
	public void resetEquipe() {
	    for (Pokemon pokemon : equipe) {
	        pokemon.setHp(TablePokemon.getPokemonByName(pokemon.getName(),pokemonList).getHp());
	    }
	}

		
	
}

