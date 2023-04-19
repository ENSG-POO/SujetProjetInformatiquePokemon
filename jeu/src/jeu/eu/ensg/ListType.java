package jeu.eu.ensg;

import java.util.List;

public class ListType {
	private List<type> types;
	
	public ListType() throws Exception {
		List<type> type = Inventaire.charger_type();
		this.types = type;
	}
	
	public ListType(List<type> types) {
		this.types = types;
	}



	public List<type> gettypes() {
		return types;
	}
	public type gettypes(int id) {
		return types.get(id);
	}

	@Override
	public String toString() {
		return "type [types=" + types + "]";
	}
}

