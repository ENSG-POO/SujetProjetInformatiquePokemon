package pokemons;

import java.util.List;

public class Pokemon {
	public String name;
	public Type type;
	public int pv;
	public int attack;
	public int defense;
	public int speed;
	
	//private List<Attaques> attaques;
	
	public Pokemon(String name, Type type) {
	this.name = name;
	this.type = type;
	}
	
	public Pokemon(String name, Type type, int pv, int attack, int defense, int speed) {
		this.name = name;
		this.type = type;
		this.pv = pv;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
	}
	
	
	// getter
		public Type getType() {return this.type;}
		public String getNom() {return this.name;}
		public int getPv() {return this.pv;}
		
		//methode
		
		// Methode qui verifie les affinites
		public boolean checkFaiblesse(Pokemon other) {
			String typeOther = (other.getType()).getNom();
			List<String> faiblesseLst = this.getType().getFaiblesse();
			for (int i = 0; i < faiblesseLst.size(); i++) {
				if (typeOther.equals(faiblesseLst.get(i))) {
					return true;
				}
			}
			return false;			
		}
		

		public boolean checkResistance(Pokemon other) {
			String typeOther = (other.getType()).getNom();
			List<String> resistanceLst = this.getType().getResistance();
			for (int i = 0; i < resistanceLst.size(); i++) {
				if (typeOther.equals(resistanceLst.get(i))) {
					return true;
				}
			}
			return false;			
		}
		
		public boolean checkInvulnerable(Pokemon other) {
			String typeOther = (other.getType()).getNom();
			List<String> invulnerableLst = this.getType().getInvulnerable();
			for (int i = 0; i < invulnerableLst.size(); i++) {
				if (typeOther.equals(invulnerableLst.get(i))) {
					return true;
				}
			}
			return false;			
		}
	

	
	
	
	
	@Override
	public String toString() {
		return name + ": type " + type + " - "+ pv + " PV - Att " + attack + " - Def " + defense + " - Sp " + speed;
	}

}
