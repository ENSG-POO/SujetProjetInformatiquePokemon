package Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Affinite {
	// attributs
	public ArrayList<List<Double>> affinite;
	public ArrayList<String> associationAffinite;
	
	// constructeur
	public Affinite() {
		setAffinite();
		setAssociationAffinite();
	}
	
	// getter
	public ArrayList<List<Double>> getAffinite(){ return this.affinite;}
	public ArrayList<String> getAssociationAffinite(){ return this.associationAffinite;}
	
	//setter
	public void setAffinite() {
			this.affinite = new ArrayList<List<Double>>();
			List<Double> NormalValues = Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0);
			List<Double> FireValues = Arrays.asList(1.0, 0.5, 2.0, 0.5, 1.0, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 0.5, 0.5);
			List<Double> WaterValues = Arrays.asList(1.0, 0.5, 0.5, 2.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0);
			List<Double> GrassValues = Arrays.asList(1.0, 2.0, 0.5, 0.5, 0.5, 2.0, 1.0, 2.0, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
			List<Double> ElectricValues = Arrays.asList(1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0);
			List<Double> IceValues = Arrays.asList(1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0);
			List<Double> FightingValues = Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 0.5, 0.5, 1.0, 1.0, 0.5, 1.0, 2.0);
			List<Double> PoisonValues = Arrays.asList(1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 0.5, 0.5, 2.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5);
			List<Double> GroundValues = Arrays.asList(1.0, 1.0, 2.0, 2.0, 0.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0);
			List<Double> FlyingValues = Arrays.asList(1.0, 1.0, 1.0, 0.5, 2.0, 2.0, 0.5, 1.0, 0.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0);
			List<Double> PsychicValues = Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0);
			List<Double> BugValues = Arrays.asList(1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 0.5, 1.0, 0.5, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0);
			List<Double> RockValues = Arrays.asList(0.5, 0.5, 2.0, 2.0, 1.0, 1.0, 2.0, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0);
			List<Double> GhostValues = Arrays.asList(0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.5, 1.0, 1.0, 1.0, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0);
			List<Double> DragonValues = Arrays.asList(1.0, 0.5, 0.5, 0.5, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0);
			List<Double> DarkValues = Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.0, 2.0, 1.0, 0.5, 1.0, 0.5, 1.0, 2.0);
			List<Double> SteelValues = Arrays.asList(0.5, 2.0, 1.0, 0.5, 1.0, 0.5, 2.0, 0.0, 2.0, 0.5, 0.5, 0.5, 0.5, 1.0, 0.5, 1.0, 0.5, 0.5);
			List<Double> FairyValues = Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 0.0, 0.5, 2.0, 1.0);
			
			this.affinite.add(NormalValues);
			this.affinite.add(FireValues);
			this.affinite.add(WaterValues);
			this.affinite.add(GrassValues);
			this.affinite.add(ElectricValues);
			this.affinite.add(IceValues);
			this.affinite.add(FightingValues);
			this.affinite.add(PoisonValues);
			this.affinite.add(GroundValues);
			this.affinite.add(FlyingValues);
			this.affinite.add(PsychicValues);
			this.affinite.add(BugValues);
			this.affinite.add(RockValues);
			this.affinite.add(GhostValues);
			this.affinite.add(DragonValues);
			this.affinite.add(DarkValues);
			this.affinite.add(SteelValues);
			this.affinite.add(FairyValues);
	}
	
	public void setAssociationAffinite() {
			this.associationAffinite = new ArrayList<String>();
			// met dans l'ordre les types
			this.associationAffinite.add("Normal");
			this.associationAffinite.add("Fire");
			this.associationAffinite.add("Water");
			this.associationAffinite.add("Grass");
			this.associationAffinite.add("Electric");
			this.associationAffinite.add("Ice");
			this.associationAffinite.add("Fighting");
			this.associationAffinite.add("Poison");
			this.associationAffinite.add("Ground");
			this.associationAffinite.add("Flying");
			this.associationAffinite.add("Psychic");
			this.associationAffinite.add("Bug");
			this.associationAffinite.add("Rock");
			this.associationAffinite.add("Ghost");
			this.associationAffinite.add("Dragon");
			this.associationAffinite.add("Dark");
			this.associationAffinite.add("Steel");
			this.associationAffinite.add("Fairy");
	}
	
	// methode
	
	// donne un type et sort son index
	public int association(String nomType) {
		for (int i= 0; i<this.associationAffinite.size(); i++) {
			if (this.associationAffinite.get(i).equals(nomType)) {
				return i;
			}
		}
		return -1;
	}
	
	// donne un index et sort un type
	public String valeurIndex(int idx) {
		return this.associationAffinite.get(idx);
	}

	@Override
	public String toString() {
		for (int i=0; i<this.affinite.size(); i++) {
			System.out.println(this.associationAffinite.get(i));
			for (int j=0; j<this.affinite.get(i).size(); j++) {
				System.out.println(this.affinite.get(j).get(i));
			}
		}
		return "";
	}
}

