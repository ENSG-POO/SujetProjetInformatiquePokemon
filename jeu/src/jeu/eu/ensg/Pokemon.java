
package jeu.eu.ensg;

import java.util.Random;

public class Pokemon {
	private int id;
	private String name;
	private String type1;
	private String type2;
	private int total;
	private final int hpmax;
	private int hp;
	private int attack;
	private int defense;
	private int sp_atk;
	private int sp_def;
	private int speed;
	private int generation;
	private String legend;
	private boolean statut;
	private int attaqueID;
	private int attaqueID2;
	private int attaqueID3;
	private int attaqueID4;

	public Pokemon(int id, String name, String type1, String type2, int total, int hp, int attack, int defense,
			int sp_atk, int sp_def, int speed, int generation, String legend, int attaqueID) {
		this.hpmax = hp;
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
		this.statut = false;
		this.attaqueID = attaqueID;
		Random random = new Random();
		this.attaqueID2 = random.nextInt(103);
		this.attaqueID3 = random.nextInt(103);
		this.attaqueID4 = random.nextInt(103);
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", type1=" + type1 + ", type2=" + type2 + ", total=" + total
				+ ", hp=" + hp + ", attack=" + attack + ", defense=" + defense + ", sp_atk=" + sp_atk + ", sp_def="
				+ sp_def + ", speed=" + speed + ", generation=" + generation + ", legend=" + legend + "]";
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSp_atk() {
		return sp_atk;
	}

	public void setSp_atk(int sp_atk) {
		this.sp_atk = sp_atk;
	}

	public int getSp_def() {
		return sp_def;
	}

	public void setSp_def(int sp_def) {
		this.sp_def = sp_def;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

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

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAttaqueID() {
		return attaqueID;
	}

	public void setAttaqueID(int attaqueID) {
		this.attaqueID = attaqueID;
	}

	public int getHp() {
		return hp;
	}

	public int getHpmax() {
		return hpmax;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public int getAttaqueID2() {
		return attaqueID2;
	}

	public void setAttaqueID2(int attaqueID2) {
		this.attaqueID2 = attaqueID2;
	}

	public int getAttaqueID3() {
		return attaqueID3;
	}

	public void setAttaqueID3(int attaqueID3) {
		this.attaqueID3 = attaqueID3;
	}

	public int getAttaqueID4() {
		return attaqueID4;
	}

	public void setAttaqueID4(int attaqueID4) {
		this.attaqueID4 = attaqueID4;
	}

}
