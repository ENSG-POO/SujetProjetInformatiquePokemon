package jeu.eu.ensg;


public class Combat {
	
	private Pokemon PJ;
	private Pokemon PS;
	private boolean isOver;

	public Combat(Pokemon pJ, Pokemon pS, boolean isOver) {
		super();
		PJ = pJ;
		PS = pS;
		this.isOver = isOver;
	}
	

	public Pokemon getPJ() {
		return PJ;
	}
	public void setPJ(Pokemon pJ) {
		PJ = pJ;
	}
	public Pokemon getPS() {
		return PS;
	}
	public void setPS(Pokemon pS) {
		PS = pS;
	}
	public boolean isOver() {
		return isOver;
	}
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	
	public void swap(Pokemon n) {
		setPJ(n);
	}
	
	public static double testEfficacite(Attaque att,Pokemon def) {
		Type deft = def.getType();
		Type attt = att.getType();
		Double Coeff = Double.parseDouble(attt.getdata(deft));
		return Coeff;
	}
	
	
	public void assault(Attaque atkPerso, Attaque atkOrdi, Pokemon pokPerso,Pokemon pokSauv) {
		int puissance = atkPerso.getPuissance();
		boolean spe = atkPerso.isSpe();
		double deg = 0.0;
		
		int puissance2 = atkOrdi.getPuissance();
		boolean spe2 = atkOrdi.isSpe();
		double deg2 = 0.0;
		
		// attaque du joueur
		if (spe == false) {
			deg = ((((0.4*pokPerso.getStats().getLvl() + 2)* pokPerso.getStats().getAttack()*puissance)/(50*pokSauv.getStats().getDefense())) + 2 ); // *CE
			//deg = ((((2*att.getStats().getLvl())/5)+2*puissance*att.getStats().getAttack()/def.getStats().getDefense())/50)+2;
		}
		else {
			deg = ((((0.4*pokPerso.getStats().getLvl() + 2)* pokPerso.getStats().getSpAtk()*puissance)/(50*pokSauv.getStats().getSpDef())) + 2 ); // *CE
			//deg = ((((2*att.getStats().getLvl())/5)+2*puissance*att.getStats().getSpAtk()/def.getStats().getSpDef())/50)+2;
		}
		double Coeff = testEfficacite(atkPerso,pokSauv);
		deg = deg * Coeff;
		if (pokPerso.getType()==atkPerso.getType()) {
			deg = deg*1.5;
		}
		int degat = (int)deg;
		pokSauv.setHP(pokSauv.getHP()-degat);
		
		//attaque de l'ordi
		if (pokSauv.getHP()!= 0) {
			if (spe2 == false) {
				deg2 = ((((0.4*pokSauv.getStats().getLvl() + 2)* pokSauv.getStats().getAttack()*puissance2)/(50*pokPerso.getStats().getDefense())) + 2 ); // *CE
				//deg2 = ((((2*att.getStats().getLvl())/5)+2*puissance2*att.getStats().getAttack()/def.getStats().getDefense())/50)+2;
			}
			else {
				deg2 = ((((0.4*pokSauv.getStats().getLvl() + 2)* pokSauv.getStats().getSpAtk()*puissance2)/(50*pokPerso.getStats().getSpDef())) + 2 ); // *CE
				//deg2 = ((((2*att.getStats().getLvl())/5)+2*puissance2*att.getStats().getSpAtk()/def.getStats().getSpDef())/50)+2;
			}
			double Coeff2 = testEfficacite(atkOrdi,pokPerso);
			deg2 = deg2 * Coeff2;
			if (pokSauv.getType()==atkOrdi.getType()) {
				deg = deg*1.5;
			}
			int degat2 = (int)deg2;
			pokPerso.setHP(pokPerso.getHP()-degat2);
		}
	}
	
	public void fuir() {
		setOver(true);
	}
}
