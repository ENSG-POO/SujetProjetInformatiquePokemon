# Pokémon: projet informatique

testing
Test Marie-Dominique

TESTTT 

## Matériel de départ

#### Dans le répertoire "document", vous avez:

* la présentation du projet informatique (ProjetInfo_Ing1_2023.pdf)
* des exemples de règles de combat entre les pokémons (MondePokemon.pdf)
* le support de cours des interfaces graphiques

#### Dans le répertoire "data", vous avez:

* Un fichier csv contenant les 150 pokemons de la première génération, ainsi que leurs attributs.
* Les attributs:
  1. Total:
  2. HP:
  3. Attack:
  4. Defense:
  5. Sp. Atk:
  6. Sp. Def:
  7. Speed:
  8. Generation:
  9. Legendary:

* Un fichier csv contenant une liste de pokemons avec des coordonnées géographiques.

#### Dans le répertoire "jeu", vous avez:

* Squelette d'un projet Java qui contient quelques classes qui construisent une interface graphique pour démarrer le jeu

Pour tester l'interface graphique:

1. Importer le projet Java dans Eclipse
2. Lancer la classe MainApplication


## Comment créer votre dépôt github ?

1. Se créer un identifiant github
2. Demander à un enseignant de vous ajouter dans le dépôt
3. Fork ....


####Instructions d'exécution
\n
Ouvrir le fichier "MainApplication.java" pour lancer le jeu.
\n

##Scripts \n
####Noyau
*"attaque.java": construit les variables où seront incrémentées les informations associées (id, type, puissance et précision)  
*"AttaqueList.java": incrémente les informations liées aux attaques à partir des fichiers ".csv"  
*"Carte.java": construit la carte et incrémente les coordonnées des différents pokemons depuis les ".csv"  
*"combat.java": rassemble les données nécessaires à la constrution de la fenêtre combat,  
*"Coordonnee.java": construire les coordonnées à remplir ensuite,  
*"Dresseur.java": construit les attributs liées au dresseur (noms, pokemon, coordonnées), 
*"Inventaire.java": incrémente les pokemons capturés ajoutés aux pokemons de départ ainsi que les types associés,  
*"Lecture_pokemons.java": incrémente les pokemons sauvages dans les environs du dresseur,  
*"ListType.java" charge et affiche les types des pokemons,  
*"Localisation.java": rassemble les attributs utiles pour localiser les pokemons,  
*"MainApplication.java": exécute le reste,  
*"PokeListe.java": charge les pokemons dans les environs,  
*"Pokemon.java": rassemble les informations de chaque pokemon pour les rendre utilisables par les autres classes,  
*"type.java": le tableau des types...sous forme de double array,  
  
  
##Interface graphique  
*"CartePanel.java": construit la fenêtre de la carte en y implémentant les pokemons en fonction de leur coordonnées,  
*"Combat_temporaire.java": construit l'interface du combat,  
*"ControlePanel.class": permet au joueur de mener les combats en cours,  
*"FichePanel.class": construit la fenêtre permettant de choisir un pokemon sauvage à affronter,  
*"MenuDeroulant.java": affiche le choix entre pokemons,  
*"TwoImagesExample.java": affiche les images des deux pokemons,  
   
