package jeu.eu.ensg;
import java.util.List;
import java.util.ArrayList;

public class TableManips {
	
	public static String[][] cleanTable(String[][] table, int columnIndex, String elementToRemove) {
	    List<String[]> cleanedTable = new ArrayList<>();
	    for (String[] row : table) {
	        if (!row[columnIndex].equals(elementToRemove)) {
	            cleanedTable.add(row);
	        }
	    }
	    table = cleanedTable.toArray(new String[cleanedTable.size()][]);
	    return table;
	}

}
