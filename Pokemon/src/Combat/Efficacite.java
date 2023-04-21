package Combat;

import Type.Acier;
import Type.Combat;
import Type.Dragon;
import Type.Eau;
import Type.Electrique;
import Type.Fee;
import Type.Feu;
import Type.Glace;
import Type.Insecte;
import Type.Normal;
import Type.Plante;
import Type.Poison;
import Type.Psy;
import Type.Roche;
import Type.Sol;
import Type.Spectre;
import Type.Tenebres;
import Type.Vol;

public class Efficacite {
	
	public static String[] Efficace(String type) {
		if (type.equals("Steel")) {
			return Acier.Efficace;
		}
		if (type.equals("Fighting")) {
			return Combat.Efficace;
		}
		if (type.equals("Dragon")) {
			return Dragon.Efficace;
		}
		if (type.equals("Water")) {
			return Eau.Efficace;
		}
		if (type.equals("Electric")) {
			return Electrique.Efficace;
		}
		if (type.equals("Fairy")) {
			return Fee.Efficace;
		}
		if (type.equals("Fire")) {
			return Feu.Efficace;
		}
		if (type.equals("Ice")) {
			return Glace.Efficace;
		}
		if (type.equals("Bug")) {
			return Insecte.Efficace;
		}
		if (type.equals("Normal")) {
			return Normal.Efficace;
		}
		if (type.equals("Grass")) {
			return Plante.Efficace;
		}
		if (type.equals("Poison")) {
			return Poison.Efficace;
		}
		if (type.equals("Psychic")) {
			return Psy.Efficace;
		}
		if (type.equals("Rock")) {
			return Roche.Efficace;
		}
		if (type.equals("Ground")) {
			return Sol.Efficace;
		}
		if (type.equals("Ghost")) {
			return Spectre.Efficace;
		}
		if (type.equals("Dark")) {
			return Tenebres.Efficace;
		}
		else {
			return Vol.Efficace;
		}
		
	}
	
	public static String[] PasEfficace(String type) {
		if (type.equals("Steel")) {
			return Acier.PasEfficace;
		}
		if (type.equals("Fighting")) {
			return Combat.PasEfficace;
		}
		if (type.equals("Dragon")) {
			return Dragon.PasEfficace;
		}
		if (type.equals("Water")) {
			return Eau.PasEfficace;
		}
		if (type.equals("Electric")) {
			return Electrique.PasEfficace;
		}
		if (type.equals("Fairy")) {
			return Fee.PasEfficace;
		}
		if (type.equals("Fire")) {
			return Feu.PasEfficace;
		}
		if (type.equals("Ice")) {
			return Glace.PasEfficace;
		}
		if (type.equals("Bug")) {
			return Insecte.PasEfficace;
		}
		if (type.equals("Normal")) {
			return Normal.PasEfficace;
		}
		if (type.equals("Grass")) {
			return Plante.PasEfficace;
		}
		if (type.equals("Poison")) {
			return Poison.PasEfficace;
		}
		if (type.equals("Psychic")) {
			return Psy.PasEfficace;
		}
		if (type.equals("Rock")) {
			return Roche.PasEfficace;
		}
		if (type.equals("Ground")) {
			return Sol.PasEfficace;
		}
		if (type.equals("Ghost")) {
			return Spectre.PasEfficace;
		}
		if (type.equals("Dark")) {
			return Tenebres.PasEfficace;
		}
		else {
			return Vol.PasEfficace;
		}
		
	}

	public static String[] Neutre(String type) {
		if (type.equals("Steel")) {
			return Acier.Neutre;
		}
		
		if (type.equals("Fighting")) {
			return Combat.Neutre;
		}
		if (type.equals("Dragon")) {
			return Dragon.Neutre;
		}
		if (type.equals("Water")) {
			return Eau.Neutre;
		}
		if (type.equals("Electric")) {
			return Electrique.Neutre;
		}
		if (type.equals("Fairy")) {
			return Fee.Neutre;
		}
		if (type.equals("Fire")) {
			return Feu.Neutre;
		}
		if (type.equals("Ice")) {
			return Glace.Neutre;
		}
		if (type.equals("Bug")) {
			return Insecte.Neutre;
		}
		if (type.equals("Normal")) {
			return Normal.Neutre;
		}
		if (type.equals("Grass")) {
			return Plante.Neutre;
		}
		if (type.equals("Poison")) {
			return Poison.Neutre;
		}
		if (type.equals("Psychic")) {
			return Psy.Neutre;
		}
		if (type.equals("Rock")) {
			return Roche.Neutre;
		}
		if (type.equals("Ground")) {
			return Sol.Neutre;
		}
		if (type.equals("Ghost")) {
			return Spectre.Neutre;
		}
		if (type.equals("Dark")) {
			return Tenebres.Neutre;
		}
		else {
			return Vol.Neutre;
		}
		
	}
	
	public static String[] Inefficace(String type) {
		if (type.equals("Steel")) {
			return Acier.Inefficace;
		}
		if (type.equals("Fighting")) {
			return Combat.Inefficace;
		}
		if (type.equals("Dragon")) {
			return Dragon.Inefficace;
		}
		if (type.equals("Water")) {
			return Eau.Inefficace;
		}
		if (type.equals("Electric")) {
			return Electrique.Inefficace;
		}
		if (type.equals("Fairy")) {
			return Fee.Inefficace;
		}
		if (type.equals("Fire")) {
			return Feu.Inefficace;
		}
		if (type.equals("Ice")) {
			return Glace.Inefficace;
		}
		if (type.equals("Bug")) {
			return Insecte.Inefficace;
		}
		if (type.equals("Normal")) {
			return Normal.Inefficace;
		}
		if (type.equals("Grass")) {
			return Plante.Inefficace;
		}
		if (type.equals("Poison")) {
			return Poison.Inefficace;
		}
		if (type.equals("Psychic")) {
			return Psy.Inefficace;
		}
		if (type.equals("Rock")) {
			return Roche.Inefficace;
		}
		if (type.equals("Ground")) {
			return Sol.Inefficace;
		}
		if (type.equals("Ghost")) {
			return Spectre.Inefficace;
		}
		if (type.equals("Dark")) {
			return Tenebres.Inefficace;
		}
		else {
			return Vol.Inefficace;
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(Efficace("Poison")[0]);
	}
}
