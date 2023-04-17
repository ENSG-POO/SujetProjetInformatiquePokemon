package jeu.eu.ensg;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Type {
	
	private String nom;

	public Type(String nom) {
		super();
		this.nom = nom;
	}
	
	public int NumType() {
		HashMap<String,Double> NumType = new HashMap<String,Double>();
		NumType.put("Acier",0.0);
		NumType.put("Combat",1.0);
		NumType.put("Dragon",2.0);
		NumType.put("Eau",3.0);
		NumType.put("Feu",4.0);
		NumType.put("Electrik",5.0);
		NumType.put("Fee",6.0);
		NumType.put("Glace",7.0);
		NumType.put("Insecte",8.0);
		NumType.put("Normal",9.0);
		NumType.put("Plante",10.0);
		NumType.put("Poison",11.0);
		NumType.put("Psy",12.0);
		NumType.put("Roche",13.0);
		NumType.put("Sol",14.0);
		NumType.put("Spectre",15.0);
		NumType.put("tenebre",16.0);
		NumType.put("Vol",17.0);
		int nt = NumType.get(this.nom).intValue();
		return nt;
	}


	public String getdata(Type b) {
        String csvFile = "C:/Users/Formation/Desktop/projet/Jmammou-Labbe-Bontoux/data/tableau-type.csv"; // "import" du fichier
        String line = "";
        String csvSplitBy = ","; // séparateur dans le csv qui permettra de "dispatcher" les valeurs dans le tableau crée
        int numRows = 0; // initialisation nombre ligne du tableau 
        int numCols = 0; // initialisation nombre colonne du tableau
        
        // récupération du nombre de ligne et de nombre de colonne du tableau qui contiendra les données du csv
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) { //  simplifie la lecture de texte à partir de flux d'entrée de caractères. BufferedReader contient un objet Reader, qui lit automatiquement les données du fichier et les stocke dans buffer (la mémoire tampon) de BufferedReader. 
            while ((line = br.readLine()) != null) {  //lit une ligne de texte qui est considérée comme terminée par un saut de ligne ('\n'), ou un retour chariot ('\r')
                numRows++;  // si la ligne du fichier est non vide, on rajoute une ligne au tableau
                String[] row = line.split(csvSplitBy); // découpe les lignes selon "," et les ajoute à un tableau
                numCols = row.length; // le nombre de colonne correspond donc à la longueur du tableau précédent (le nombre de ",")
            }
        } catch (IOException e) {
            e.printStackTrace(); // tient compte d'un éventuel problème
        }
        
        // création d'un tableau de la taille du csv
        String[][] data = new String[numRows][numCols];

        // remplissage du tableau 
        int rowIndex = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(csvSplitBy);
                for (int i = 0; i < row.length; i++) {
                    data[rowIndex][i] = row[i]; // pour chaque cellule du tableau, remplace la valeur du tableau par la valeur correspondante dans le csv
                }
                rowIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data[this.NumType()][b.NumType()];
	}
}