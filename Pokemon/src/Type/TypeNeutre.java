package Type;

public class TypeNeutre {
	
	public static double AttaqueDouble(int attaque) {
		return attaque*1;
	}
	
	public static double AttaqueSimple(int attaque) {
		return attaque*1;
	}	

	
	public static String ResultatHP(int HP, int attaque , int defense ,String typeDef) {
		System.out.println("Neutre");
		System.out.println("Pokemon a infligé " + (AttaqueSimple(attaque)-defense) + " dégats");
		double a = HP-(AttaqueSimple(attaque) - defense);
		return "Il reste " + a + " au Pokemon sauvage";
	}

}
