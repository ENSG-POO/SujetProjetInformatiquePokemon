package jeu.eu.ensg;
import java.util.HashMap;
import java.util.Objects;

public class Type {
	
	private String nom;

	public Type(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Type " + this.nom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		return Objects.equals(nom, other.nom);
	}

	public int NumType() {
		HashMap<String,Double> NumType = new HashMap<String,Double>();
		NumType.put("Steel",0.0);
		NumType.put("Fighting",1.0);
		NumType.put("Dragon",2.0);
		NumType.put("Water",3.0);
		NumType.put("Fire",4.0);
		NumType.put("Electric",5.0);
		NumType.put("Fairy",6.0);
		NumType.put("Ice",7.0);
		NumType.put("Bug",8.0);
		NumType.put("Normal",9.0);
		NumType.put("Grass",10.0);
		NumType.put("Poison",11.0);
		NumType.put("Psychic",12.0);
		NumType.put("Rock",13.0);
		NumType.put("Ground",14.0);
		NumType.put("Ghost",15.0);
		NumType.put("Dark",16.0);
		NumType.put("Flying",17.0);
		int nt = NumType.get(this.nom).intValue();
		return nt;
	}


	public String getdata(Type b) {		
		String[][] data = CSVReader.readCsvFile("./data/tableau-type.csv", ","); // ouverture du fichier types.csv en tableau
		return data[this.NumType()][b.NumType()]; // retourne le coefficient multiplicateur entre deux types
		

	}
}