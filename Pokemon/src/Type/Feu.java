package Type;

public class Feu {
	
	public static final String[] Efficace= {"Acier","Plante","Glace","Insecte"};
	public static final String[] PasEfficace= {"Roche","Dragon","Feu","Eau"};
	public static final String[] Neutre= {"Combat","Fee","Electrique"
			,"Normal","Psy","Spectre","Tenebres","Vol","Sol","Poison"};
	public static final String[] Inefficace= {};
	
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
	
public static double AttaqueSimple(String typeAdv) {
		
		if (contains(typeAdv, Efficace)) {
			System.out.println("Super Efficace ");
			return 2;			
		}	// efficace 
		
		if (contains(typeAdv, Neutre)) {
			System.out.println("Neutre ");
			return 1;			
		}	// neutre
		
		if (contains(typeAdv, PasEfficace)) {
			System.out.println("Pas tres efficace");
			return 0.5;			
		}	// pas afficace 
		
		else {
			System.out.println("Ca n'affecte pas :( ");
			return 0;			
		}	// inefficace
}

}
