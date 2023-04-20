package Combat;

import java.util.Random;
import java.util.Scanner;

public class Choix {
	
	public static String choix_action(){
	    String Choix = "";
	        while (!(Choix.equals("fuite")) && !(Choix.equals("attaque")) && !(Choix.equals("changer de pokemon"))){
	        Scanner input = new Scanner(System.in);
	        System.out.println("Que faire ? -----  Fuite / Attaque / Changer de Pokémon ?");
	        Choix = input.next();
	        }
	     // boucle qui permet de forcer l'utilisateur a faire un des choix propose
	        return Choix;
	}

	public static String choix_attaqueD(){
	    String Attaque = "";
	        Scanner input2 = new Scanner(System.in);
	        while(!(Attaque.equals("neutre")) && !(Attaque.equals("typé")) ){
	            System.out.println("quelle attaque ? --> Neutre ou Typé?");
	            Attaque = input2.next();
	        }
	     // boucle qui permet de forcer l'utilisateur a faire un des choix propose
	        return Attaque;
	}

	public static String choix_attaqueS(){
	    String[] Attaque = {"neutre", "type1" , "type2"};
		Random r = new Random();
		int i = r.nextInt(Attaque.length);
		String rdAttaque = Attaque[i];
	    return rdAttaque;
	}

	public static void main(String[] args) {
		System.out.println(choix_action());
	}

}
