package jeu.eu.ensg;
import java.util.List;
import java.util.ArrayList;

public class TableManips {
	
	/**
	 * Cette méthode nettoie un tableau à deux dimensions en supprimant toutes les lignes qui contiennent un élément donné dans une colonne donnée.
	 * @param table Le tableau à nettoyer.
	 * @param columnIndex L'indice de la colonne à filtrer.
	 * @param elementToRemove L'élément à supprimer dans les lignes contenant cet élément dans la colonne spécifiée.
	 * @return Le tableau nettoyé.
	 */
	public static String[][] cleanTable(String[][] table, int columnIndex, String elementToRemove) {
	    // On crée une liste pour stocker les lignes du tableau qui ne contiennent pas l'élément à supprimer.
	    List<String[]> cleanedTable = new ArrayList<>();
	    // Pour chaque ligne du tableau,
	    for (String[] row : table) {
	        // si l'élément dans la colonne spécifiée n'est pas égal à l'élément à supprimer,
	        if (!row[columnIndex].equals(elementToRemove)) {
	            // on ajoute la ligne à la liste des lignes nettoyées.
	            cleanedTable.add(row);
	        }
	    }
	    // On convertit la liste des lignes nettoyées en un tableau à deux dimensions.
	    table = cleanedTable.toArray(new String[cleanedTable.size()][]);
	    return table;
	}
}
