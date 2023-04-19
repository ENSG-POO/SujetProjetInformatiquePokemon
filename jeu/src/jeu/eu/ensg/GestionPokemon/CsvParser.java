package GestionPokemon;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

// Classe permettant de lire les csv nécessaires au programme
public class CsvParser {
	// Implementation des fichiers
	private static final String POKEDEX_CSV_FILE_PATH = "./data/Pokedex.csv";
    private static final String CAPACITE_CSV_FILE_PATH = "./data/All_Moves.csv";
    private static final String POKEMON_CSV_FILE_PATH = "./data/pokemon_data_moves.csv";

    // Lecture du csv avec les statistiques et création d'une lise d'objets Pokemon avec les attributs correspondants
    public static List<Pokemon> pokedexParse() throws IOException {
        List<Pokemon> pokemonList = new ArrayList<>();  // Création de la liste
        
        // Gestion des exceptions
        try (CSVReader reader = new CSVReader(new FileReader(POKEDEX_CSV_FILE_PATH))) {
            List<String[]> records;
            try {
                records = reader.readAll();
            } catch (CsvException e) {
                throw new IOException("Failed to read CSV file: " + e.getMessage());
            }

            for (String[] record : records) {
            	
                // Récupération des données du CSV
                int id = Integer.parseInt(record[0]);
                String name = record[1];
                Type type1 = TypeConverter.fromString(record[2]);
                Type type2 = record[3].isEmpty() ? null : TypeConverter.fromString(record[3]);
                int totalStats = Integer.parseInt(record[4]);
                int hp = Integer.parseInt(record[5]);
                int attack = Integer.parseInt(record[6]);
                int defense = Integer.parseInt(record[7]);
                int specialAttack = Integer.parseInt(record[8]);
                int specialDefense = Integer.parseInt(record[9]);
                int speed = Integer.parseInt(record[10]);

                // Création de l'objet Pokemon correspondant
                Pokemon pokemon = new Pokemon(id, name, type1, type2, hp, attack, defense, specialAttack, specialDefense, speed);

                // Ajout du Pokemon à la liste
                pokemonList.add(pokemon);
            }
        }
        return pokemonList;
    }
    
    
    // Lecture du csv téléchargé contenant les attaques disponibles et créationn d'une liste les contenant
    public static List<Capacite> capaParse() throws IOException, CsvException {
        List<Capacite> capaList = new ArrayList<>();  // Création de la liste
        
        // Gestion des exceptions
        try (CSVReader reader = new CSVReader(new FileReader(CAPACITE_CSV_FILE_PATH))) {
            List<String[]> records;
            try {
                records = reader.readAll();
            } catch (CsvException e) {
                throw new IOException("Failed to read CSV file: " + e.getMessage());
            }

            for (String[] record : records) {
                // Récupération des données du CSV
                String name = record[0];
                Type type = TypeConverter.fromString(record[1]);
                String categorie = record[2];
                int puissance = Integer.parseInt(record[3]);
                int precision = Integer.parseInt(record[4]);
                

                // Création de l'objet Pokemon correspondant
                Capacite capacite = new Capacite(name, type, categorie, puissance, precision);

                // Ajout du Pokemon à la liste
                capaList.add(capacite);
            }
        }
        return capaList;
    }
    
    // Lecture du même csv que la fonction précédente, mais implémentation de seuls les noms dans une liste
    public static List<String> nameParse() throws IOException, CsvException {
        List<String> nomcapaList = new ArrayList<>();  // Création de la liste
        try (CSVReader reader = new CSVReader(new FileReader(CAPACITE_CSV_FILE_PATH))) {
            List<String[]> records;
            try {
                records = reader.readAll();
            } catch (CsvException e) {
                throw new IOException("Failed to read CSV file: " + e.getMessage());
            }

            for (String[] record : records) {
            	
                // Récupération des données du CSV
                String name = record[0];
                

                // Ajout du Pokemon à la liste
                nomcapaList.add(name);
            }
        }
        return nomcapaList;
    }
    
    // Lecture du csv contenant les pokemon et leurs coordonnées, auxquels ont a rajouté les attaque pouvant êtres apprises par chaque pokemon, et création d'une liste les contenant tous
    public static List<Pokemon> pokemonParse() throws IOException, CsvException {
        List<Pokemon> coordList = new ArrayList<>();  // Création de la liste finale
        List<Capacite> capaList = CsvParser.capaParse();  // Récupération de la liste des attaques
        List<String> nomcapaList = CsvParser.nameParse();  // Récupération de la liste des noms d'attaque
        
        // Lecture du Csv et gestion des exceptions
        CSVParser csvParser = new CSVParserBuilder().withSeparator('	').build();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(POKEMON_CSV_FILE_PATH)).withCSVParser(csvParser).build();) {
            List<String[]> records;
            try {
                records = reader.readAll();
            } catch (CsvException e) {
                throw new IOException("Failed to read CSV file: " + e.getMessage());
            }
            

            // Parcourt du csv
            for (String[] record : records) {
                // Récupération des données du CSV
                int id = Integer.parseInt(record[0]);
                String name = record[1];
                String sCoord = record[2];
                String coordContent = sCoord.substring(1, sCoord.length() - 1);
                String[] coordParts = coordContent.split(",");
                double x = Double.parseDouble(coordParts[0].trim());
                double y = Double.parseDouble(coordParts[1].trim());
                // Récupération des attaques pouvant être apprises par le pokemon
                String str = record[3];
                String cleanStr = str.replace("[", "").replace("]", "");
                List<String> list = Arrays.asList(cleanStr.split(", "));
                List<String> movepool = new ArrayList<>(list);
                

                // Récupération des statistiques du Pokemon
                List<Pokemon> pokemonList = CsvParser.pokedexParse();
                Pokedex pokedex = new Pokedex("./data/Pokedex.csv");
                int idPokedex = pokedex.getPokedexNumber(name);
        		Type type1 = pokemonList.get(idPokedex-1).getType1();
        		Type type2 = pokemonList.get(idPokedex-1).getType2();
        		int hpMax = pokemonList.get(idPokedex-1).getHpMax();
        		int hp = pokemonList.get(idPokedex-1).getHp();
        		int atk = pokemonList.get(idPokedex-1).getAtk();
        		int def = pokemonList.get(idPokedex-1).getDef();
        		int spAtk = pokemonList.get(idPokedex-1).getSpAtk();
        		int spDef = pokemonList.get(idPokedex-1).getSpDef();
        		int spe = pokemonList.get(idPokedex-1).getSpe();
        		
        		// Ajout aléatoire de 4 attaques pouvant être apprises au pokemon
                Random rand = new Random();
                
                // Pour la première attaque, on fait en sorte qu'elle soit du premier type du pokemon, pour avoir un STAB
                int rd1 = rand.nextInt(movepool.size());  // entier aléatoire entre 0 et la longueur de la liste de capacités
                //On reste dans la boucle tant que l'attaque choisie par l'aléatoire n'est pas codée ou n'est pas du bon type
                while(true) {
                	if (!nomcapaList.contains(movepool.get(rd1).substring(1, movepool.get(rd1).length()-1))){
                		movepool.remove(rd1);  // Si l'attaque n'est pas codée on la retire de la liste parcourue pour que ce soit plus rapide
                		rd1 = rand.nextInt(movepool.size());  // On choisit une nouvelle attaque de la liste
                	}
                	else {
	                	if (capaList.get(nomcapaList.indexOf(movepool.get(rd1).substring(1, movepool.get(rd1).length()-1))).getType().getClass() != type1.getClass()) {
	                		rd1 = rand.nextInt(movepool.size());  // Si l'attaque n'est pas du bon type on en choisit une autre
	                	}
                	}
                	// Si les conditions sont réunies, on sort de la boucle
                	if (nomcapaList.contains(movepool.get(rd1).substring(1, movepool.get(rd1).length()-1)) && capaList.get(nomcapaList.indexOf(movepool.get(rd1).substring(1, movepool.get(rd1).length()-1))).getType().getClass() == type1.getClass()) break;
                }
                Capacite capa1 = capaList.get(nomcapaList.indexOf(movepool.get(rd1).substring(1, movepool.get(rd1).length()-1)));
                
                // Si le pokemon a un deuxième type, on lui donne une attaque de celui-ci
                int rd2 = rand.nextInt(movepool.size());
                if (type2 != null) {
                	while(true) {
                    	if (!nomcapaList.contains(movepool.get(rd2).substring(1, movepool.get(rd2).length()-1))){
                    		movepool.remove(rd2);
                    		rd2 = rand.nextInt(movepool.size());
                    	}
                    	else {
    	                	if (capaList.get(nomcapaList.indexOf(movepool.get(rd2).substring(1, movepool.get(rd2).length()-1))).getType().getClass() != type2.getClass()) {
    	                		rd2 = rand.nextInt(movepool.size());
    	                	}
                    	}
                    	if (nomcapaList.contains(movepool.get(rd2).substring(1, movepool.get(rd2).length()-1)) && capaList.get(nomcapaList.indexOf(movepool.get(rd2).substring(1, movepool.get(rd2).length()-1))).getType().getClass() == type2.getClass()) break;
                    }
                }
                else {
                    while(!nomcapaList.contains(movepool.get(rd2).substring(1, movepool.get(rd2).length()-1))) {
                    	movepool.remove(rd2);
                    	rd2 = rand.nextInt(movepool.size());
                    }
                }
                Capacite capa2 = capaList.get(nomcapaList.indexOf(movepool.get(rd2).substring(1, movepool.get(rd2).length()-1)));
                
                // 3e attaque sans condition de type
                int rd3 = rand.nextInt(movepool.size());
                while(!nomcapaList.contains(movepool.get(rd3).substring(1, movepool.get(rd3).length()-1))) {
                	movepool.remove(rd3);
                	rd3 = rand.nextInt(movepool.size());
                }
                Capacite capa3 = capaList.get(nomcapaList.indexOf(movepool.get(rd3).substring(1, movepool.get(rd3).length()-1)));
                
                // 4e attaque sans condition de type
                int rd4 = rand.nextInt(movepool.size());
                while(!nomcapaList.contains(movepool.get(rd4).substring(1, movepool.get(rd4).length()-1))) {
                	movepool.remove(rd4);
                	rd4 = rand.nextInt(movepool.size());
                }
                Capacite capa4 = capaList.get(nomcapaList.indexOf(movepool.get(rd4).substring(1, movepool.get(rd4).length()-1)));
                

                // Création de l'objet Pokemon correspondant
                Pokemon pokemon = new Pokemon(id, name, type1, type2, hpMax, atk, def, spAtk, spDef, spe, x, y, capa1, capa2, capa3, capa4);

                // Ajout du Pokemon à la liste
                coordList.add(pokemon);
                
                Pokemon Dracaufeu = coordList.get(id-1);
                System.out.println("-----------");
                System.out.println(Dracaufeu.getNom());
                System.out.println(Dracaufeu.getC1().getNom());
                System.out.println(Dracaufeu.getC2().getNom());
                System.out.println(Dracaufeu.getC3().getNom());
                System.out.println(Dracaufeu.getC4().getNom());
                
            }
        }
        return coordList;
    }

}
