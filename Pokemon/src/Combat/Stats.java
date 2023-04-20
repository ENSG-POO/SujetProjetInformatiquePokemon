package Combat;

public class Stats {

	public static double statAtt(double attaque) {
		return (((2*attaque)*50)/100)+5;
	}

	public static double statDef(double defense) {
		return (((2*defense)*50)/100)+5;
	}

	public static double statHP(double HP) {
		return (((2*HP)*50)/100)+50+10;
	}

	public static double statVit(double vitesse) {
		return (((2*vitesse)*50)/100)+5;
	}

	
}
