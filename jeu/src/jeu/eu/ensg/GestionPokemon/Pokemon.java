package jeu.eu.ensg.GestionPokemon;

public class Pokemon {
    public int id;
    public String name;
    public String type1;
    public String type2;
    public int total;
    public int hp;
    public int attack;
    public int defense;
    public int spAtk;
    public int spDef;
    public int speed;
    public boolean EtatPokemon;

    //constructeur d'un pokemon S
    public Pokemon(int id, String name, String type1, String type2, int total, int hp, int attack, int defense, int spAtk, int spDef, int speed, boolean EtatPokemon) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
        this.EtatPokemon = false; // false correspond a un état sauvage, true a l'état capturer
    }
    
    
    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public boolean getEtatPokemon() {
    	return EtatPokemon;
    }
    
    public void setEtatPokemon(boolean EtatPokemon) {
    	this.EtatPokemon = EtatPokemon;
    }
    
    @Override
    public String toString() {
        return "Pokemon {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", specialAttack=" + spAtk +
                ", specialDefense=" + spDef +
                ", speed=" + speed + "le pokemon est-il capture =" + EtatPokemon+
                '}';
    }
}

