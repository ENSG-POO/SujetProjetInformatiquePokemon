package Type;

public class Neutre {
	
	public static double AttaqueDouble(int attaque) {
		return 1;
	}
	
	public static double AttaqueSimple(int attaque) {
		return 1;
	}	

	
	public static String ResultatHP(int HP, int attaque , int defense ,String typeDef) {
		System.out.println("Neutre");
		System.out.println("Pokemon a infligé " + (AttaqueSimple(attaque)-defense) + " dégats");
		double a = HP-(AttaqueSimple(attaque) - defense);
		return "Il reste " + a + " au Pokemon sauvage";
	}
}
