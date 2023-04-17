package Type;

import java.util.Scanner;

public class Poison {
	
	public static final String[] Efficace= {"Plante","Fee"};
	public static final String[] PasEfficace= {"Roche","Sol","Spectre","Poison"};
	public static final String[] Neutre= {"Combat","Glace","Electrique","Insecte"
			,"Normal","Psy","Tenebres","Dragon","Vol","Feu","Eau"};
	public static final String[] Inefficace= {"Acier"};
	
	
	
	public static boolean contains(String typeAdv , String[] Efficacite ) {
		for(int i=0;i<Efficacite.length;i++) {
			if(typeAdv==Efficacite[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static double AttaqueDouble(String typeAdv1,String typeAdv2) {
		
		if ( contains(typeAdv1, Efficace) && contains(typeAdv2, Efficace) ) {
			System.out.println("Hyper Efficace ");
			return 4;
			
		}	// 2 efficaces
		
		if ( (contains(typeAdv1, Efficace) && contains(typeAdv2, Neutre))
				||(contains(typeAdv1, Neutre) && contains(typeAdv2, Efficace)) ) {
			System.out.println("Super Efficace ");
			return 2;			
		}	// 1 efficace + 1 neutre
		
		if ( (contains(typeAdv1, Efficace) && contains(typeAdv2, PasEfficace))
				||(contains(typeAdv1, PasEfficace) && contains(typeAdv2, Efficace)) ) {
			System.out.println("Neutre ");
			return 1;			
		}	// 1 efficace + 1 resistance
		
		if ( (contains(typeAdv1, Efficace) && contains(typeAdv2, Inefficace))
				||(contains(typeAdv1, Inefficace) && contains(typeAdv2, Efficace)) ) {
			System.out.println("Ca n'affecte pas :( ");
			return 0;			
		}	// 1 efficace + 1 inefficace
		
		if ( contains(typeAdv1, Neutre) && contains(typeAdv2, Neutre) ) {
			System.out.println("Neutre ");
			return 1;			
		}	// 2 neutres
		
		if ( (contains(typeAdv1, Neutre) && contains(typeAdv2, PasEfficace))
				||(contains(typeAdv1, PasEfficace) && contains(typeAdv2, Neutre)))  {
			System.out.println("Pas très Efficace ");
			return 0.5;			
		} 	// 1 neutre + 1 pas efficace
		
		if ( (contains(typeAdv1, Neutre) && contains(typeAdv2, Inefficace))
				||(contains(typeAdv1, Inefficace) && contains(typeAdv2, Neutre)) ) {
			System.out.println("Ca n'affecte pas :( ");
			return 0;			
		}	// 1 neutre + 1 inefficace
		
		if ( contains(typeAdv1, PasEfficace) && contains(typeAdv2, PasEfficace) ) {
			System.out.println("Tres peu Efficace ");
			return 0.25;			
		}	// 2 pas efficaces
		
		else  {
			System.out.println("Ca n'affecte pas :( ");
			return 0;			
		}	// 1 pas efficace + 1 inefficace ou 2inefficaces(impossible)
		
	}
	
public static double AttaqueSimple( String typeAdv) {
		
		if (contains(typeAdv, Efficace)) {
			return 2;			
		}	// super efficace 
		
		if (contains(typeAdv, Neutre)) {
			return 1;			
		}	// neutre
		
		if (contains(typeAdv, PasEfficace)) {
			return 0.5;			
		}	// pas tres efficace 
		
		else {
			return 0;			
		}	// ca n'affecte pas
}

public static String Efficacite( String typeAdv) {
	if (contains(typeAdv, Efficace)) {
		return "Super Efficace ";			
	}
	if (contains(typeAdv, Neutre)) {
		return "Neutre ";			
	}	
	if (contains(typeAdv, PasEfficace)) {
		return "Pas tres efficace";			
	}
	else {
		return "Ca n'affecte pas :( ";			
	}	
}


public static String ResultatHP(int HP, int attaque , int defense ,String typeDef) {
	System.out.println(Efficacite(typeDef));
	System.out.println("Pokemon a infligé " + (((((1*0.4+2)*attaque*40)/(defense*50))+2)*AttaqueSimple(typeDef)) + " dégats");
	double a = HP-(((((1*0.4+2)*attaque*40)/(defense*50))+2)*AttaqueSimple(typeDef));
	return "Il reste " + a + " au Pokemon sauvage";
}


public static String choix_attaque(int HP, int attaque , int defense ,String typeDef) {
	String Attaque = "";
	Scanner input2 = new Scanner(System.in);
    while(!(Attaque.equals("neutre")) && !(Attaque.equals("typé")) ){
        System.out.println("quelle attaque ? --> Neutre ou Typé?");
        System.out.println("conseil : " + Poison.Efficacite(typeDef));
        Attaque = input2.next();
    }
 // boucle qui permet de forcer l'utilisateur a faire un des choix propose
    if (Attaque.equals("typé")) {
	    return Poison.ResultatHP( attaque , HP , defense , typeDef);
    }
    else {
	    return TypeNeutre.ResultatHP( attaque , HP , defense, typeDef);
    }
}

}
