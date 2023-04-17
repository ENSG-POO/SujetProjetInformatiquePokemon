package Type;

import java.util.Scanner;

public class Affrontement {
	


	
	public static String Rencontre() {
		System.out.println("Pokemon sauvage apparait");
		
		Scanner myObj = new Scanner(System.in);
		String Choix;
		System.out.println("Fuite / Attaque / Changer de Pokémon ?");
		Choix = myObj.nextLine();
		System.out.println(Choix=="Fuite");
		if (Choix=="Fuite") {
			return "vous prenez la fuite";
		}
		else {
			return "nul";
		
	}
	}	
	public static void main(String[] args) {
		System.out.println(Affrontement.Rencontre());
	}
	
	

}



 
   
   
        

