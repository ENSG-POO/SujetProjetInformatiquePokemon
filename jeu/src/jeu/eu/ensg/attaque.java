package jeu.eu.ensg;

public class attaque {
	private int id;
	private type type;
	private String name;
	private int Degat;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public type getType() {
		return type;
	}
	public void setType(type type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDegat() {
		return Degat;
	}
	public void setDegat(int degat) {
		Degat = degat;
	}
	
	public attaque(int id, type type, String name, int degat) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		Degat = degat;
	}

}
