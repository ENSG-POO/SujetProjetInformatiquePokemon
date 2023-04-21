package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.eu.ensg.Dresseur;

public class MenuDeroulant extends JPanel {

	private String pokemon_sauvage;
	private String pokemon_joueur;
	private int id_pokemon_sauvage;
	private int id_pokemon_joueur;

	public HashMap<String, Integer> cree_dictionnaire() {
		HashMap<String, Integer> dictionary = new HashMap<>();

		dictionary.put("Bulbasaur", 1);
		dictionary.put("Ivysaur", 2);
		dictionary.put("Venusaur", 3);
		dictionary.put("VenusaurMega Venusaur", 4);
		dictionary.put("Charmander", 5);
		dictionary.put("Charmeleon", 6);
		dictionary.put("Charizard", 7);
		dictionary.put("CharizardMega Charizard X", 8);
		dictionary.put("CharizardMega Charizard Y", 9);
		dictionary.put("Squirtle", 10);
		dictionary.put("Wartortle", 11);
		dictionary.put("Blastoise", 12);
		dictionary.put("BlastoiseMega Blastoise", 13);
		dictionary.put("Caterpie", 14);
		dictionary.put("Metapod", 15);
		dictionary.put("Butterfree", 16);
		dictionary.put("Weedle", 17);
		dictionary.put("Kakuna", 18);
		dictionary.put("Beedrill", 19);
		dictionary.put("BeedrillMega Beedrill", 20);
		dictionary.put("Pidgey", 21);
		dictionary.put("Pidgeotto", 22);
		dictionary.put("Pidgeot", 23);
		dictionary.put("PidgeotMega Pidgeot", 24);
		dictionary.put("Rattata", 25);
		dictionary.put("Raticate", 26);
		dictionary.put("Spearow", 27);
		dictionary.put("Fearow", 28);
		dictionary.put("Ekans", 29);
		dictionary.put("Arbok", 30);
		dictionary.put("Pikachu", 31);
		dictionary.put("Raichu", 32);
		dictionary.put("Sandshrew", 33);
		dictionary.put("Sandslash", 34);
		dictionary.put("Nidoran♀", 35);
		dictionary.put("Nidorina", 36);
		dictionary.put("Nidoqueen", 37);
		dictionary.put("Nidoran♂", 38);
		dictionary.put("Nidorino", 39);
		dictionary.put("Nidoking", 40);
		dictionary.put("Clefairy", 41);
		dictionary.put("Clefable", 42);
		dictionary.put("Vulpix", 43);
		dictionary.put("Ninetales", 44);
		dictionary.put("Jigglypuff", 45);
		dictionary.put("Wigglytuff", 46);
		dictionary.put("Zubat", 47);
		dictionary.put("Golbat", 48);
		dictionary.put("Oddish", 49);
		dictionary.put("Gloom", 50);
		dictionary.put("Vileplume", 51);
		dictionary.put("Paras", 52);
		dictionary.put("Parasect", 53);
		dictionary.put("Venonat", 54);
		dictionary.put("Venomoth", 55);
		dictionary.put("Diglett", 56);
		dictionary.put("Dugtrio", 57);
		dictionary.put("Meowth", 58);
		dictionary.put("Persian", 59);
		dictionary.put("Psyduck", 60);
		dictionary.put("Golduck", 61);
		dictionary.put("Mankey", 62);
		dictionary.put("Primeape", 63);
		dictionary.put("Growlithe", 64);
		dictionary.put("Arcanine", 65);
		dictionary.put("Poliwag", 66);
		dictionary.put("Poliwhirl", 67);
		dictionary.put("Poliwrath", 68);
		dictionary.put("Abra", 69);
		dictionary.put("Kadabra", 70);
		dictionary.put("Alakazam", 71);
		dictionary.put("AlakazamMega Alakazam", 72);
		dictionary.put("Machop", 73);
		dictionary.put("Machoke", 74);
		dictionary.put("Machamp", 75);
		dictionary.put("Bellsprout", 76);
		dictionary.put("Weepinbell", 77);
		dictionary.put("Victreebel", 78);
		dictionary.put("Tentacool", 79);
		dictionary.put("Tentacruel", 80);
		dictionary.put("Geodude", 81);
		dictionary.put("Graveler", 82);
		dictionary.put("Golem", 83);
		dictionary.put("Ponyta", 84);
		dictionary.put("Rapidash", 85);
		dictionary.put("Slowpoke", 86);
		dictionary.put("Slowbro", 87);
		dictionary.put("SlowbroMega Slowbro", 88);
		dictionary.put("Magnemite", 89);
		dictionary.put("Magneton", 90);
		dictionary.put("Farfetch'd", 91);
		dictionary.put("Doduo", 92);
		dictionary.put("Dodrio", 93);
		dictionary.put("Seel", 94);
		dictionary.put("Dewgong", 95);
		dictionary.put("Grimer", 96);
		dictionary.put("Muk", 97);
		dictionary.put("Shellder", 98);
		dictionary.put("Cloyster", 99);
		dictionary.put("Gastly", 100);
		dictionary.put("Haunter", 101);
		dictionary.put("Gengar", 102);
		dictionary.put("GengarMega Gengar", 103);
		dictionary.put("Onix", 104);
		dictionary.put("Drowzee", 105);
		dictionary.put("Hypno", 106);
		dictionary.put("Krabby", 107);
		dictionary.put("Kingler", 108);
		dictionary.put("Voltorb", 109);
		dictionary.put("Electrode", 110);
		dictionary.put("Exeggcute", 111);
		dictionary.put("Exeggutor", 112);
		dictionary.put("Cubone", 113);
		dictionary.put("Marowak", 114);
		dictionary.put("Hitmonlee", 115);
		dictionary.put("Hitmonchan", 116);
		dictionary.put("Lickitung", 117);
		dictionary.put("Koffing", 118);
		dictionary.put("Weezing", 119);
		dictionary.put("Rhyhorn", 120);
		dictionary.put("Rhydon", 121);
		dictionary.put("Chansey", 122);
		dictionary.put("Tangela", 123);
		dictionary.put("Kangaskhan", 124);
		dictionary.put("KangaskhanMega Kangaskhan", 125);
		dictionary.put("Horsea", 126);
		dictionary.put("Seadra", 127);
		dictionary.put("Goldeen", 128);
		dictionary.put("Seaking", 129);
		dictionary.put("Staryu", 130);
		dictionary.put("Starmie", 131);
		dictionary.put("Mr. Mime", 132);
		dictionary.put("Scyther", 133);
		dictionary.put("Jynx", 134);
		dictionary.put("Electabuzz", 135);
		dictionary.put("Magmar", 136);
		dictionary.put("Pinsir", 137);
		dictionary.put("PinsirMega Pinsir", 138);
		dictionary.put("Tauros", 139);
		dictionary.put("Magikarp", 139);
		dictionary.put("Gyarados", 140);
		dictionary.put("GyaradosMega Gyarados", 141);
		dictionary.put("Lapras", 142);
		dictionary.put("Ditto", 143);
		dictionary.put("Eevee", 144);
		dictionary.put("Vaporeon", 145);
		dictionary.put("Jolteon", 146);
		dictionary.put("Flareon", 147);
		dictionary.put("Porygon", 148);
		dictionary.put("Omanyte", 149);
		dictionary.put("Omastar", 150);
		dictionary.put("Kabuto", 151);
		dictionary.put("Kabutops", 152);
		dictionary.put("Aerodactyl", 153);
		dictionary.put("AerodactylMega Aerodactyl", 154);
		dictionary.put("Snorlax", 155);
		dictionary.put("Articuno", 156);
		dictionary.put("Zapdos", 157);
		dictionary.put("Moltres", 158);
		dictionary.put("Dratini", 159);
		dictionary.put("Dragonair", 160);
		dictionary.put("Dragonite", 161);
		dictionary.put("Mewtwo", 162);
		dictionary.put("MewtwoMega Mewtwo X", 163);
		dictionary.put("MewtwoMega Mewtwo Y", 164);
		dictionary.put("1Mew", 165);
		return dictionary;
	}

	public MenuDeroulant(String[] items, String adversaire, Dresseur dresseur) {

		final JFrame fen = new JFrame();
		fen.setSize(300, 300);
		fen.setTitle("Choix Pokemon");
		fen.setVisible(true);

		JPanel infoPokemon = new JPanel(new GridLayout(2, 1));
		infoPokemon.setSize(200, 600);
		infoPokemon.setBackground(Color.PINK);

		JLabel labelNom = new JLabel("<html>Quel pokemon de votre inventaire souhaitez-vous utiliser pour combattre "
				+ adversaire + " ?</html>");
		infoPokemon.add(labelNom);

		ItemListener itemListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object selectedItem = e.getItem();
					String nom = selectedItem.toString();
					HashMap<String, Integer> dictionnaire = cree_dictionnaire();
					int id_pokemon_sauvage = dictionnaire.get(adversaire);
					int id_pokemon_inventaire = dictionnaire.get(nom);
					setPokemon_sauvage(adversaire);
					setPokemon_joueur(nom);
					setId_pokemon_joueur(id_pokemon_inventaire);
					setId_pokemon_sauvage(id_pokemon_sauvage);
					Combat_temporaire combat = new Combat_temporaire(nom, adversaire, id_pokemon_inventaire, id_pokemon_sauvage, dresseur);
					fen.dispose();
					return;
					// Code à exécuter lorsque l'élément est sélectionné
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					Object deselectedItem = e.getItem();
					// Code à exécuter lorsque l'élément est désélectionné
				}
			}
			
		};

		if (items == null) {
			items = new String[] { "" };
		}
		JComboBox<String> comboBox = new JComboBox<>(items);
		comboBox.addItemListener(itemListener);
		infoPokemon.add(comboBox);
		fen.add(infoPokemon);

	}

	public MenuDeroulant(String[] items, Dresseur dresseur) {

		final JFrame fen = new JFrame();
		fen.setSize(300, 300);
		fen.setTitle("Choix Pokemon");
		fen.setVisible(true);

		JPanel infoPokemon = new JPanel(new GridLayout(2, 1));
		infoPokemon.setSize(200, 600);
		infoPokemon.setBackground(Color.PINK);

		JLabel labelNom = new JLabel(
				"<html>Choisissez dans le menu déroulant le pokemon que vous souhaitez combattre :</html>");
		infoPokemon.add(labelNom);

		ItemListener itemListener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object selectedItem = e.getItem();
					String nom = selectedItem.toString();
					MenuDeroulant inventaire = new MenuDeroulant(dresseur.getNomsPokemons(), nom, dresseur);
					fen.dispose();
					return;

					// Code à exécuter lorsque l'élément est sélectionné
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					Object deselectedItem = e.getItem();
					// Code à exécuter lorsque l'élément est désélectionné
				}
			}
		};

		if (items == null) {
			items = new String[] { "" };
		}
		JComboBox<String> comboBox = new JComboBox<>(items);
		comboBox.addItemListener(itemListener);
		infoPokemon.add(comboBox);
		fen.add(infoPokemon);

	}
	

	public void setPokemon_sauvage(String pokemon_sauvage) {
		this.pokemon_sauvage = pokemon_sauvage;
	}

	public void setPokemon_joueur(String pokemon_joueur) {
		this.pokemon_joueur = pokemon_joueur;
	}

	public void setId_pokemon_sauvage(int id_pokemon_sauvage) {
		this.id_pokemon_sauvage = id_pokemon_sauvage;
	}

	public void setId_pokemon_joueur(int id_pokemon_joueur) {
		this.id_pokemon_joueur = id_pokemon_joueur;
	}
	
	
}
