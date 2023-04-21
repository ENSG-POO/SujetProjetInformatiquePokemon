package pack1;

public class Pokemon {
	
	//classe mère pour créer les Pokémons
	
	public String name;
	public coord position;
	public double distance;
	
	public Pokemon (String name, coord position ) {
		this.name = name; 
		this.position = position;

	}
	
	public Pokemon (String name) {
		this.name = name; 
		this.position = null;

	}
	
	public coord getPosition() {
		return this.position;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public double getDistance() {
		return this.distance;
	}


		
	
	@Override
    public String toString() {
        return this.name ;
    }

	
	

	}

