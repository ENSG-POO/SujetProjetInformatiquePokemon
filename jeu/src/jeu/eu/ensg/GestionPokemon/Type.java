package GestionPokemon;

// Création de l'interface Type
public interface Type {
	String getName();
    double getEffectiveness(Type type);
}

// Lors de la définition d'un type, on définit son nom, mais aussi l'efficacité des autres types sur lui via une méthode renvoyant un entier. 
//Celle-ci prend chaque cas en compte un par un.
