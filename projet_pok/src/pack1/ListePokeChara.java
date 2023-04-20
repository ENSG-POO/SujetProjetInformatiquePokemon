package pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListePokeChara {
	PokeCharacter[] ListeChara;
	public ListePokeChara() {
	String fichierCSV = "../data/pokemon_first_gen.csv";
    char separateur = ',';

    PokeCharacter[] ListeChara = new PokeCharacter[166];
    int i = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(fichierCSV))) {
        String ligne;
        boolean ligne1 = true;
        while ((ligne = br.readLine()) != null) {
        	if(ligne1) {
        		ligne1 = false;
        		continue;
        	}
            
            String[] valeurs = ligne.split(String.valueOf(separateur));
            
            int id = Integer.parseInt(valeurs[0]);
            String name = valeurs[1];
            String type1 = valeurs[2];
            coord position = null;
            double HP = Integer.parseInt(valeurs[5]);
            PokeCharacter s1 = new PokeCharacter(id,name,position,type1,HP );
            ListeChara[i] = s1;
            i++;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }this.ListeChara=ListeChara;

}
	public PokeCharacter GetPoke(String name) {
		for(int i = 0; i < this.ListeChara.length; i++) {
			if(name.equals(this.ListeChara[i].name)) {
				return ListeChara[i];
			}
		
	}
		return null;
	
	}
}
