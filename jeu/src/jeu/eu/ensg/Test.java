package jeu.eu.ensg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Type feu = new Type("feu");
		Coordinates position = new Coordinates(50.1, 20.9); 
		Statistiques st = new Statistiques(50,60,20,8,25,240,true,1002);
		Pokemon pikachu = new Pokemon( "pikachu", st, position, feu);
		Pokemon salamèche = new Pokemon( "salamèche", st, position, feu);
		Pokemon gruikui = new Pokemon( "gruikui", st, position, feu);

		

		List <Pokemon> L = new ArrayList<Pokemon>();
		L.add (pikachu);
		L.add (salamèche);
		L.add (gruikui);

		L.toString();
		/*
		String[] s = new String[L.size()];
		for (int i=0; i<L.size(); i++) {
			s[i] = L.get(i).getNom();
		
		}
		*/
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Vos autres pokémons sont: " + L + "\n Taper le nom de votre nouveau pokémon " );

		
		String str = sc.nextLine(); //récupère ce que l'on a saisi
		System.out.println("Vous avez saisi : " + str);
	}

}
