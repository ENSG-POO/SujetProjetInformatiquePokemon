package pack1;

import java.util.ArrayList;
import java.util.List;

public class Type {
	public String type[] = { "Steel", "Fighting","Dragon","Water","Fire","Electric","Fairy","Ice","Bug","Normal","Grass","Poison","Psychic","Rock","Ground","Gosth","Dark","Flying" };


	public int idType(String a) {
		int i = 0;
		 while (i < type.length) {
	     if (type[i] == a ) {
	     return i;
	           }
	     else {
	     i = i + 1;
	}
	}
		return 20000;
	
	}
	
}

