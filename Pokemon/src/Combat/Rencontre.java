package Combat;

import Type.TypeNeutre;

public class Rencontre {
	
	public static void Fuite() {
		System.out.println("Vous prenez la fuite");
	}
	
	public static void ChangerPokemon(String Pokemon1 , String Pokemon2) {
		System.out.println(Pokemon1 + " reviens !");
		System.out.println(Pokemon2 + "Go !");
	}
	
	public static boolean contains(String typeAdv , String[] Efficacite ) {
		for(int i=0;i<Efficacite.length;i++) {
			if(typeAdv==Efficacite[i]) {
				return true;
			}
		}
		return false;
	}
	
public static double AttaqueSimple( String typeAtt , String typeDef) {
		
		if (contains(typeDef, Efficacite.Efficace(typeAtt))) {
			return 2;			
		}	// super efficace 
		
		if (contains(typeDef, Efficacite.Neutre(typeAtt))) {
			return 1;			
		}	// neutre
		
		if (contains(typeDef, Efficacite.PasEfficace(typeAtt))) {
			return 0.5;			
		}	// pas tres efficace 
		
		else {
			return 0;			
		}	// ca n'affecte pas
}

public static double AttaqueDouble(String typeAtt , String typeDef1,String typeDef2) {
	
	if(typeDef2=="null") {
		 return AttaqueSimple ( typeAtt , typeDef1);
	}
	
	if ( contains(typeDef1, Efficacite.Efficace(typeAtt)) && contains(typeDef2, Efficacite.Efficace(typeAtt)) ) {
		return 4;
	}	// 2 efficaces
	
	if ( (contains(typeDef1, Efficacite.Efficace(typeAtt)) && contains(typeDef2, Efficacite.Neutre(typeAtt)))
			||(contains(typeDef1, Efficacite.Neutre(typeAtt)) && contains(typeDef2, Efficacite.Efficace(typeAtt))) ) {
		return 2;			
	}	// 1 efficace + 1 neutre
	
	if ( (contains(typeDef1, Efficacite.Efficace(typeAtt)) && contains(typeDef2, Efficacite.PasEfficace(typeAtt)))
			||(contains(typeDef1, Efficacite.PasEfficace(typeAtt)) && contains(typeDef2, Efficacite.Efficace(typeAtt))) ) {
		return 1;			
	}	// 1 efficace + 1 resistance
	
	if ( (contains(typeDef1, Efficacite.Efficace(typeAtt)) && contains(typeDef2, Efficacite.Inefficace(typeAtt)))
			||(contains(typeDef1, Efficacite.Inefficace(typeAtt)) && contains(typeDef2, Efficacite.Efficace(typeAtt))) ) {
		return 0;			
	}	// 1 efficace + 1 inefficace
	
	if ( contains(typeDef1, Efficacite.Neutre(typeAtt)) && contains(typeDef2, Efficacite.Neutre(typeAtt)) ) {
		return 1;			
	}	// 2 neutres
	
	if ( (contains(typeDef1, Efficacite.Neutre(typeAtt)) && contains(typeDef2, Efficacite.PasEfficace(typeAtt)))
			||(contains(typeDef1, Efficacite.PasEfficace(typeAtt)) && contains(typeDef2, Efficacite.Neutre(typeAtt))))  {
		return 0.5;			
	} 	// 1 neutre + 1 pas efficace
	
	if ( (contains(typeDef1, Efficacite.Neutre(typeAtt)) && contains(typeDef2, Efficacite.Inefficace(typeAtt)))
			||(contains(typeDef1, Efficacite.Inefficace(typeAtt)) && contains(typeDef2, Efficacite.Neutre(typeAtt))) ) {
		return 0;			
	}	// 1 neutre + 1 inefficace
	
	if ( contains(typeDef1, Efficacite.PasEfficace(typeAtt)) && contains(typeDef2, Efficacite.PasEfficace(typeAtt)) ) {
		return 0.25;			
	}	// 2 pas efficaces
	
	else  {
		return 0;			
	}	// 1 pas efficace + 1 inefficace ou 2inefficaces(impossible)
	
}

public static String EfficaciteSimple( String typeAtt , String typeDef) {
	if (contains(typeDef, Efficacite.Efficace(typeAtt))) {
		return "Super Efficace ";			
	}
	if (contains(typeDef, Efficacite.Neutre(typeAtt))) {
		return " ";			
	}	
	if (contains(typeDef, Efficacite.PasEfficace(typeAtt))) {
		return "Pas tres efficace";			
	}
	else {
		return "Ca n'affecte pas :( ";			
	}	
}

public static String EfficaciteDouble( String typeAtt , String typeDef1,String typeDef2) {
	if(typeDef2=="null") {
		 return EfficaciteSimple ( typeAtt , typeDef1);
	}
	if ( contains(typeDef1, Efficacite.Efficace(typeAtt)) && contains(typeDef2, Efficacite.Efficace(typeAtt)) ) {
		return "Hyper Efficace ";		
	}
	if ( (contains(typeDef1, Efficacite.Efficace(typeAtt)) && contains(typeDef2, Efficacite.Neutre(typeAtt)))
			||(contains(typeDef1, Efficacite.Neutre(typeAtt)) && contains(typeDef2, Efficacite.Efficace(typeAtt))) ) {
		return "Super Efficace ";			
	}
	if ( (contains(typeDef1, Efficacite.Efficace(typeAtt)) && contains(typeDef2, Efficacite.PasEfficace(typeAtt)))
			||(contains(typeDef1, Efficacite.PasEfficace(typeAtt)) && contains(typeDef2, Efficacite.Efficace(typeAtt))) ) {
		return "";			
	}	
	if ( (contains(typeDef1, Efficacite.Efficace(typeAtt)) && contains(typeDef2, Efficacite.Inefficace(typeAtt)))
			||(contains(typeDef1, Efficacite.Inefficace(typeAtt)) && contains(typeDef2, Efficacite.Efficace(typeAtt))) ) {
		return "Ca n'affecte pas :( ";			
	}
	if ( contains(typeDef1, Efficacite.Neutre(typeAtt)) && contains(typeDef2, Efficacite.Neutre(typeAtt)) ) {
		return "";			
	}
	if ( (contains(typeDef1, Efficacite.Neutre(typeAtt)) && contains(typeDef2, Efficacite.PasEfficace(typeAtt)))
			||(contains(typeDef1, Efficacite.PasEfficace(typeAtt)) && contains(typeDef2, Efficacite.Neutre(typeAtt))))  {
		return "Pas très Efficace ";			
	}	
	if ( (contains(typeDef1, Efficacite.Neutre(typeAtt)) && contains(typeDef2, Efficacite.Inefficace(typeAtt)))
			||(contains(typeDef1, Efficacite.Inefficace(typeAtt)) && contains(typeDef2, Efficacite.Neutre(typeAtt))) ) {
		return "Ca n'affecte pas :( ";		
	}
	if ( contains(typeDef1, Efficacite.PasEfficace(typeAtt)) && contains(typeDef2, Efficacite.PasEfficace(typeAtt)) ) {
		return "Tres peu Efficace ";		
	}	
	else  {
		return "Ca n'affecte pas :( ";			
	}
}


public static double formule_degat(String typeAtt, double attaque , String typeDef1 , String typeDef2 , double HP , double defense ) {
	return(((((50*0.4+2)*attaque*40)/(defense*50))+2)*AttaqueDouble( typeAtt ,  typeDef1,typeDef2));
	}

public static double AttaquePokemonDtype( String PokemonD ,String typeD, double attaqueD ,String PokemonS , String typeS1 , String typeS2, double HPS , double defenseS){
    
    System.out.println("\n" + PokemonD + " attaque " + typeD + "!");
    System.out.println(EfficaciteDouble(typeD,typeS1,typeS2));
    System.out.println("Mon " + PokemonD + " a infligé " + formule_degat(typeD , attaqueD , typeS1 , typeS2 ,HPS,  defenseS ) + " dégats");
    HPS=HPS-formule_degat(typeD,attaqueD, typeS1 , typeS2 ,HPS,  defenseS );
    System.out.println("Il reste " + HPS + " HP au "+ PokemonS +" sauvage");

    return HPS;
    }

public static double AttaquePokemonDNeutre( String PokemonD, double attaqueD , String PokemonS , String typeS1 , String typeS2, double HPS , double defenseS){

    System.out.println("\n" + PokemonD + " attaque Neutre!");
    System.out.println("Mon " +  PokemonD + " a infligé " + TypeNeutre.formule_degat(attaqueD ,HPS,  defenseS ) + " dégats");
    HPS=HPS-TypeNeutre.formule_degat(attaqueD ,HPS,  defenseS );
    System.out.println("Il reste " + HPS + " HP au " + PokemonS + " sauvage");

    return HPS;

}

public static double AttaquePokemonS( String PokemonS , String typeS1, String typeS2, double attaqueS ,String PokemonD,String typeD1, String typeD2, double HPD , double defenseD){

if (Choix.choix_attaqueS().equals("type1")) {
System.out.println("\n" + PokemonS + " sauvage attaque " + typeS1 + " !");
System.out.println(EfficaciteDouble(typeS1,typeD1,typeD2));
System.out.println(PokemonS + " sauvage a infligé " + formule_degat(typeS1 , attaqueS , typeD1 , typeD2 ,HPD ,defenseD) + " dégats");
HPD=HPD-formule_degat(typeS1 , attaqueS , typeD1, typeD2 ,HPD ,defenseD);
System.out.println("Il reste " + HPD + " HP a mon " + PokemonD);
}
if (Choix.choix_attaqueS().equals("type2")) {
System.out.println("\n" + PokemonS + " sauvage attaque " + typeS2 + " !");
System.out.println(EfficaciteDouble(typeS2,typeD1,typeD2));
System.out.println(PokemonS + " sauvage a infligé " + formule_degat(typeS2 , attaqueS , typeD1 , typeD2 ,HPD ,defenseD) + " dégats");
HPD=HPD-formule_degat(typeS2 , attaqueS , typeD1, typeD2 ,HPD ,defenseD);
System.out.println("Il reste " + HPD + " HP a mon " + PokemonD);

}
else {
System.out.println("\n popkemon sauvage attaque Neutre!");
System.out.println("Pokemon sauvage a infligé " + TypeNeutre.formule_degat(attaqueS ,HPD,  defenseD ) + " dégats");
HPD=HPD-TypeNeutre.formule_degat(attaqueS ,HPD,  defenseD );
System.out.println("Il reste " + HPD + " HP a mon Pokemon");
}

return HPD;

}





public static String AttaqueFinalType1(String PokemonD , String typeD1 , String typeD2 , double HPD , double attaqueD , double defenseD , String PokemonS , String typeS1 , String typeS2 , double HPS , double attaqueS , double defenseS ) {
    if(HPD<0) {
    	return PokemonD + "est K.O";
    }
    if(HPD<0) {
    	return PokemonS + "est K.O";
    }
    else {
    	AttaquePokemonDtype( PokemonD , typeD1, attaqueD , PokemonS , typeS1 , typeS2, HPS , defenseS);
    	HPS=HPS-formule_degat(typeD1,attaqueD, typeS1 , typeS2 ,HPS,  defenseS );
    	AttaquePokemonS( PokemonS , typeS1 , typeS2 , attaqueS , PokemonD , typeD1 , typeD2 , HPD , defenseD);
    	if (Choix.choix_attaqueS().equals("typé")) {
    		HPD=HPD-formule_degat(typeS1 , attaqueS , typeD1 , typeD2 ,HPD ,defenseD);
    	}
    	else {
    		HPD=HPD-TypeNeutre.formule_degat(attaqueS ,HPD,  defenseD );
    	}
    	
    	return "\n Les points de vie de mon Pokemon : " + HPD +
                "\n les points de vie du Pokemon sauvage : " + HPS;
    }
        
    
        
}
//fonction a utiliser quand on va appuyer sur le bouton attaque de type

public static String AttaqueFinalType2(String PokemonD , String typeD1 , String typeD2 , double HPD , double attaqueD , double defenseD , String PokemonS , String typeS1 , String typeS2 , double HPS , double attaqueS , double defenseS ) {
    if(HPD<0) {
    	return PokemonD + "est K.O";
    }
    if(HPD<0) {
    	return PokemonS + "est K.O";
    }
    else {
    	AttaquePokemonDtype( PokemonD , typeD2, attaqueD , PokemonS , typeS1 , typeS2, HPS , defenseS);
    	HPS=HPS-formule_degat(typeD2,attaqueD, typeS1 , typeS2 ,HPS,  defenseS );
    	AttaquePokemonS( PokemonS , typeS1,typeS2, attaqueS , PokemonD , typeD1 , typeD2 , HPD , defenseD);
    	if (Choix.choix_attaqueS().equals("typé")) {
    		HPD=HPD-formule_degat(typeS1 , attaqueS , typeD1 , typeD2 ,HPD ,defenseD);
    	}
    	else {
    		HPD=HPD-TypeNeutre.formule_degat(attaqueS ,HPD,  defenseD );
    	}
    	
    	return "\n Les points de vie de mon Pokemon : " + HPD +
                "\n les points de vie du Pokemon sauvage : " + HPS;
    }
        
    
        
}
//fonction a utiliser quand on va appuyer sur le bouton attaque de type2

public static String AttaqueFinalNeutre(String PokemonD , String typeD1 , String typeD2 , double HPD , double attaqueD , double defenseD , String PokemonS , String typeS1 ,String typeS2 , double HPS , double attaqueS , double defenseS ) {
    if(HPD<0) {
    	return PokemonD + "est K.O";
    }
    if(HPD<0) {
    	return PokemonS + "est K.O";
    }
    else {
    	AttaquePokemonDNeutre( PokemonD , attaqueD , PokemonS , typeS1 , typeS2, HPS  , defenseS);
    	HPS=HPS-formule_degat(typeD1,attaqueD, typeS1, typeS2 ,HPS,  defenseS );
    	AttaquePokemonS( PokemonS , typeS1 , typeS2 , attaqueS , PokemonD , typeD1 , typeD2, HPD , defenseD);
    	if (Choix.choix_attaqueS().equals("typé")) {
    		HPD=HPD-formule_degat(typeS1 , attaqueS , typeD1, typeD2 ,HPD ,defenseD);
    	}
    	else {
    		HPD=HPD-TypeNeutre.formule_degat(attaqueS ,HPD,  defenseD );
    	}
    	
    	return "\n Les points de vie de mon Pokemon : " + HPD +
                "\n les points de vie du Pokemon sauvage : " + HPS;
    }
        
    
        
}
//fonction a utiliser quand on va appuyer sur le bouton attaque neutre


/*
public static void AjoutPokedex(String PokemonS) {
	Pokedex.add(PokemonS);
}
*/



public static void main(String[] args) {
	
	//System.out.print(AttaqueDouble("Feu","Acier","null"));
	System.out.print(AttaqueFinalType1("Pikachu" , "Acier","Roche" , Stats.statHP(35) , Stats.statAtt(55) , Stats.statDef(40) , "Salameche" , "Feu" , "Vol" , Stats.statHP(39) , Stats.statAtt(52) , Stats.statDef(43) ));
}
        

}
