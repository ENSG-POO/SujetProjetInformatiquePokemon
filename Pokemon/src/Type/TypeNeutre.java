package Type;

public class TypeNeutre {
	
	public static double AttaqueDouble(double attaque) {
		return attaque*1;
	}
	
	public static double AttaqueSimple(double attaque) {
		return attaque*1;
	}	

	
	public static String ResultatHP(double attaque, double HP , double defense ,String typeDef) {
		System.out.println("Neutre");
		System.out.println("Pokemon a infligé " + (AttaqueSimple(attaque)-defense) + " dégats");
		double a = HP-(AttaqueSimple(attaque) - defense);
		return "Il reste " + a + " au Pokemon sauvage";
	}
	
	public static double formule_degat(double HP, double attaque , double defense ) {
		return(((((1*0.4+2)*attaque*40)/(defense*50))+2)*1);
		}

}
