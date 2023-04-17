package jeu.eu.ensg;
import java.util.HashMap;

public class Type {
	
	private String nom;

	public Type(String nom) {
		super();
		this.nom = nom;
	}
	
	public int NumType() {
		HashMap<String,Double> NumType = new HashMap<String,Double>();
		NumType.put("Acier",0.0);
		NumType.put("Combat",1.0);
		NumType.put("Dragon",2.0);
		NumType.put("Eau",3.0);
		NumType.put("Feu",4.0);
		NumType.put("Electrik",5.0);
		NumType.put("Fee",6.0);
		NumType.put("Glace",7.0);
		NumType.put("Insecte",8.0);
		NumType.put("Normal",9.0);
		NumType.put("Plante",10.0);
		NumType.put("Poison",11.0);
		NumType.put("Psy",12.0);
		NumType.put("Roche",13.0);
		NumType.put("Sol",14.0);
		NumType.put("Spectre",15.0);
		NumType.put("tenebre",16.0);
		NumType.put("Vol",17.0);
		int nt = NumType.get(this.nom).intValue();
		return nt;
	}
}
