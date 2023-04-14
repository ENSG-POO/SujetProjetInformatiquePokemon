package pack1;

public class Pokemon {
	
	private int id;
    private String nom;
    private String type;
    
    public Pokemon(int id, String nom, String type) {
    	this.id = id;
    	this.nom = nom;
    	this.type = type;
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


    @Override
    public String toString() {
        return "Pokemon [id=" + id + ", nom=" + nom + ", type=" + type + "]";
    }
}
