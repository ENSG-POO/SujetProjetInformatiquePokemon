package pack1;

import java.util.ArrayList;
import java.util.List;

//classe qui permet, avec la méthode idType de transformer le type du pokémon (qui est 
// un string) en un integer: cette integer permet ensuite de retrouver les coefficients d'attaque spéciale des 
// pokémons en fonction du type du pokémon qui attaque et de celui qui défend 

public class Type {
	public String type[] = { "Steel", "Fighting","Dragon","Water","Fire","Electric","Fairy","Ice","Bug","Normal","Grass","Poison","Psychic","Rock","Ground","Gosth","Dark","Flying" };


	public int idType(String a) {
		int i = 0;
		 while (i < type.length) {
	     if (type[i].equals(a) ) {
	     return i;
	           }
	     else {
	     i = i + 1;
	}
	}
		return 20000;
	
	}
	
	
}

