package jeu.eu.ensg;

public class Vie_temporaire {

	private int id;
	private String name;
	private String type1;
	private String type2;
	private int total;
	private int hp;
	private int attack;
	private int defense;
	private int sp_atk;
	private int sp_def;
	private int speed;
	private int generation;
	private String legend;

	public Vie_temporaire(int id, String name, String type1, String type2, int total, int hp, int attack, int defense,
			int sp_atk, int sp_def, int speed, int generation, String legend) {
		this.id = id;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.total = total;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.sp_atk = sp_atk;
		this.sp_def = sp_def;
		this.speed = speed;
		this.generation = generation;
		this.legend = legend;
	}

	@Override
	public String toString() {
		return "Vie_temporaire [id=" + id + ", name=" + name + ", type1=" + type1 + ", type2=" + type2 + ", total="
				+ total + ", hp=" + hp + ", attack=" + attack + ", defense=" + defense + ", sp_atk=" + sp_atk
				+ ", sp_def=" + sp_def + ", speed=" + speed + ", generation=" + generation + ", legend=" + legend + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
