package jeu.eu.ensg;

public class attaque {
	private int id;
	private String name;
	private String type;
private String classe;
private int puissance;
private int precision ;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getClasse() {
	return classe;
}

public void setClasse(String classe) {
	this.classe = classe;
}

public int getPuissance() {
	return puissance;
}

public void setPuissance(int puissance) {
	this.puissance = puissance;
}

public int getPrecision() {
	return precision;
}

public void setPrecision(int precision) {
	this.precision = precision;
}

public attaque(int id, String name, String type, String classe, int puissance, int precision) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.classe = classe;
	this.puissance = puissance;
	this.precision = precision;
}

@Override
public String toString() {
	return "Attaque [id=" + id + ", name=" + name + ", type=" + type + ", Classe=" + classe + ", puissance="
			+ puissance + ",precision=" + precision ;
}

	

}
