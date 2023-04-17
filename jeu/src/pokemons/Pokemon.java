package pokemons;

import java.util.List;

public class Pokemon {
	// attributs
	public String name;
	public Type type;
	public int pv;
	public int attack;
	public int defense;
	public int speed;
	
	// constructeurs
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
	public int getAttack() { return this.attack;}
		
	//methode
	
	/* Methode qui verifie les affinites
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
	}*/
	
	// methode pour attaque
	public boolean isStab(Attaque Attaque) {
		if (this.type.nomT.equals(Attaque.getTypeAttaque())){
			return true;
		}
		return false;
	}
	
	public void attaquer(Pokemon other, Attaque fight) {
		// cas d'un combat neutre
			if (fight.getNomAttaque().equals("Neutre")) {
				// cas ou la defense absorbe une partie de l'attaque
				if(this.attack > other.defense) {
					int reste = this.attack - other.defense;
					// cast en int car dans pokemon les points de vies sont des entiers.
					other.pv = (int) other.getPv() - reste;
				}
			}
			else {
				
				double coefMultiplicateur = fight.coefMulti(this.type, other.getType());
				//System.out.println("Coef multi :" + coefMultiplicateur);
				
				//System.out.println("Resultat de mon stab: "+ isStab(fight));
				// cas ou l'attaque est du meme type que le pokemon qui attaque
				if(isStab(fight)) {
					double stab = 1.5 * coefMultiplicateur * this.attack;
					System.out.println("Attack * coef * 1.5 = " + stab);
					if (stab > other.defense) {
						double reste = stab - other.defense;
						other.pv = (int) (other.getPv() - reste);
					}	
				}
				else {
					//System.out.println(this.attack+" point d'attaque et " + other.defense+" point de defense");
					double attackBoost = coefMultiplicateur * this.attack;
					//System.out.println("Attack * coef" + attackBoost);
					if(attackBoost > other.defense) {
						double reste = attackBoost - other.defense;
						//System.out.println(reste);
						other.pv = (int) (other.getPv() - reste);
					}
				}
			}
		}
	


	
	
	@Override
	public String toString() {
		return name + ": type " + type + " - "+ pv + " PV - Att " + attack + " - Def " + defense + " - Sp " + speed;
	}

}
