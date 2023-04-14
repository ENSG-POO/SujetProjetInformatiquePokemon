package pack1;

public class PokeSauvage extends Pokemon{
	
	public String nom;
	public String fam1; 
	public String fam2; 
	public int PV; 
	public int id; 
	public int degatN; 
	public int degatS;
	public coord position;
	
	public PokeSauvage (String nom, String fam1, int PV, int id, int degatN, int degatS, coord position) {
		super (nom, fam1, PV, id, degatN, degatS);
		this.position = position;
	}
	
	public PokeSauvage (String nom, String fam1, String fam2, int PV, int id, int degatN, int degatS, coord position) {
		super (nom, fam1, fam2, PV, id, degatN, degatS);
		this.position = position; 
	}

}
