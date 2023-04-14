package pack1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
 
public class Tab {
	
	public static String[][] readCSV(String nomFichier, char c, Charset charset) throws IOException {
		return Files.readAllLines(Paths.get(nomFichier), charset)
			     .stream()
			     .map(ligne-> ligne.split(String.valueOf(c)))
			     .toArray(String[][]::new);
	}
	
     
	public static void main(String[] args) {

        try {
            String[][] tableau = readCSV("C:\\1_MAJ\\Projet\\Java\\FAGUET-LEROUX-PALOS\\data\\pokemon_first_gen.csv", ',', StandardCharsets.UTF_8); // domma separated values

            for (String[] ligne : tableau) {
                Ligne ligneObjet = new Ligne(ligne);
                ligneObjet.afficher(); 
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}