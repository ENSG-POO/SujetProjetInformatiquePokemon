package pack1;

public class Pokemon {
	
	private int id;
    private String nom;
    private String type;
    private String type2;
    private double Total;
    
    public Pokemon(int id, String nom, String type, String type2, double Total) {
    	this.id = id;
    	this.nom = nom;
    	this.type = type;
    	this.type2 = null;
    	this.Total = Total;
    }
    
    public Pokemon() {
    	
    }
    
    public int getId() {
    	return this.id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getNom() {
    	return this.nom;
    }
    
    public void setNom(String nom) {
    	this.nom = nom;
    }
    
    public String getType() {
    	return this.type;
    }
    
    public void setType(String type) {
    	this.type = type;
    }
    
    public String getType2() {
    	return this.type;
    }
    
    public void setType2(String type) {
    	this.type2 = null;
    }
    
    public double getTotal() {
    	return this.Total;
    }
    
    public void setTotal(double Total) {
    	this.Total = Total;
    }


    @Override
    public String toString() {
        return "Pokemon [id=" + getId() + ", nom=" + getNom() + ", type=" + getType() + ", type2=" + getType2() + 
        		", Total=" + getTotal() + "]";
    }
    
}
