package jeu.eu.ensg;

import java.util.Objects;

public class Statistiques {
	private Integer lvl; //niveau du pokemon
	private Integer xpMax; //correspond au nombre de point d'expérience maximal à atteindre avant de changer de niveau
	private Integer hpMax; //correspond au maximun de points de vie
	private Integer attack; //correspont au nombre de point d'attaque 
	private Integer defense; //correspont au nombre de point de défense
	private Integer spAtk; //correspont au nombre de point d'attaque pour les attaques spéciale
	private Integer spDef; //correspont au nombre de point de défense face aux attaques spéciales 
	private Integer speed; //correspond aux points de vitesse
	private Boolean legendary; //indique si le pokémon est légendaire ou non
	
	public Statistiques(Integer hpMax,Integer attack,Integer defense,Integer spAtk, Integer spDef, Integer speed, Boolean legendary, Integer total) {
		this.lvl=1; //toujour initialisé à 1, le viveau pourra être modifié grâce à changeLvl(bool) lorsque nécessaire
		this.xpMax=1; // vaudra toujour Math.pox(lvl,3)
		Integer t = 0; 
		this.hpMax=hpMax;
		t=t+hpMax;
		this.attack=attack;
		t=t+attack;
		this.defense=defense;
		t=t+defense;
		this.spAtk=spAtk;
		t=t+spAtk;
		this.spDef=spDef;
		t=t+spDef;
		this.speed=speed;
		t=t+speed;
		this.legendary=legendary;
	}
	
	public Statistiques(String[][] table, Integer ligne) {
		this.lvl=1; //toujour initialisé à 1, le viveau pourra être modifié grâce à changeLvl(bool) lorsque nécessaire
		this.xpMax=1; // vaudra toujour Math.pox(lvl,3)
		this.hpMax=Integer.parseInt(table[ligne][5]);
		this.attack=Integer.parseInt(table[ligne][6]);
		this.defense=Integer.parseInt(table[ligne][7]);
		this.spAtk=Integer.parseInt(table[ligne][8]);
		this.spDef=Integer.parseInt(table[ligne][9]);
		this.speed=Integer.parseInt(table[ligne][10]);
		this.legendary=Boolean.valueOf(table[ligne][12].toLowerCase());
	}
	@Override
	public String toString() {
		return "Statistiques : [lvl=" + lvl + ", xpMax=" + xpMax + ", hpMax=" + hpMax + ", attack=" + attack
				+ ", defense=" + defense + ", spAtk=" + spAtk + ", spDef=" + spDef + ", speed=" + speed + ", legendary="
				+ "Legendary : " + legendary + ", total=" + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(attack, defense, hpMax, legendary, lvl, spAtk, spDef, speed, xpMax);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statistiques other = (Statistiques) obj;
		return Objects.equals(attack, other.attack) && Objects.equals(defense, other.defense)
				&& Objects.equals(hpMax, other.hpMax) && Objects.equals(legendary, other.legendary)
				&& Objects.equals(lvl, other.lvl) && Objects.equals(spAtk, other.spAtk)
				&& Objects.equals(spDef, other.spDef) && Objects.equals(speed, other.speed)
				&& Objects.equals(xpMax, other.xpMax);
	}

	public Integer getLvl() {
		return this.lvl;
	}
	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}
	public Integer getXpMax() {
		return this.xpMax;
	}
	public void setXpMax(Integer xPMax) {
		this.xpMax = xPMax;
	}
	public Integer getHpMax() {
		return this.hpMax;
	}
	public void setHpMax(Integer hPMax) {
		this.hpMax = hPMax;
	}
	public Integer getAttack() {
		return this.attack;
	}
	public void setAttack(Integer attack) {
		this.attack = attack;
	}
	public Integer getDefense() {
		return this.defense;
	}
	public void setDefense(Integer defense) {
		this.defense = defense;
	}
	public Integer getSpAtk() {
		return this.spAtk;
	}
	public void setSpAtk(Integer spAtk) {
		this.spAtk = spAtk;
	}
	public Integer getSpDef() {
		return this.spDef;
	}
	public void setSpDef(Integer spDef) {
		this.spDef = spDef;
	}
	public Integer getSpeed() {
		return this.speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public Boolean getLegendary() {
		return this.legendary;
	}
	public void setLegendary(Boolean legendary) {
		this.legendary = legendary;
	}
	
	public void changeLvl(Boolean bool) {
		if (bool) { //bool indique si les statistiques du pokemon doivent être mises à jour
		this.setLvl(this.getLvl()+1);
		this.setXpMax((int) Math.pow(this.getLvl(),3));
		this.setHpMax((int) Math.floor(this.getHpMax()*1.5));
		this.setAttack((int) Math.floor(this.getAttack()*1.5));
		this.setDefense((int) Math.floor(this.getDefense()*1.5));
		this.setSpAtk((int) Math.floor(this.getSpAtk()*1.5));
		this.setSpDef((int) Math.floor(this.getSpDef()*1.5));
		this.setSpeed((int) Math.floor(this.getSpeed()*1.5)); 
		//les points de compétense sont tous augmentés de manière proportionelle pour que les pokémons gardent leurs spécificités		
		}	
	}	
}