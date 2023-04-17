package Type;

import java.util.Scanner;

public class Affrontement {
	

	

	public static String Rencontre(String type, int attaque , int HP , int defense ,String typeDef) {
		System.out.println("Pokemon sauvage apparait");
		System.out.println("Tu as un pokemon de type " + type);
		System.out.println("Tu recontres un pokemon de type " + typeDef);
		
		
        String Choix = "";
        while (!(Choix.equals("fuite")) && !(Choix.equals("attaque")) && !(Choix.equals("changer de pokemon"))){
        	Scanner input = new Scanner(System.in);
            System.out.println("Fuite / Attaque / Changer de Pokémon ?");
		    Choix = input.next();
        }
        // boucle qui permet de forcer l'utilisateur a faire un des choix proposer
		if (Choix.equals("fuite")) {
			return "vous prenez la fuite";
		}
		if (Choix.equals("attaque")){

            if(type=="Acier"){
                return Acier.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Combat"){
                return Combat.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Dragon"){
                return Dragon.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Eau"){
                return Eau.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Electrique"){
                return Electrique.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Fee"){
                return Fee.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Feu"){
                return Feu.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Glace"){
                return Glace.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Insecte"){
                return Insecte.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Normal"){
                return Normal.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Plante"){
                return Plante.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Poison"){
                return Poison.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Psy"){
                return Psy.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Roche"){
                return Roche.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Sol"){
                return Sol.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Spectre"){
                return Spectre.choix_attaque(attaque , HP , defense , typeDef);
            }
            if(type=="Tenebres"){
                return Tenebres.choix_attaque(attaque , HP , defense , typeDef);
            }
            else {
            	return Vol.choix_attaque(attaque, HP, defense, typeDef);
            }
		}
		else {
				return "ca change de poke a remplir...";
				}
		
	}
		
	

	public static void main(String[] args) {
		System.out.println(Rencontre("Eau",40, 80,30, "Plante"));
	}
	
	

}