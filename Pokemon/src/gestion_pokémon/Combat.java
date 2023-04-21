/*package gestion_pokémon;

import java.util.ArrayList;

public class Combat {
	
	Pokemon poke1;
	Pokemon poke2;
	
	public Combat (Pokemon poke1, Pokemon poke2) {
		this.poke1=poke1;
		this.poke2=poke2;
	}
	
	public void début_combat(Coordinate position) {
		if (c == 1) {
			System.out.println("tu prends la fuite gros naze !");
			this.position.setY(position.getY()+1); 		
		}
		
		if (c ==0) {
			System.out.println("le combat commence !");
			
			if (poke1.getspeed()> poke2.getspeed()) {
				poke1 = this.attaquant;
			}
			
			else {poke2= this.attaquant; }
			
			
		}
	}
	
	
	
	public double Degat (double AttackN, double AttackS, Pokemon defenseur, Pokemon attaquant) {
		
		double degat = 0;
	   
	    
		if (d==0) {
			
			degat = this.defenseur.getHP() -this.attaquant.getAttackN();
			
			defenseur.setHP(degat);
			return defenseur.getHP();
		}
		
		if (d==1) {
			
			if (this.defenseur.gettype().equals(this.attaquant.gettype())) {
				
				degat = this.defenseur.getHP() -  this.attaquant.getAttackS()*coeffs[attaquant.gettype()][attaquant.gettype()]*1.5;
				defenseur.setHP(degat);
			}
			
			
			else { 
				
				degat = this.defenseur.getHP() -  this.attaquant.getAttackS()*coeffs[attaquant.gettype()][attaquant.gettype()];
				defenseur.setHP(degat);
			}
			
			return defenseur.getHP();
		}
		
		
	}
	
	
	public Pokemon Pokerestants(Pokemon poke1) {
		
		for (Pokemon combattants : Pokemon.utilisable) {
			ArrayList<Pokemon> pokeDisponibles = new ArrayList<>();
					
            if (combattants.getHP() > 0 ){
            	
            	 PokeDisponibles.add(combattants) ;	
            	}
            }    
	}
	

	
	@Override
	public String toString() {
		return " voici les pokemons disponibles: " + "1"= PokeDisponibles.get(0) + "2"= PokeDisponibles.get(1) + "3" = PokeDisponibles.get(2) + "4"=PokeDisponibles.get(3);
	}


	public Pokemon Changement(Pokemon Pokerestants) {
		
		if (f==1) { poke1 =  PokeDisponibles.get(0);}
		if (f==2) { poke1 =  PokeDisponibles.get(1);}
		if (f==3) { poke1 =  PokeDisponibles.get(2);}
		if (f==4) { poke1 =  PokeDisponibles.get(3);}
	}
	
	
	
	}
*/