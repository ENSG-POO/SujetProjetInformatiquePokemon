/*package pilotejeu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class tableau {
	
	public String[][] data;
	public String nom;
	
	public tableau(String nom) {
		this.nom = nom;
	}
	
	String[] attribut_pokemon ;
	
	public String[] getPokemon(){
		for (int i = 0; i < data.length; i++) {
			if (data[i][1].equals(nom)) {
				attribut_pokemon = data[i];
			}
		}
		return attribut_pokemon;
	}

	public static void main(String[] args) {
		File pokemon = new File ("/Users/clementcambours/Documents/ENSG-geomatique/Java/projet/pokemon_first_gen.csv");
		BufferedReader br = null;
		String line =" ";
		String [][] data = new String[167][13];
		int row = 0;
		
		try {
		br = new BufferedReader(new FileReader(pokemon));
		
		System.out.println("file found");
		
		
		
		while ((line = br.readLine())!= null) {
			 String[] values = line.split(",");
			    for (int col = 0; col < values.length; col++) {
			        data[row][col] = values[col];
			    }
			    row++;
			
		}
		
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not found"); 
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Tableau pokémon : ");
        System.out.println(Arrays.deepToString(data));
		System.out.println(data[2][4]);
		
	
		tableau mon_pokemon = new tableau("Bulbasaur");
		System.out.println(mon_pokemon.getPokemon());
	
	}		

}

*/

package pilotejeu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class tableau {
	// Classe qui permet de lire le fichier csv contenant tous les pokemons et leurs attributs

	
	public String nom;
	private static final String FILE_PATH = "../data/pokemon_first_gen.csv";
	
	public tableau() {	
	}
	
	public tableau(String nom) {
		this.nom = nom;
	}		
	
		
	public String[] getPokemon() {
		// Cette fonction renvoie les attributs d'un pokemon 
		String[] attribut_pokemon = {""};
		for (int i = 0; i < data.length; i++) {
			if (data[i][1].equals(nom)) {
				attribut_pokemon = data[i];
			}
		}
		return attribut_pokemon;
	}
	

	File pokemon = new File(FILE_PATH);
	BufferedReader br = null;
	String line = null;
	String[][] data = new String[167][13];
	int row = 0;
	{
	
	try {
		br = new BufferedReader(new FileReader(pokemon));
	
		//System.out.println("File found");
		
		while ((line = br.readLine()) != null) {
			String[] values = line.split(",");
			for (int col = 0; col < values.length; col++) {
				data[row][col] = values[col];
			}
			row++;
		}
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
		//System.out.println("File not found"); 
	}
	catch (IOException e) {
		e.printStackTrace();
	}
	finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

	    System.out.print("Choisi ton pokémon: ");
	    String chaine = scanner.nextLine();

	    System.out.println("Les caractéristiques du pokémon sont : " + chaine);
		
		tableau mon_pokemon = new tableau(chaine);
		System.out.println("Mon pokémon : " + Arrays.toString(mon_pokemon.getPokemon()));
	}		
}

