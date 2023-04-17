package jeu.eu.ensg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pokemon extends Type
{	
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
	public getCoord(int Id)
	{
		String PokemonName = PokemonIdList[Id];
		String PokemonCoordCsv = "/home/aitor/MateusLopezBounan/data";
		List PokemonCoord;
		String delimiter = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(PokemonCoordCsv))) 
			{
		String line;
		while ((line = br.readLine()) <165) {
		      String[] cells = line.split(delimiter);
		      String cellData = cells[1];
		      PokemonCoord += cellData;
		         }
		    } 
		catch (IOException e) 
			{
		       e.printStackTrace();
		    }
		@Override
		String toString()
			{
			return "Le pokemon"+PokemonName+"est situé en"+PokemonCoord;
		    }
	}
	private char PokemonName
	private boolean EtatPokemon;
	private int PvMax;
	private int degat;
	private int PvRestant;
	private int PvMax;
}
