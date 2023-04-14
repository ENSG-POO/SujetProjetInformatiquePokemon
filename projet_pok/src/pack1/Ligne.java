package pack1;

public class Ligne {
	
	
	private String[] index;

    public Ligne(String[] index) {
        this.index = index;
    }
    
    public void afficher() {
        for (String id : index) {
            System.out.print(id + "\t");
        }
        System.out.println();
    }        

}
