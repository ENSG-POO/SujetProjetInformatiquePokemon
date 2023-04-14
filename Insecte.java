
public class Insecte {
	
	public static final String[] Efficace= {"Plante","Psy","Tenebres"};
	public static final String[] PasEfficace= {"Combat","Acier","Fee","Feu"
			,"Poison","Spectre","Vol"};
	public static final String[] Neutre= {"Dragon","Insecte","Normal"
	,"Eau","Electrique","Sol","Glace","Roche"};
	public static final String[] Inefficace= {};
	
	public static boolean contains(String typeAdv , String[] Efficacite ) {
		for(int i=0;i<Efficacite.length;i++) {
			if(typeAdv==Efficacite[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static double Attaque(String typeAdv1,String typeAdv2) {
		
		if ( contains(typeAdv1, Efficace) && contains(typeAdv2, Efficace) ) {
			System.out.println("Hyper Efficace ");
			return 4;
			
		}	// 2 faiblesses
		
		if ( (contains(typeAdv1, Efficace) && contains(typeAdv2, Neutre))
				||(contains(typeAdv1, Neutre) && contains(typeAdv2, Efficace)) ) {
			System.out.println("Super Efficace ");
			return 2;			
		}	// 1 faiblesse + 1 neutre
		
		if ( (contains(typeAdv1, Efficace) && contains(typeAdv2, PasEfficace))
				||(contains(typeAdv1, PasEfficace) && contains(typeAdv2, Efficace)) ) {
			System.out.println("Neutre ");
			return 1;			
		}	// 1 faiblesse + 1 resistance
		
		if ( (contains(typeAdv1, Efficace) && contains(typeAdv2, Inefficace))
				||(contains(typeAdv1, Inefficace) && contains(typeAdv2, Efficace)) ) {
			System.out.println("Ca n'affecte pas :( ");
			return 0;			
		}	// 1 faiblesse + 1 inefficace
		
		if ( contains(typeAdv1, Neutre) && contains(typeAdv2, Neutre) ) {
			System.out.println("Neutre ");
			return 1;			
		}	// 2 neutres
		
		if ( (contains(typeAdv1, Neutre) && contains(typeAdv2, PasEfficace))
				||(contains(typeAdv1, PasEfficace) && contains(typeAdv2, Neutre)))  {
			System.out.println("Pas très Efficace ");
			return 0.5;			
		} 	// 1 neutre + 1 faiblesse
		
		if ( (contains(typeAdv1, Neutre) && contains(typeAdv2, Inefficace))
				||(contains(typeAdv1, Inefficace) && contains(typeAdv2, Neutre)) ) {
			System.out.println("Ca n'affecte pas :( ");
			return 0;			
		}	// 1 neutre + 1 inefficace
		
		if ( contains(typeAdv1, PasEfficace) && contains(typeAdv2, PasEfficace) ) {
			System.out.println("Tres peu Efficace ");
			return 0.25;			
		}	// 2 faiblesses
		
		else  {
			System.out.println("Ca n'affecte pas :( ");
			return 0;			
		}	// 1 faiblesse + 1 inefficace ou 2inefficaces(impossible)
		
	}
	
}
