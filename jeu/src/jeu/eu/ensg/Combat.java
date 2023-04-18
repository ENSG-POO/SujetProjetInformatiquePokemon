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
	
	public static double testEfficacite(Pokemon att,Pokemon def) {
		Type deft = def.getType();
		Type attt = att.getType();
		Double Coeff = Double.parseDouble(attt.getdata(deft));
		return Coeff;
	}
	
	
	public void assault(Attaque atk,Pokemon att,Pokemon def) {
		int puissance = atk.getPuissance();
		boolean spe = atk.isSpe();
		double deg = 0.0;
		if (spe == true) {
			deg = ((((2*att.getStats().getLvl())/5)+2*puissance*att.getStats().getAttack()/def.getStats().getDefense())/50)+2;
		}
		else {
			deg = ((((2*att.getStats().getLvl())/5)+2*puissance*att.getStats().getSpAtk()/def.getStats().getSpDef())/50)+2;
		}
		double Coeff = testEfficacite(att,def);
		deg = deg * Coeff;
		int degat = (int)deg;
		def.setHP(def.getHP()-degat);
	}
	
	public void fuir() {
		setOver(true);
	}
}
