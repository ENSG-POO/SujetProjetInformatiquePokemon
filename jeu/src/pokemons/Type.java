package pokemons;

import java.util.ArrayList;
import java.util.List;

public class Type {
	// attributs 
	public int indexAssociationAffinite;
	public String nomT;
	public Affinite aff;
	public List<String> faiblesse;
	public List<String> resistance;
	public List<String> invulnerable;
	
	// constructeur
	public Type(String nomType) {
		this.nomT = nomType;
		this.aff = new Affinite();
		this.indexAssociationAffinite = aff.association(nomType);
		setConfiguration();
		
	}
	
	// getter
	public List<String> getFaiblesse(){return this.faiblesse;}
	public List<String> getResistance(){return this.resistance;}
	public List<String> getInvulnerable(){return this.invulnerable;}
	public String getNom() {return this.nomT;}
	public String getAffinite() {return this.aff.toString();}
	

	// setter 
	public void setConfiguration() {
		this.faiblesse = new ArrayList<String>();
		this.resistance = new ArrayList<String>();
		this.invulnerable = new ArrayList<String>();
		// parcours le tableau d'affinite
		for (int i=0; i<this.aff.getAffinite().size(); i++) {
			// charge la liste d'invulnerable
			if (this.aff.getAffinite().get(this.indexAssociationAffinite).get(i) == 0.0) {
				this.invulnerable.add(this.aff.valeurIndex(i));
			}
			// charge la liste de resistance
			if (this.aff.getAffinite().get(this.indexAssociationAffinite).get(i) == 0.5) {
				this.resistance.add(this.aff.valeurIndex(i));
			}
			// charge la liste de faiblesse
			if (this.aff.getAffinite().get(this.indexAssociationAffinite).get(i)== 2.0) {
				this.faiblesse.add(this.aff.valeurIndex(i));
			}
		}
	}
	
	// ecriture
	@Override
	public String toString() {
		return ("Type du pokemon : "+ this.nomT + "\nSes faiblesses : "+ this.faiblesse + " \tSes resistances : "+ this.resistance + "\tSes invulnerabilite : "+ this.invulnerable);
		
	}
	

}
