package jeu.eu.ensg;

public class Pokemon extends Type
{	//ajouter un getCoord();
	public void PV(int PvMax, int degat, int PvRestant)
	{
	public int getDegat() {
		return degat;
	}
	public void setDegat(int degat) {
		this.degat = degat;
	}
	public int getPvRestant() {
		return PvRestant;
	}
	public void setPvRestant(int pvRestant) {
		PvRestant = pvRestant;
	}
	public int getPvMax() {
		return PvMax;
	}
	public void setPvMax(int pvMax) {
		PvMax = pvMax;
	}
	
	}
	public PokemonId(int Id) 
	{
		
	}
	
	int PvMax;
	private int degat;
	private int PvRestant;
	private int PvMax;
	private PokemonIdList = 
	{
		{1, Bulbasaur},
		{2, Ivysaur},
		{3, Venusaur},
		{4, VenusaurMega Venusaur},
		{5, Charmander},
		{6, Charmeleon},
		{7, Charizard},
		{8, CharizardMega Charizard X},
		{9, CharizardMega Charizard Y},
		{10,Squirtle},
		{11,Wartortle},
		{12,Blastoise},
		{13,BlastoiseMega Blastoise},
		{14,Caterpie},
		{15,Metapod},
		{16,Butterfree},
		{17,Weedle},
		{18,Kakuna},
		{19,Beedrill},
		{20,BeedrillMega Beedrill},
		{21,Pidgey},
		{22,Pidgeotto},
		{23,Pidgeot},
		{24,PidgeotMega Pidgeot},
		{25,Rattata},
		{26,Raticate},
		{27,Spearow},
		{28,Fearow},
		{29,Ekans},
		{30,Arbok},
		{31,Pikachu},
		{32,Raichu},
		{33,Sandshrew},
		{34,Sandslash},
		{35,Nidoran♀},
		{36,Nidorina},
		{37,Nidoqueen},
		{38,Nidoran♂},
		{39,Nidorino},
		{40,Nidoking},
		{41,Clefairy},
		{42,Clefable},
		{43,Vulpix},
		{44,Ninetales},
		{45,Jigglypuff},
		{46,Wigglytuff},
		{47,Zubat},
		{48,Golbat},
		{49,Oddish},
		{50,Gloom},
		{51,Vileplume},
		{51,Paras},
		{52,Parasect},
		{53,Venonat},
		{54,Venomoth},
		{55,Diglett},
		{56,Dugtrio},
		{57,Meowth},
		{58,Persian},
		{59,Psyduck},
		{60,Golduck},
		{61,Mankey},
		{62,Primeape},
		{63,Growlithe},
		{64,Arcanine},
		{65,Poliwag},
		{66,Poliwhirl},
		{67,Poliwrath},
		{68,Abra},
		{69,Kadabra},
		{70,Alakazam},
		{71,AlakazamMega Alakazam},
		{72,Machop},
		{73,Machoke},
		{74,Machamp},
		{75,Bellsprout},
		{76,Weepinbell},
		{77,Victreebel},
		{78,Tentacool},
		{79,Tentacruel},
		{80,Geodude},
		{81,Graveler},
		{82,Golem},
		{83,Ponyta},
		{84,Rapidash},
		{85,Slowpoke},
		{86,Slowbro},
		{87,SlowbroMega Slowbro},
		{88,Magnemite},
		{89,Magneton},
		{90,Farfetch'd},
		{91,Doduo},
		{92,Dodrio},
		{93,Seel},
		{94,Dewgong},
		{95,Grimer},
		{96,Muk},
		{97,Shellder},
		{98,Cloyster},
		{99,Gastly},
		{100,Haunter},
		{101,Gengar},
		{102,GengarMega Gengar},
		{103,Onix},
		{104,Drowzee},
		{105,Hypno},
		{106,Krabby},
		{107,Kingler},
		{108,Voltorb},
		{109,Electrode},
		{110,Exeggcute},
		{111,Exeggutor},
		{112,Cubone},
		{113,Marowak},
		{114,Hitmonlee},
		{115,Hitmonchan},
		{116,Lickitung},
		{117,Koffing},
		{118,Weezing},
		{119,Rhyhorn},
		{120,Rhydon},
		{121,Chansey},
		{122,Tangela},
		{123,Kangaskhan},
		{124,KangaskhanMega Kangaskhan},
		{125,Horsea},
		{126,Seadra},
		{127,Goldeen},
		{128,Seaking},
		{129,Staryu},
		{130,Starmie},
		{131,Mr. Mime},
		{132,Scyther},
		{133,Jynx},
		{134,Electabuzz},
		{135,Magmar},
		{136,Pinsir},
		{137,PinsirMega Pinsir},
		{138,Tauros},
		{139,Magikarp},
		{140,Gyarados},
		{141,GyaradosMega Gyarados},
		{142,Lapras},
		{143,Ditto},
		{144,Eevee},
		{145,Vaporeon},
		{146,Jolteon},
		{147,Flareon},
		{148,Porygon},
		{149,Omanyte},
		{150,Omastar},
		{151,Kabuto},
		{152,Kabutops},
		{153,Aerodactyl},
		{154,AerodactylMega Aerodactyl},
		{155,Snorlax},
		{156,Articuno},
		{157,Zapdos},
		{158,Moltres},
		{159,Dratini},
		{160,Dragonair},
		{161,Dragonite},
		{162,Mewtwo},
		{163,MewtwoMega Mewtwo X},
		{164,MewtwoMega Mewtwo Y},
		{165,Mew},
	}
		public boolean EtatPokemon()
		{
			PV = getPV();
			Id = getId();
			if (PV < 1) {
				return "Le Pk
			}
		}
}
