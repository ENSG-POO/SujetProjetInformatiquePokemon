package gestion_pokémon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import déroulé_jeu.Coordinate;

public class Ensemble_Pokemon {
	
	public ArrayList<Pokemon> Univers;
	
	public Ensemble_Pokemon () {
		ArrayList<Pokemon> Univ = new ArrayList<Pokemon>();
		Pokedex pokedex = new Pokedex();
		String csvFile = "data\\pokemon_coordinates.csv";
		String line = "";
		String csvSplitBy = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){
			while ((line = br.readLine()) != null) {
				String newname = line.split(csvSplitBy)[0];
				String name = "";
				int i = -1;
				while (!(name.equals(newname)))
				{	i+=1;
					name=pokedex.ArrayPokedex.get(i).name;
					}
				Pokemon pokemon = pokedex.ArrayPokedex.get(i);
				Pokemon nv_poke = new Pokemon (pokemon.name, pokemon.type1, pokemon.type2, pokemon.HPMax,pokemon.attack,pokemon.speed,pokemon.legendary);
				Univ.add(nv_poke);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	this.Univers=Univ;
	}

	public Coordinate[] ensemble_coords (){
		Coordinate [] ens_coords = new Coordinate[this.Univers.size()];
		int i = 0;
		for (Pokemon pokemon : this.Univers) {
			Coordinate coord = pokemon.coord;
			ens_coords[i]=coord;
			i+=1;
		}
		return ens_coords;
	}
	
	public boolean contains (Coordinate coord) {
		int i = 0;
		Coordinate[] ens_coords = this.ensemble_coords();
		for (Coordinate coord_test : ens_coords) {
			if (coord_test.equals(coord)) {i = 1;}
		}
		return i==1;
	}
	
	
	
	public void attribuer_coord (int dim_jeu, Coordinate CoordCS) {
		for (Pokemon pokemon : this.Univers) {
			int CoordX=(int) (Math.random() * dim_jeu);
			int CoordY=(int) (Math.random() * dim_jeu);
			Coordinate Coord_test = new Coordinate (CoordX, CoordY);
			while ((Coord_test.equals(CoordCS)) ||  this.Univers.contains(Coord_test)) {
				CoordX=(int) (Math.random() * dim_jeu);
				CoordY=(int) (Math.random() * dim_jeu);
				Coord_test = new Coordinate (CoordX, CoordY);
			}
			pokemon.coord=Coord_test;
		}		
	}
	
	public ArrayList<Pokemon> Pokemon_possédé () {
		ArrayList<Pokemon> poss = new ArrayList<Pokemon>();
		
		for (Pokemon pokemon : this.Univers) {
			if (pokemon.etat != "sauvage") {
				poss.add(pokemon);
			}
		}
		return poss;
	}

	
	public ArrayList<Pokemon> Pokemon_utilisable () {
		ArrayList<Pokemon> team = new ArrayList<Pokemon>();
		
		for (Pokemon pokemon : this.Univers) {
			if (pokemon.etat == "utilisable") {
				team.add(pokemon);
			}
		}
		return team;
	}
	
	public ArrayList<Pokemon> PokemonDeDépart (int Start_Nb) {
		ArrayList<Pokemon> team = new ArrayList<Pokemon>();
		
		for (int i=0; i<Start_Nb; i++) {
			Random r = new Random();
			int n = r.nextInt(this.Univers.size());
				while (!(this.Univers.get(n).etat=="sauvage") || (this.Univers.get(n).legendary)) {
					r = new Random();
					n = r.nextInt(this.Univers.size());
				}
				this.Univers.get(n).Deviens_poss();
				this.Univers.get(n).Deviens_utilisable();
				team.add(this.Univers.get(n));
			
		}
		return team;
	}
	
	public int NbPokéRestant () {
		int n = 0;
		for (Pokemon pokemon : this.Univers) {
			if (pokemon.etat == "sauvage") {n+=1;}
		}
		return n;
	}
	
	public Pokemon Rencontre (Coordinate position) {
		for (Pokemon pokemon : this.Univers) {
			if (pokemon.coord.equals(position)) {
				return pokemon;
			}
		}
		return null;
	}
	
	public Pokemon Choix_Combattant () {
		ArrayList<Pokemon> team = this.Pokemon_utilisable ();
		
		System.out.println("Pokémons utilisables : ");
	    for (Pokemon pokemon : team) {
	    	System.out.println(pokemon);
	    }
		
	    System.out.print("Entrez le numéro du Pokémon que vous souhaitez choisir (entre 1 et "+team.size()+") : ");
	    Scanner scanner = new Scanner(System.in);
	    int choix = scanner.nextInt(); 
	    scanner.nextLine(); 
	   
	    while (!(choix >= 1 && choix <= team.size())) {
	    	System.out.println("Choix invalide. Veuillez réessayer.");
	    	System.out.print("Entrez le numéro du Pokémon que vous souhaitez choisir (entre 1 et "+team.size()+") : ");
		    scanner = new Scanner(System.in);
		    choix = scanner.nextInt(); 
		    scanner.nextLine(); 
	    }
	    Pokemon pokemonChoisi =team.get(choix - 1); 
	    System.out.println("Vous avez choisi : " + pokemonChoisi.getNom());	
	return pokemonChoisi;
	}
	
	public void Soin () {
		for (Pokemon pokemon : this.Univers) {
			if (!(pokemon.etat == "sauvage")) {
				pokemon.HP=pokemon.HPMax;}
		}
	}
	
	public ArrayList<Pokemon> Choix_equipe (int LimSizeDraft, ArrayList<Pokemon> team) {
		int n=0;
    	for (Pokemon pokemon : Univers) {
			if (!(pokemon.etat == "sauvage")) {
				n+=1;}
		}
    	if (n<=LimSizeDraft) {System.out.println("Capture d'autres pokemons pour pouvoir choisir ton équipe");
    												return team;}
    	
    	else {
		team.clear();
		for (Pokemon pokemon : this.Univers) {
			if (pokemon.etat=="utilisable") {
				pokemon.Deviens_poss();
				};
		}
		
		for (int i =0; i<LimSizeDraft; i++) {
		
			ArrayList<Pokemon> utilisable = new ArrayList<Pokemon>();	
			
			System.out.println("Pokémons utilisables : ");
			for (Pokemon pokemon : this.Univers) {
				if (pokemon.etat=="possédé") {
					System.out.println(pokemon);
					utilisable.add(pokemon);
					};
			}
		
			System.out.print("Entrez le numéro du Pokémon que vous souhaitez choisir (entre 1 et "+utilisable.size()+") : ");
			Scanner scanner = new Scanner(System.in);
			int choix = scanner.nextInt();
			System.out.println(choix);
			
			while (choix < 1 || choix > utilisable.size()) {
				System.out.println("Choix invalide. Veuillez réessayer.");
				System.out.print("Entrez le numéro du Pokémon que vous souhaitez choisir (entre 1 et "+utilisable.size()+") : ");
				scanner = new Scanner(System.in);
				choix = scanner.nextInt(); 
				scanner.nextLine(); 
			}
			Pokemon pokemonChoisi =utilisable.get(choix - 1); 
			System.out.println("Vous avez choisi : " + pokemonChoisi.getNom());
			pokemonChoisi.Deviens_utilisable();
			team.add(pokemonChoisi);
	    
		}
		return team;
	}}
	
public static void main(String[] args) {
	Ensemble_Pokemon Univers = new Ensemble_Pokemon ();
	Coordinate CoordCS = new Coordinate(60,60);
	Univers.attribuer_coord(70,CoordCS);
	ArrayList<Pokemon> team = Univers.PokemonDeDépart(4);
	System.out.println(Univers.Univers.get(45).type1);
	}
}