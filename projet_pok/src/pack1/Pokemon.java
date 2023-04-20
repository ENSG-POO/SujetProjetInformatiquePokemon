package pack1;

public class Pokemon {
	
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
	
	public String getName() {
		return this.name;
	}
	
	public coord getPosition() {
		return this.position;
	}
	
    public double getDistance() {
        return this.distance;
    }
    
    public void setDistance(double distance) {
        this.distance = distance;
    }
	
	@Override
    public String toString() {
        return "Pokemon" + this.name + "ses coordonnées sont " + this.position;
    }
	
	

	}

