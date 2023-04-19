package jeu.eu.ensg;

public class Attaque {
	
	private String nom;
	private Type type;
	private int puissance;
	private boolean spe;

	public Attaque(String nom, Type type, int puissance,boolean spe) {
		this.nom = nom;
		this.type = type;
		this.puissance = puissance;
		this.spe = spe;
	}
	
	public Attaque(String[][] attaquesTable, int ligne) {
		this.nom=attaquesTable[ligne][1];
		this.type = new Type(attaquesTable[ligne][2]);
		this.puissance = Integer.parseInt(attaquesTable[ligne][6]);
		this.spe = attaquesTable[ligne][3].equals("Special");
	}

	@Override
	public String toString() {
		String str=new String();
		if(spe) {
			str="Special";
		}
		else {
			str="Physical";
		}
		return "["+this.nom + ", " + type + "," + puissance + ", " + str + "]";
	}

	public String getNom() {
		return nom;
		
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}


	public boolean isSpe() {
		return spe;
	}

	public void setSpe(boolean spe) {
		this.spe = spe;
	}
}
