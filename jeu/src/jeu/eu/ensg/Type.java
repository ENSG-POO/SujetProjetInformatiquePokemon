package jeu.eu.ensg;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * 
 * @author Test
 *
 */
public class Type {
	
	private String nom;

	public Type(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Type " + this.nom;
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


	public String getdata(Type b) {
		
		String[][] data = CSVReader.readCsvFile("./data/tableau-type.csv", ","); // ouverture du fichier types.csv en tableau
		return data[this.NumType()][b.NumType()]; // retourne le coefficient multiplicateur entre deux types
		
	}
}