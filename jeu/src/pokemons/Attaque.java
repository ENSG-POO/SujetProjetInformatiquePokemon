package pokemons;

public class Attaque {
	// attributs 
	public String nomA;
	public Type type;
	
	// constructeurs
	public Attaque(String nomA, Type type) {
		this.nomA = nomA;
		this.type = type;
	}
	
	// getter
	public String getNomAttaque() { return this.nomA;}
	public String getTypeAttaque() { return this.type.nomT;}
	
	// methode
	public double coefMulti(Type typeAtt, Type typeDef) {
		int indexAtt = typeAtt.indexAssociationAffinite;
		int indexDef = typeDef.indexAssociationAffinite;
		double valMultiplicateur = typeAtt.aff.affinite.get(indexDef).get(indexAtt);
		//System.out.println("Attak index def - index att = "+ valMultiplicateur);
		return valMultiplicateur;
	}
	
	@Override
	public String toString() {
		return ("Attaque " + this.nomA + " de type "+ getTypeAttaque());
	}
}
