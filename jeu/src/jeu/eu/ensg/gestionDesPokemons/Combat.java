package gestionDesPokemons ;

import Math.random();
import java.awt.event.* ;

public class Combat {
    private Pokemon pokemonS = ; //!pokemon choisit par le joueur ;
    private Pokemon pokemonD ;
    private int hpS = pokemonS.getHP() ;
    private int hpD = pokemonD.getHP() ;
    
    public changerPok() {
        //!afficher les pokemons MDJ
        pokemonD = ActionListener(pokemonMDJ) ;
        System.out.println("Tu as choisis " + pokemonD) ;
    }

    public attaque(typAtk, Pokemon PA, Pokemon DD) {
        Famille famA = getFamille(PA) ;
        famAtk = Famille.famA ;
        Famille famD = getFamille(DD) ;

        if (typAtk == NEUTRE) {
            degats = 20 ; }
        else {
            coef = famAtk.famD ;
            degats = (int) coef * 20 ; }
        
        if (PA == pokemonS) {
            hpD -= degats  ;
            System.out.println(pokemonS.getPokemon + " a infligé " + degats + " dégâts à " + pokemonD.getPokemon ;)
        }
        else {
            hpS -= degats  ;
            System.out.println(pokemonD.getPokemon + " a infligé " + degats + " dégâts à " + pokemonS.getPokemon ;)
        }
        
        System.out.println(pokemonS.getPokemon + " a " + hpS + " HP !") ;
        System.out.println(pokemonD.getPokemon + " a " + hpD + " HP !") ;

    }

    public fuite() {
        System.out.println("Tu t'enfuies !") ;
        break ;
    }

    public static void main(String[] args) {
        
        public int i = 0 ;
        changerPok() ;

        while (hpS>0 && hpD>0) {

            if (i % 2 = 0) {

                //Le joueur clique sur une option
                if (clique = fuite) {
                    fuite() ; }

                if (clique = attaque_neutre) {
                    attaque(neutre, pokemonD, pokemonS) ; }

                if (clique = attaque_element) {
                    attaque(element, pokemonD, pokemonS) ; }

                if (clique = changerPok) {
                    changerPok() ; }
            }

            else {
                PA = pokemonS ;
                DD = pokemonD ;
                if (Math.random > 0.5) {
                    attaque(neutre, pokemon, pokemonD) ; }

                else {
                    attaque(element, pokemonS, pokemonD) ; }
            }

            i += 1 ;
        }
    }
}