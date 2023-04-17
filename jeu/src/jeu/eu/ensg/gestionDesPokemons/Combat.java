package gestionDesPokemons ;

public class Combat {

    private Pokemon pokemonS = //!pokemon choisis par le joueur ;
    private Pokemon pokemonD ;
    private int hpS = pokemonS.getHP() ;
    private int hpD = pokemonD.getHP() ;
    private int degatsInit = 20 ;


    public changerPok() {
        System.out.println(MainJoueur.ListeDePokemonsCaptures)
        pokemonD = clique(pokemonMDJ) ; }

    public attaque(typAtk, Pokemon PA, Pokemon DD) {
        Famille famA = getFamille(PA) ;
        Famille famD = getFamille(DD) ;
        public int degats ;

        if (typAtk == neutre) { 
            degats = 20 }
        if (typAtk == element) {
            //!se referer au tableau
            degats = (int) degatsInit * coeff  }

        if (PD == pokemonS) { 
            hpS -= degats  }
        else { hpD -= degats  }

        System.out.println(PA.getPokemon() + " a infligé " + degats + " dégâts à " DD.getPokemon())
    }

    public fuite() {
        //!quitte le combat
        System.out.println("Tu t'enfuies !") }

    public void derouleCombat() {
        
        public int i = 0 ;
        changerPok()

        while (hpS > 0 && hpD > 0) {

            if (i % 2 = 0) {
                Pokemon PD = pokemonD ;
                Pokemon PS = PokemonS ;

                //Le joueur clique sur une option
                if (clique = fuite) {
                    fuite()
                }

                if (clique = attaque_neutre) {
                    attaque(neutre, PD, PS)
                }

                if (clique = attaque_element) {
                    attaque(element, PD, PS)
                }

                if (clique = changerPok) {
                    changerPok()
                }
            }

            else {
                Pokemon PD = pokemonS ;
                Pokemon DS = pokemonD ;
                if (random > 0.5) {
                    attaque(neutre, PS, PD) }
                else {
                    attaque(element, PS, PD) }
            }

            System.out.println(pokemonD.getPokemon() + " a " + hpD + " HP !")
            System.out.println(pokemonS.getPokemon() + " a " + hpS + " HP !")

            i += 1
        }
    }
}