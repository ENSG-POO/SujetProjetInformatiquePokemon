package pack1;

import java.util.ArrayList;
import java.util.List;

import gestion_jeu.Jeu;

public class Test {

	public static void main(String[] args) {
		coord c1 = new coord(2,3);
		
		PokeDomestique pk1 = new PokeDomestique("Bulbasaur", null);
		PokeDomestique pk2 = new PokeDomestique("Bulbasaur", null);
		PokeDomestique pk3 = new PokeDomestique("Bulbasaur", null);
		PokeDomestique pk4 = new PokeDomestique("Bulbasaur", null);
		Pokemon p2 = new Pokemon("Bulbasaur", null);
		ListePoke g1 = new ListePoke();
		PokeDomestique poke1 = new PokeDomestique ("Bulbasaur", null);
		
		Attaque a1 = new Attaque (pk1.toPokeCharacter(), poke1.toPokeCharacter() );
		
		
		PokeSauvage pokemon = new PokeSauvage ("Mew");
		String typePoke = pokemon.getType1();
		System.out.println(typePoke);
		
		Type liste = new Type();
		int p = liste.idType(poke1.getType());
		System.out.println(p);
		
		List<Pokemon> l1 = new ArrayList<Pokemon>();
		l1.add(pk1);
		l1.add(pk2);
		l1.add(pk3);
		l1.add(pk4);
		l1.add(poke1);
		
		Jeu game = new Jeu();
		System.out.println(game.listToString(l1));
		
		
	}}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		







































