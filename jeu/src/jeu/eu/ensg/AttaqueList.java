package jeu.eu.ensg;

import java.util.List;

public class AttaqueList {
	private List<attaque> attaques;

	public AttaqueList(List<attaque> attaques) {
		this.attaques = attaques;
	}

	public AttaqueList() throws Exception {
		List<attaque> poke = Inventaire.charger_csv_attaque();
		this.attaques = poke;
	}

	public void ajouter_attaque(attaque p) {
		int taille = this.attaques.size();
		this.attaques.add(p); // on ajoute le attaque a la liste
		p.setId(taille); // on definit l indice du attaque comme le dernier de la liste
	}

	public void supprimer_attaque(attaque p) {
		int taille = this.attaques.size();
		this.attaques.remove(p.getId()); // on supprime le attaque de la liste
		for (int i = p.getId() + 1; i < taille; i++) { // pour chaque attaque plus loin dans la liste
			attaque poke = this.attaques.get(i);
			poke.setId(poke.getId() - 1); // on abaisse la valeur de son indice de 1
		}
	}

	public List<attaque> getattaques() {
		return attaques;
	}

	public attaque getattaque(int id) {
		attaque a = attaques.get(id);
		return a;
	}

	public double getPuissance(int id) {
		attaque a = attaques.get(id);
		double b = a.getPuissance();
		return b;
	}
	public int getPrecision(int id) {
		attaque a = attaques.get(id);
		int b = a.getPrecision();
		return b;
	}
	@Override
	public String toString() {
		return "attaque [attaques=" + attaques + "]";
	}

}
