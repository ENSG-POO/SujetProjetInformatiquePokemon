package jeu.eu.ensg;

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
	private Integer total; // somme des points de competence, interviendra dans l'équilibrage des combats
	
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
		this.total=total;
		try {
			if(t!=this.total) {
				throw new IllegalArgumentException("La valeur de total doit valoir la somme des paramètres hpMax, attack, defense, spAtk, spDef et speed");
			}
			System.out.println("La somme vaut" + t);
		}
		catch  (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
//ici l'intéret de la variable t et de l'exception levée en cas de non égalité avec total permet surtout de détecter une erreur dans l'importation des statistiques du pokémon depuis le CSV fourni
	}
	
	public Statistiques(String[][] table, Integer ligne) {
		//str=str.substring(1, str.length() - 1);
		//String[] stats = str.split(",");
		this.lvl=1; //toujour initialisé à 1, le viveau pourra être modifié grâce à changeLvl(bool) lorsque nécessaire
		this.xpMax=1; // vaudra toujour Math.pox(lvl,3)
		Integer t = 0; 
		this.hpMax=Integer.parseInt(table[ligne][5]);
		t=t+hpMax;
		this.attack=Integer.parseInt(table[ligne][6]);
		t=t+attack;
		this.defense=Integer.parseInt(table[ligne][7]);
		t=t+defense;
		this.spAtk=Integer.parseInt(table[ligne][8]);
		t=t+spAtk;
		this.spDef=Integer.parseInt(table[ligne][9]);
		t=t+spDef;
		this.speed=Integer.parseInt(table[ligne][10]);
		t=t+speed;
		this.legendary=Boolean.valueOf(table[ligne][12].toLowerCase());
		this.total=Integer.parseInt(table[ligne][4]);
		/*try {
			if(t!=this.total) {
				throw new IllegalArgumentException("La valeur de total doit valoir la somme des paramètres hpMax, attack, defense, spAtk, spDef et speed");
			}
			System.out.println("La somme des points de compétence vaut" + t);
		}
		catch  (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}*/
//ici l'intéret de la variable t et de l'exception levée en cas de non égalité avec total permet surtout de détecter une erreur dans l'importation des statistiques du pokémon depuis le CSV fourni
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
	public Integer getTotal() {
		return this.total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public void changeLvl(Boolean bool) {
		if (bool) {
		this.setLvl(this.getLvl()+1);
		this.setXpMax((int) Math.pow(this.getLvl(),3));
		this.setHpMax((int) Math.floor(this.getHpMax()*1.5));
		this.setAttack((int) Math.floor(this.getAttack()*1.5));
		this.setDefense((int) Math.floor(this.getDefense()*1.5));
		this.setSpAtk((int) Math.floor(this.getSpAtk()*1.5));
		this.setSpDef((int) Math.floor(this.getSpDef()*1.5));
		this.setSpeed((int) Math.floor(this.getSpeed()*1.5)); //les points de compétense sont tous augmentés de manière proportionelle pour que les pokémons gardent leurs spécificités
		this.setTotal(this.hpMax + this.attack + this.defense +this.spAtk + this.spDef + this.speed);
		}	
	}
	
	
	
}
