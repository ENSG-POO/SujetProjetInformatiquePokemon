package GestionPokemon;
import Types.*;
import java.util.HashMap;
import java.util.Map;

public class TypeConverter {
	
	// Création d'un dictionnaire permettant de créer un objet type correspondant à un String, utile lors de la lecture des csv
    private static final Map<String, Type> TYPE_MAP = new HashMap<String, Type>() {{
        put("Normal", new Normal());
        put("Feu", new Feu());
        put("Eau", new Eau());
        put("Electrik", new Electrik());
        put("Plante", new Plante());
        put("Glace", new Glace());
        put("Combat", new Combat());
        put("Poison", new Poison());
        put("Sol", new Sol());
        put("Vol", new Vol());
        put("Psy", new Psy());
        put("Insecte", new Insecte());
        put("Roche", new Roche());
        put("Spectre", new Spectre());
        put("Dragon", new Dragon());
        put("Tenebres", new Tenebres());
        put("Acier", new Acier());
        put("Fee", new Fee());
    }};

    public static Type fromString(String typeName) {
        return TYPE_MAP.get(typeName);
    }
}

