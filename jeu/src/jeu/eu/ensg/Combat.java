package jeu.eu.ensg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jeu.eu.ensg.gui.FenetreCombat;

public class Combat {
	
	private Pokemon PJ;
	private Pokemon PS;
	private boolean isOver;
	private Trainer trainer;
	private ArrayList<Pokemon> LPS;

	public Combat(Pokemon pJ, Pokemon pS, boolean isOver,Trainer t,ArrayList<Pokemon> LPS) {
		super();
		PJ = pJ;
		PS = pS;
		this.isOver = isOver;
		this.trainer = t;
		this.LPS = LPS;
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
	
	
public void fuir() {
	this.setOver(true);
	System.out.println("Vous avez fuis");
}

public void changer(List<Pokemon> sac) {
	Pokemon ancien = this.getPJ();
	this.setPJ(sac.get(0));
	sac.add(ancien);
	System.out.println("Votre Pokemon à été changé par le plus haut dans votre sac et à été placé au point le plus bas du sac");
}

public void attaque_enemi() {
	Random rand = new Random(); 
	int choixAtt = rand.nextInt(2);
	if (choixAtt == 1) {
		Attaque att = this.getPS().getListAtck().get(0);
		int puissance = att.getPuissance();
		Type t = att.getType();
		Type t_enemi = this.getPJ().getType();
		int lvl = this.getPS().getStats().getLvl();
		int atk = this.getPS().getStats().getAttack();
		int def = this.getPJ().getStats().getDefense();
		Double deg = ((((0.4*lvl + 2)* atk * puissance)/(50*def)) + 2 );
		
		String eff = t.getdata(t_enemi);
		Double ef = Double.parseDouble(eff);
		int degat = (int) Math.round(ef*deg);

		this.getPJ().setHP(this.getPJ().getHP()-degat);
		System.out.println("L'ennemi utilise " + att.getNom());
		System.out.println("L'ennemi vous inflige " + Integer.toString(degat) + " PV");
	}
	else  {
		Attaque att = this.getPS().getListAtck().get(0);
		int puissance = att.getPuissance();
		Type t = att.getType();
		Type t_enemi = this.getPJ().getType();
		int lvl = this.getPS().getStats().getLvl();
		int atk_spe = this.getPS().getStats().getSpAtk();
		int def_spe = this.getPJ().getStats().getSpDef();
		Double deg = ((((0.4*lvl + 2)* atk_spe * puissance)/(50*def_spe)) + 2 );
		
		String eff = t.getdata(t_enemi);
		Double ef = Double.parseDouble(eff);
		int degat = (int) Math.round(ef*deg);

		this.getPJ().setHP(this.getPJ().getHP()-degat);
		System.out.println("L'ennemi utilise " + att.getNom());
		System.out.println("L'ennemi vous inflige " + Integer.toString(degat) + " PV");
	}
}

public void attaque() {
	Attaque att = this.getPJ().getListAtck().get(0);
	Type t = att.getType();
	Type t_enemi = this.getPS().getType();
	int puissance = att.getPuissance();
	int lvl = this.getPJ().getStats().getLvl();
	int atk = this.getPJ().getStats().getAttack();
	int def = this.getPS().getStats().getDefense();
	Double deg = ((((0.4*lvl + 2)* atk * puissance)/(50*def)) + 2 );

	String eff = t.getdata(t_enemi);
	Double ef = Double.parseDouble(eff);
	int degat = (int) Math.round(ef*deg);

	this.getPS().setHP(this.getPS().getHP()-degat);
	System.out.println("Vous utilisez " + att.getNom());
	System.out.println("Vous infligez " + Integer.toString(degat) + " PV");

}

public void attaque_spe() {
	Attaque att = this.getPJ().getListAtck().get(1);
	Type t = att.getType();
	Type t_enemi = this.getPS().getType();
	int puissance = att.getPuissance();
	int lvl = this.getPJ().getStats().getLvl();
	int atk_spe = this.getPJ().getStats().getSpAtk();
	int def_spe = this.getPS().getStats().getSpDef();
	Double deg = ((((0.4*lvl + 2)* atk_spe * puissance)/(50*def_spe)) + 2 );

	String eff = t.getdata(t_enemi);
	Double ef = Double.parseDouble(eff);
	int degat = (int) Math.round(ef*deg);

	this.getPS().setHP(this.getPS().getHP()-degat);
	System.out.println("Vous utilisez " + att.getNom());
	System.out.println("Vous infligez " + Integer.toString(degat) + " PV");


}

public void Heal() {
	ArrayList<Pokemon> Temp = trainer.getEquipe();
	for (int i=0; i<Temp.size();i++) {
		Temp.get(i).setHP(Temp.get(i).getStats().getHpMax());
	}
	trainer.setEquipe(Temp);
}







}