package jeu.eu.ensg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Combat {
	
	private Pokemon PJ;
	private Pokemon PS;
	private boolean isOver;

	public Combat(Pokemon pJ, Pokemon pS, boolean isOver) {
		super();
		PJ = pJ;
		PS = pS;
		this.isOver = isOver;
	}
	

	public Pokemon getPJ() {
		return PJ;
	}
	public void setPJ(Pokemon pJ) {
		PJ = pJ;
	}
	public Pokemon getPS() {
		return PS;
	}
	public void setPS(Pokemon pS) {
		PS = pS;
	}
	public boolean isOver() {
		return isOver;
	}
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	
	public void swap(Pokemon n) {
		setPJ(n);
	}
	
	public static double testEfficacite(Attaque att,Pokemon def) {
		Type deft = def.getType();
		Type attt = att.getType();
		Double Coeff = Double.parseDouble(attt.getdata(deft));
		return Coeff;
	}
	
	
	public void assault(Attaque atkPerso, Attaque atkOrdi, Pokemon pokPerso,Pokemon pokSauv) {
		int puissance = atkPerso.getPuissance();
		boolean spe = atkPerso.isSpe();
		double deg = 0.0;
		
		int puissance2 = atkOrdi.getPuissance();
		boolean spe2 = atkOrdi.isSpe();
		double deg2 = 0.0;
		
		// attaque du joueur
		if (spe == false) {
			deg = ((((0.4*pokPerso.getStats().getLvl() + 2)* pokPerso.getStats().getAttack()*puissance)/(50*pokSauv.getStats().getDefense())) + 2 ); // *CE
			//deg = ((((2*att.getStats().getLvl())/5)+2*puissance*att.getStats().getAttack()/def.getStats().getDefense())/50)+2;
		}
		else {
			deg = ((((0.4*pokPerso.getStats().getLvl() + 2)* pokPerso.getStats().getSpAtk()*puissance)/(50*pokSauv.getStats().getSpDef())) + 2 ); // *CE
			//deg = ((((2*att.getStats().getLvl())/5)+2*puissance*att.getStats().getSpAtk()/def.getStats().getSpDef())/50)+2;
		}
		double Coeff = testEfficacite(atkPerso,pokSauv);
		deg = deg * Coeff;
		if (pokPerso.getType()==atkPerso.getType()) {
			deg = deg*1.5;
		}
		int degat = (int)deg;
		pokSauv.setHP(pokSauv.getHP()-degat);
		
		//attaque de l'ordi
		if (pokSauv.getHP()!= 0) {
			if (spe2 == false) {
				deg2 = ((((0.4*pokSauv.getStats().getLvl() + 2)* pokSauv.getStats().getAttack()*puissance2)/(50*pokPerso.getStats().getDefense())) + 2 ); // *CE
				//deg2 = ((((2*att.getStats().getLvl())/5)+2*puissance2*att.getStats().getAttack()/def.getStats().getDefense())/50)+2;
			}
			else {
				deg2 = ((((0.4*pokSauv.getStats().getLvl() + 2)* pokSauv.getStats().getSpAtk()*puissance2)/(50*pokPerso.getStats().getSpDef())) + 2 ); // *CE
				//deg2 = ((((2*att.getStats().getLvl())/5)+2*puissance2*att.getStats().getSpAtk()/def.getStats().getSpDef())/50)+2;
			}
			double Coeff2 = testEfficacite(atkOrdi,pokPerso);
			deg2 = deg2 * Coeff2;
			if (pokSauv.getType()==atkOrdi.getType()) {
				deg = deg*1.5;
			}
			int degat2 = (int)deg2;
			pokPerso.setHP(pokPerso.getHP()-degat2);
		}
	}
	
	ArrayList <Pokemon> L = new ArrayList<Pokemon>();
	public void jouer(Pokemon pokPerso, Pokemon pokSauv, ArrayList<Pokemon> L) {
		while (!(isOver) || !(L.isEmpty()) || pokSauv.getHP()==0 ) {
			// pour le pokémon sauvage
			List<Attaque> listeAttSauv = pokSauv.getListAtck();
			Random rand = new Random(); 
			int choixAtt = rand.nextInt(2);
			
			//pour le pokémon du dresseur			
			List<Attaque> listeAttPok = pokPerso.getListAtck();
			String attaqueUn = listeAttPok.get(0).getNom();
			String attaqueDeux = listeAttPok.get(1).getNom();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez choisir une attaque entre" + attaqueUn + " et " + attaqueDeux + " \n ou Taper 'CHANGER' si vous voulez changer de pokémon");
			String str = sc.nextLine();
			System.out.println("Vous avez saisi : " + str);
			
			//action durant le tour
			if (str== attaqueUn) {
				assault(listeAttPok.get(0), listeAttSauv.get(choixAtt), pokPerso, pokSauv);
			}
			else if (str == "CHANGER") {
				int[][] nb = new int[5][10];
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Vos autres pokémons sont: " + L + "\n" + nb + " \n Taper le NOMBRE correspondant à la position de votre nouveau pokémon " );
				int nbr = sc2.nextInt(); // récupération de la position du nouveau pokémon dans la liste de pokémon du joueur
				jouer(L.get(nbr), pokSauv, L);
			}
			else {
				assault(listeAttPok.get(1), listeAttSauv.get(choixAtt), pokPerso, pokSauv);
			}
			
		}
		
		if (pokSauv.getHP()==0) {
			System.out.println("Bravo, vous avez capturé un nouveau pokémon");
			L.add(pokSauv);
		}
		else if (L.isEmpty()) {
			System.out.println("Game over, vous n'avez plus de pokémon en état de combattre.");
		}
		else {
			System.out.println("Vous avez fuit le combat");
		}
	}
	
	public void fuir() {
		setOver(true);
	}
}
