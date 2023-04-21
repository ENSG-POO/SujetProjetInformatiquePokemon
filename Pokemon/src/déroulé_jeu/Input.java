package déroulé_jeu;

import java.util.ArrayList;
import java.util.Scanner;
import gestion_pokémon.*;

public class Input {

    public static void main(String[] args)  
    { 
    	
    //Début du jeu
    int Dim_jeu = 70;
    int LimSizeDraft=6;
	int CompteurSoins = 0;
	int CompteurDraft = 0;
	int LimCompteurSoins = 3;
	int LimCompteurDraft = 10;
	int Start_Nb=4;
	
    Coordinate coord = new Coordinate(-1,-1);
    Coordinate position = coord.PositionInitiale(Dim_jeu);
    System.out.println(position);
    
    Coordinate CoordCS = new Coordinate(position.getX(),position.getY());
    
    //Génération des pokémons.
    Ensemble_Pokemon Univers = new Ensemble_Pokemon ();
	Univers.attribuer_coord(Dim_jeu,CoordCS);
    	
    //Choix aléatoire des 4 premiers pokémons.
	ArrayList<Pokemon> team = Univers.PokemonDeDépart(Start_Nb);
	System.out.println("Votre équipe de départ est composée de "+ team);
	
	
	
	while(!(team.isEmpty()) && Univers.NbPokéRestant ()!=0) {
		//Problème de la localisation au centre de soin
		Scanner sc= new Scanner(System.in);    
	    System.out.print("entrer choix direction : 4=ouest, 8=nord, 5=sud, 6=est, 2=centre de soin  --> ");  
	    int a= sc.nextInt();  
	    
	    position.Mouvement(a, CoordCS);
		//Déplacement tant qu'on ne rencontre pas de pokémon ou qu'on ne va pas au centre de soin.
		while (!(Univers.contains(position))&&!(position.equals(CoordCS))) {
			sc= new Scanner(System.in);    
		    System.out.print("entrer choix direction : 4=ouest, 8=nord, 5=sud, 6=est, 2=centre de soin  --> ");  
		    a= sc.nextInt();
		    
		    position.Mouvement(a, CoordCS);
		}
		
		//Combat contre un pokémon
		if (Univers.contains(position)) {
			Pokemon Poke_Sauvage = Univers.Rencontre (position);
			System.out.println("un "+ Poke_Sauvage.getNom() + " sauvage apparait, tentez de le capturer !");
			Pokemon Poke_Combattant = Univers.Choix_Combattant();

			//Pokemon sauvage plus rapide
			if (Poke_Sauvage.speed>Poke_Combattant.speed) { 
				double degat = Poke_Sauvage.Degat(Poke_Combattant,true);
				Poke_Combattant.HP-=degat;
				System.out.println(Poke_Sauvage.getNom() + "vous a infligé " + degat + " points de degat.");
				System.out.println("Points de vie de votre pokemon: " + Poke_Combattant.HP + " | de votre adversaire: " + Poke_Sauvage.HP);
			
				//KO avant la moindre action
				if (Poke_Combattant.HP<=0) {
					Poke_Combattant.Deviens_poss();
					team.remove(Poke_Combattant);
					if (!(team.isEmpty())) {
						System.out.println(Poke_Combattant + "a perdu du premier coup!");
						Poke_Combattant = Univers.Choix_Combattant();
						System.out.println(Poke_Combattant + "prend le relais !");
						}
					}
			}
			boolean tour = false;
			boolean fuite = true;
			while ((!(team.isEmpty()) && !(Poke_Sauvage.HP<=0) && fuite)) {
				 	tour = !tour;
				 	//Tour du joueur
					if (tour) {
						Scanner choix = new Scanner(System.in);
						System.out.print("Entrer : 0 pour attaquer | 1 pour fuir | 2 pour changer de Pokemon");  
					    int c = choix.nextInt();
					    while (!(c >= 0 && c <=2)) {
					    	System.out.println("Choix invalide. Veuillez réessayer.");
					    	choix = new Scanner(System.in);
							System.out.print("Entrer : 0 pour commencer le combat | 1 pour fuir | 2 pour changer de Pokemon");
							c = choix.nextInt();}
						    
						 if (c==0) {
							 double degat = Poke_Combattant.Degat(Poke_Sauvage,false);
							 System.out.println(Poke_Combattant.getNom() + "a infligé " + degat + " points de dégat à votre adversaire.");
							 Poke_Sauvage.HP-=degat;
							 System.out.println("Points de vie de votre pokemon : " + Poke_Combattant.HP + " | de votre adversaire: " + Poke_Sauvage.HP);
						    }
						 if (c==1) {fuite=!fuite;
						 			System.out.println(fuite);}
						 if (c==2) {Poke_Combattant = Univers.Choix_Combattant();}
						}
					//Tour du pokémon sauvage
					else {
						double degat = Poke_Sauvage.Degat(Poke_Combattant,true);
						System.out.println(Poke_Sauvage.getNom() + " a infligé " + degat + " points de dégat à votre pokemon.");
						Poke_Combattant.HP-=degat;
						System.out.println("Il lui reste " + Poke_Combattant.HP + " points de vie.");
						if (Poke_Combattant.HP<=0) {
							Poke_Combattant.Deviens_poss();
							team.remove(Poke_Combattant);
							if (!(team.isEmpty())) {
								Poke_Combattant = Univers.Choix_Combattant();
							}
						}
					}
			}
		
		if (Poke_Sauvage.HP<=0) {
			System.out.println(Poke_Sauvage.name + " est KO. Félicitations! ");
			Poke_Sauvage.HP=Poke_Sauvage.HPMax;Poke_Sauvage.Deviens_poss();
				if (team.size()<LimSizeDraft) {Poke_Sauvage.Deviens_utilisable();}
			}
		}
		
		//Arrivée au centre de soin
		if (position.equals(CoordCS)) {
			if (LimCompteurSoins==CompteurSoins && LimCompteurDraft==CompteurDraft) {
				break;
			}
			if (LimCompteurSoins==CompteurSoins && LimCompteurDraft>CompteurDraft) {
				Scanner choix = new Scanner(System.in);
				System.out.print("Entrer : 0 pour changer votre équipe | 1 pour ne rien faire");  
			    int c = choix.nextInt();
			    while (!(c >= 0 && c <=1)) {
			    	System.out.println("Choix invalide. Veuillez réessayer .");
			    	choix = new Scanner(System.in);
			    	System.out.print("Entrer : 0 pour changer votre équipe | 1 pour ne rien faire");
					c = choix.nextInt();}
				if (c==0) {team=Univers.Choix_equipe (LimSizeDraft,team);CompteurDraft+=1;}
				    
			}
			if (LimCompteurDraft==CompteurDraft && LimCompteurSoins>CompteurSoins) {
				Scanner choix = new Scanner(System.in);
				System.out.print("Entrer : 0 pour soigner vos pokemons | 1 pour ne rien faire");  
			    int c = choix.nextInt();
			    while (!(c >= 0 && c <=1)) {
			    	System.out.println("Choix invalide. Veuillez réessayer.");
			    	choix = new Scanner(System.in);
					System.out.print("Entrer : 0 pour soigner vos pokemons | 1 pour ne rien faire");
					c = choix.nextInt();}
			    if (c==0) {Univers.Soin ();CompteurSoins+=1;}
			}
				
			if (LimCompteurDraft>CompteurDraft && LimCompteurSoins>CompteurSoins) {
				Scanner choix = new Scanner(System.in);
				System.out.print("Entrer : 0 pour soigner vos pokemons | 1 pour changer votre équipe | 2 pour ne rien faire");  
				int c = choix.nextInt();
				while (!(c >= 0 && c <=2)) {
					System.out.println("Choix invalide. Veuillez réessayer.");
					choix = new Scanner(System.in);
					System.out.print("Entrer : 0 pour soigner vos pokemons | 1 pour changer votre équipe | 2 pour ne rien faire");
					c = choix.nextInt();}
				if (c==0) {Univers.Soin ();CompteurSoins+=1;}
				if (c==1) {team=Univers.Choix_equipe (LimSizeDraft,team);CompteurDraft+=1;}
				
			}
			}
		}
	

	if (team.isEmpty()) {System.out.println("GAME OVER");}
	else {System.out.println("Vous avez gagné qui l'eu cru !!!");}
  

    }
}