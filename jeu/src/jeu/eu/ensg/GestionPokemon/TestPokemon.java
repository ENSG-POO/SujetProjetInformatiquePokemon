package GestionPokemon;
import java.util.*;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import Types.*;

public class TestPokemon {

	public static void main(String[] args) throws IOException, CsvException{
		// TODO Auto-generated method stub
		
		Type Acier = new Acier();
		Type Combat = new Combat();
		Type Dragon = new Dragon();
		Type Eau = new Eau();
		Type Electrik = new Electrik();
		Type Fee = new Fee();
		Type Feu = new Feu();
		Type Glace = new Glace();
		Type Insecte = new Insecte();
		Type Normal = new Normal();
		Type Plante = new Plante();
		Type Poison = new Poison();
		Type Psy = new Psy();
		Type Roche = new Roche();
		Type Sol = new Sol();
		Type Spectre = new Spectre();
		Type Tenebres = new Tenebres();
		Type Vol = new Vol();
		
		Pokemon Dracaufeu = new Pokemon(6,"Dracaufeu", Feu, Vol, 78, 84, 78, 109, 85, 100);
		System.out.println(Dracaufeu.getEffectiveness(Roche));
		
		List<Capacite> capaList = CsvParser.capaParse();
		Capacite Flamethrower = capaList.get(130);
		Pokemon Bulbizarre = new Pokemon(4);
		System.out.println(Bulbizarre.getNom());
		System.out.println(Bulbizarre.getType2());
		System.out.println("HP maximum : " + Bulbizarre.getHpMax());
		System.out.println("HP : " + Bulbizarre.getHp());
		Bulbizarre.Degats(Dracaufeu, Flamethrower);
		System.out.println("Degats subits : " + Bulbizarre.Degats(Dracaufeu, Flamethrower));
		
		
		List<Pokemon> coordList = CsvParser.pokemonParse();
        System.out.println(coordList);
        Pokemon pokemon = coordList.get(4);
        System.out.println(pokemon.getX());
        System.out.println(pokemon.getNom());
        System.out.println(pokemon.getC1().getNom());
        System.out.println(pokemon.getC2().getNom());
        System.out.println(pokemon.getC3().getNom());
        System.out.println(pokemon.getC4().getNom());

	}

}
