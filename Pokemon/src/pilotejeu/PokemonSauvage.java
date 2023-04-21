package pilotejeu;

import java.util.Arrays;
import java.util.Random;

public class PokemonSauvage extends tableau {
	
	// Classe qui permet d'attribuer des coordonnées (X,Y) aléatoire paires (pour un déplacement plus rapide sur l'interface) entre 0 et 30
	
		public PokemonSauvage() {
			
		}
		
		
		public String[][] pokemon_s_with_coords(){
			//renvoie une copie du csv avec 2colonnes en plus pour rajouter les coordonnées des pokemon
			Random random = new Random();
	        for (int i = 1; i < data.length; i++) {
	            int randomInt1 = random.nextInt(16) * 2; // Génère un entier pair entre 0 et 30
	            int randomInt2 = random.nextInt(16) * 2; // Génère un entier pair entre 0 et 30
	            data[i][11] = Integer.toString(randomInt1);
	            data[i][12] = Integer.toString(randomInt2);
	           
		}
	        data[0][11]="X";
	        data[0][12]="Y";
		
	        return data;
	 }

		public static void main(String[] args) {
			
			PokemonSauvage PS = new PokemonSauvage();
			
			String[][] pokemon_s_coords = PS.pokemon_s_with_coords();
			System.out.println(Arrays.deepToString(pokemon_s_coords));

		}


}
