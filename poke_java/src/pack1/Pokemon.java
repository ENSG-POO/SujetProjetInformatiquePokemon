package pack1;

public class Pokemon {
	
	public String name;
	public coord position;
	
	public Pokemon (String name, coord position ) {
		this.name = name; 
		this.position = position;

	}
	
	public Pokemon (String name) {
		this.name = name; 
		this.position = null;

	}

		
	
	@Override
    public String toString() {
        return "Pokemon" + this.name + "ses coordonnées sont " + this.position;
    }
	
	

	}

