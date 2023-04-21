package jeu.eu.ensg;

import java.util.Objects;

public class Attaque {
	
	//attribut
	private String nom;
	private Type type;
	private int puissance;
	private boolean spe;
	
	// constructeur de base depuis les attribut
	public Attaque(String nom, Type type, int puissance,boolean spe) {
		this.nom = nom;
		this.type = type;
		this.puissance = puissance;
		this.spe = spe;
	}
	

	//construction qui initialise des attaques à partir du fichier csv des attaques
	public Attaque(String[][] attaquesTable, int ligne) {
		this.nom=attaquesTable[ligne][1];
		this.type = new Type(attaquesTable[ligne][2]);
		this.puissance = Integer.parseInt(attaquesTable[ligne][6]);
		this.spe = attaquesTable[ligne][3].equals("Special");
	}

	// méthode qui décrit l'affichage visuel de l'attaque crée dans la console
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

	
	// accesseur de l'attribut nom
	public String getNom() {
		return nom;
		
	}

	// mutateur de l'attibut nom
	public void setNom(String nom) {
		this.nom = nom;
	}

	// accesseur de l'attribut type
	public Type getType() {
		return type;
	}

	// mutateur de l'attibut type
	public void setType(Type type) {
		this.type = type;
	}

	// accesseur de l'attribut puissance
	public int getPuissance() {
		return puissance;
	}

	// mutateur de l'attibut puisssance
	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}


	// accesseur de l'attribut spe
	public boolean isSpe() {
		return spe;
	}

	// mutateur de l'attibut spe
	public void setSpe(boolean spe) {
		this.spe = spe;
	}
}
