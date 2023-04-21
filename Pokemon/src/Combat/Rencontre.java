package Combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Type.TypeNeutre;
import pilotejeu.MesPokemon;
import pilotejeu.MesPokemon.*;
import pilotejeu.pokemon;
import pilotejeu.tableau;

public class Rencontre {
	


	
public static boolean contains(String typeAdv , String[] Efficacite ) {
		for(int i=0;i<Efficacite.length;i++) {
			if(typeAdv.equals(Efficacite[i])) {
				return true;
			}
		}
		return false;
	}
// Sert a savoir si un type fais partie d'une autre liste qui contient des types en fonctions de leur efficacite	


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
//Ces fonctions servent a donner le coefficient multiplicatif a l'attaque selon le type



public static String EfficaciteSimple( String typeAtt , String typeDef) {
	if (contains(typeDef, Efficacite.Efficace(typeAtt))) {
		return "Super Efficace ";			
	}
	if (contains(typeDef, Efficacite.Neutre(typeAtt))) {
		return "neutre";			
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
		return "neutre";			
	}	
	if ( (contains(typeDef1, Efficacite.Efficace(typeAtt)) && contains(typeDef2, Efficacite.Inefficace(typeAtt)))
			||(contains(typeDef1, Efficacite.Inefficace(typeAtt)) && contains(typeDef2, Efficacite.Efficace(typeAtt))) ) {
		return "Ca n'affecte pas :( ";			
	}
	if ( contains(typeDef1, Efficacite.Neutre(typeAtt)) && contains(typeDef2, Efficacite.Neutre(typeAtt)) ) {
		return "neutre";			
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
// Ces fonctions retournent l'efficacite d'un type par rapport a l'autre


public static double formule_degat(String typeAtt, double attaque , String typeDef1 , String typeDef2 , double HP , double defense ) {
	return(((((50*0.4+2)*attaque*40)/(defense*50))+2)*AttaqueDouble( typeAtt ,  typeDef1,typeDef2));
	}



public static double AttaquePokemonDtype1( pokemon PokemonD , pokemon PokemonS ){
	
	
	System.out.println("\n" + PokemonD.getNom() + " attaque " + PokemonD.getType1() + "!");
    System.out.println(EfficaciteDouble(PokemonD.getType1(),PokemonS.getType1(),PokemonS.getType2()));
    System.out.println("Mon " + PokemonD.getNom() + " a infligé " + formule_degat(PokemonD.getType1() , PokemonD.getAtt() , PokemonS.getType1() , PokemonS.getType2() ,PokemonS.getHP(),  PokemonS.getDef() ) + " dégats");
    PokemonS.setHP(PokemonS.getHP()-formule_degat(PokemonD.getType1() , PokemonD.getAtt() , PokemonS.getType1() , PokemonS.getType2() ,PokemonS.getHP(),  PokemonS.getDef() ));
    System.out.println("Il reste " + PokemonS.getHP() + " HP au "+ PokemonS.getNom() +" sauvage");

    return PokemonS.getHP();
    }
public static double AttaquePokemonDtype2( pokemon PokemonD , pokemon PokemonS ){
    System.out.println("\n" + PokemonD.getNom() + " attaque " + PokemonD.getType2() + "!");
    System.out.println(EfficaciteDouble(PokemonD.getType2(),PokemonS.getType1(),PokemonS.getType2()));
    System.out.println("Mon " + PokemonD.getNom() + " a infligé " + formule_degat(PokemonD.getType2() , PokemonD.getAtt() , PokemonS.getType1() , PokemonS.getType2() ,PokemonS.getHP(),  PokemonS.getDef() ) + " dégats");
    PokemonS.setHP(PokemonS.getHP()-formule_degat(PokemonD.getType2(),PokemonD.getAtt(), PokemonS.getType1(),PokemonS.getType2() ,PokemonS.getHP(),  PokemonS.getDef() ));
    System.out.println("Il reste " + PokemonS.getHP() + " HP au "+ PokemonS.getNom() +" sauvage");

    return PokemonS.getHP();
    }
public static double AttaquePokemonDNeutre( pokemon PokemonD, pokemon PokemonS){

    System.out.println("\n" + PokemonD.getNom() + " attaque Neutre!");
    System.out.println("Mon " +  PokemonD.getNom() + " a infligé " + TypeNeutre.formule_degat(PokemonD.getAtt() ,PokemonS.getHP(),  PokemonS.getDef() ) + " dégats");
    PokemonS.setHP(PokemonS.getHP()-TypeNeutre.formule_degat(PokemonD.getAtt() ,PokemonS.getHP(),  PokemonS.getDef() ));
    System.out.println("Il reste " + PokemonS.getHP() + " HP au " + PokemonS.getNom() + " sauvage");

    return PokemonS.getHP();

}
//Ces fonctions montrent le resulat d'une attaque d'un pokemon domestique sur un pokemon sauvage selon le type de l'attaque


public static double AttaquePokemonS( pokemon PokemonS , pokemon PokemonD){
	String a =Choix.choix_attaqueS();
if (a.equals("type1")) {
System.out.println("\n" + PokemonS.getNom() + " sauvage attaque " + PokemonS.getType1() + " !");
System.out.println(EfficaciteDouble(PokemonS.getType1(),PokemonD.getType1(),PokemonD.getType2()));
System.out.println(PokemonS.getNom() + " sauvage a infligé " + formule_degat(PokemonS.getType1() , PokemonS.getAtt() , PokemonD.getType1() , PokemonD.getType2() ,PokemonD.getHP() ,PokemonD.getDef()) + " dégats");
PokemonD.setHP(PokemonD.getHP()-formule_degat(PokemonS.getType2() , PokemonS.getAtt() , PokemonD.getType1(), PokemonD.getType2() ,PokemonD.getHP() ,PokemonD.getDef()));
System.out.println("Il reste " + PokemonD.getHP() + " HP a mon " + PokemonD.getNom());
}
if (a.equals("type2")) {
System.out.println("\n" + PokemonS.getNom() + " sauvage attaque " + PokemonS.getType2() + " !");
System.out.println(EfficaciteDouble(PokemonS.getType2(),PokemonD.getType1(),PokemonD.getType2()));
System.out.println(PokemonS.getNom() + " sauvage a infligé " + formule_degat(PokemonS.getType2() , PokemonS.getAtt() , PokemonD.getType1() , PokemonD.getType2() ,PokemonD.getHP() ,PokemonD.getDef()) + " dégats");
PokemonD.setHP(PokemonD.getHP()-formule_degat(PokemonS.getType2() , PokemonS.getAtt() , PokemonD.getType1(), PokemonD.getType2() ,PokemonD.getHP() ,PokemonD.getDef()));
System.out.println("Il reste " + PokemonD.getHP() + " HP a mon " + PokemonD.getNom());

}
if (a.equals("neutre")) {
System.out.println("\n" + PokemonS.getNom() + " sauvage attaque Neutre!");
System.out.println(PokemonS.getNom() + " sauvage a infligé " + TypeNeutre.formule_degat(PokemonS.getAtt() ,PokemonD.getHP(),  PokemonD.getDef() ) + " dégats");
PokemonD.setHP(PokemonD.getHP()-TypeNeutre.formule_degat(PokemonS.getAtt() ,PokemonD.getHP(),  PokemonD.getDef() ) );
System.out.println("Il reste " + PokemonD.getHP() + " HP a mon " + PokemonD.getNom());
}

return PokemonD.getHP();

}
// Cette fonction retournent le resultat d'une attaque qu'un pokemon sauvage a fait au hasard



public static List<String> pokedex_initial( ){
	List<String> pokedex = new ArrayList<String>() ;
	pokedex.add("Nidoking");
	pokedex.add("Charizard");
	pokedex.add("Tentacool");
	return pokedex;
}

public static List<String> ajout_pokedex(List<String> pokedex , pokemon PokemonS){
	pokedex.add(PokemonS.getNom());
	return pokedex;
}

public static String AttaqueFinal(pokemon PokemonD , pokemon PokemonS ) {
	System.out.println(PokemonS.getNom() + " sauvage veut se battre");
	String message = null;
	while (PokemonD.getHP()>0 && PokemonS.getHP()>0){
			String Attaque = "";
	        Scanner input2 = new Scanner(System.in);
	        while(!(Attaque.equals("neutre")) && !(Attaque.equals("type1")) && !(Attaque.equals("type2")) ){
	            System.out.println("quelle attaque ? --> Neutre ou Type1 ou Type2 ");
	            Attaque = input2.next();
	        }
	     // boucle qui permet de forcer l'utilisateur a faire un des choix propose
	   
			if(Attaque.equals("neutre")) {
				AttaquePokemonDNeutre( PokemonD  , PokemonS );
		    	AttaquePokemonS( PokemonS , PokemonD );
		    	System.out.println("\n Les points de vie de mon " + PokemonD.getNom() + " : " + PokemonD.getHP() +
		                "\n les points de vie du " + PokemonS.getNom() + " sauvage : " + PokemonS.getHP());
			}
			if(Attaque.equals("type1")) {
				AttaquePokemonDtype1( PokemonD , PokemonS);
		    	AttaquePokemonS( PokemonS , PokemonD );
		        System.out.println("\n Les points de vie de mon " + PokemonD.getNom() + " : " + PokemonD.getHP() +
		                		"\n les points de vie du " + PokemonS.getNom() + " sauvage : " + PokemonS.getHP());
			}
			if(Attaque.equals("type2")) {
				AttaquePokemonDtype2( PokemonD , PokemonS );
		    	AttaquePokemonS( PokemonS , PokemonD );
				System.out.println("\n Les points de vie de mon " + PokemonD.getNom() + " : " + PokemonD.getHP() +
									"\n les points de vie du " + PokemonS.getNom() + " sauvage : " + PokemonS.getHP());
			}
			
			if(PokemonD.getHP()<=0) {
				PokemonD.setHP(0);
				message= PokemonD.getNom() + " est K.O"+
						"\n Votre pokedex est composé de " + ajout_pokedex(pokedex_initial(),null) ;	
			}
			if(PokemonS.getHP()<=0) {
				PokemonS.setHP(0);
				message= PokemonS.getNom() + " est K.O"+
						"\n Vous avez attrapé " + PokemonS.getNom()+
						"\n Votre pokedex est composé de " + ajout_pokedex(pokedex_initial(),PokemonS) ;
				//ajout_pokedex(PokemonS);
			}
	}
	return "PV  " + PokemonD.getNom() + " = " + PokemonD.getHP()+
			" \n PV  " + PokemonS.getNom() + " = " + PokemonS.getHP()+
			"\n" + message ;
		
	
	}
		
	




public static void main(String[] args) {
	

	pokemon Magneton = new pokemon("Magneton");
	pokemon Nidoking = new pokemon("Nidoking");
    
   
	System.out.println("type de Magneton   1:" + Magneton.getType1() + " 2 : " + Magneton.getType2() );
	System.out.println("type de Nidoking   1:" + Nidoking.getType1() + " 2 : " + Nidoking.getType2() );
	
	System.out.print(AttaqueFinal(Nidoking,Magneton));
}
        

}