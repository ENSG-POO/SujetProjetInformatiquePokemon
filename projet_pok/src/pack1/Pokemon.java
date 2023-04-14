package pack1;

public abstract class Pokemon {
	
	public String nom;
	public String fam1; 
	public String fam2; 
	public int PV; 
	public int id; 
	public int degatN; 
	public int degatS;
	
	public Pokemon (String nom, String fam1, int PV, int id, int degatN, int degatS) {
		this.nom = nom; 
		this.fam1 = fam1; 
		this.PV = PV; 
		this.id = id; 
		this.degatN = degatN;
		this.degatS = degatS; 
	}
	
	public Pokemon (String nom, String fam1, String fam2, int PV, int id, int degatN, int degatS) {
		this.nom = nom; 
		this.fam1 = fam1;
		this.fam2 = fam2;
		this.PV = PV; 
		this.id = id; 
		this.degatN = degatN;
		this.degatS = degatS; 
	}
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
