package jeu.eu.ensg;

import java.util.Random;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class combat {
public static void combattotal (Pokemon a,Pokemon b) throws Exception {
	
	if (a.getSpeed()> b.getSpeed()) {
		while (a.getHp()> 0 || b.getHp()>0) {
			round(a,b);
			Pokemon c= a ;
			a = b;
			b =a ;
			
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	public static void round(Pokemon a, Pokemon b) {
		double degat;
		double puissance;
		int idatt;
		double degatfinal =0;
		type typea;
		PokeListe poke = new PokeListe();
		AttaqueList att = new AttaqueList();
		ListType ty = new ListType();
		Random random = new Random();
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		myMap.put("Normal", 0);
		myMap.put("Feu", 1);
		myMap.put("Eau", 2);
		myMap.put("Plante", 3);
		myMap.put("Electrik", 4);
		myMap.put("Glace", 5);
		myMap.put("Combat", 6);
		myMap.put("Poison", 7);
		myMap.put("Sol", 8);
		myMap.put("Vol", 9);
		myMap.put("Psy", 10);
		myMap.put("Insecte", 11);
		myMap.put("Roche", 12);
		myMap.put("Spectre", 13);
		myMap.put("Dragon", 14);
		myMap.put("Tenebres", 15);
		myMap.put("Acier", 16);

		idatt = a.getAttaqueID();
		puissance = att.getPuissance(idatt);

		int randomNumber = random.nextInt(101);
		if (randomNumber < att.getPrecision(idatt)) {
			if (att.getClass().equals("Physique")) {
				degat = puissance * (a.getAttack() / b.getDefense());
			} else {
				degat = puissance * (a.getSp_atk() / b.getSp_def());

			}
			degatfinal = degat *    ty.gettypes(myMap.get(att.getattaque(idatt).getType())).faiblesse(myMap.get(b.getType1()));
		} else {
			degatfinal = 0;
		}
		b.setHp((int) ((int) b.getHp() - degatfinal));

	}

	public static void ko(Pokemon a) {
		if (a.getHp() <= 0) {
			if (a.isStatut() == false) {
				a.setStatut(true);
				a.setHp(a.getHpmax());

			}

		}
	}
}
