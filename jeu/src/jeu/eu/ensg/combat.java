package jeu.eu.ensg;

import java.util.Random;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class combat {

	public static void round(Pokemon a, Pokemon b) throws Exception {
		double degat;
		double puissance;
		int idatt;
		double degatfinal;
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
			degatfinal = degat * ty.gettypes(myMap.get(a.getType1())).faiblesse(idatt);
		} else {
			int degafinal = 0;
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
