# Tuto : Se connecter à Github via ssh

Afin de faciliter les accès à github, vous connecterez votre ordinateur à votre compte github via ssh.

La méthode par authentification avec mot de passe requiert de s'authentifier à chaque push sur github.

La clef ssh est lié à un ordinateur. Si vous changer d'ordinateur durant la semaine, vous devrez créer une nouvelle clef.
Il faudra néanmoins penser en fin de projet à  supprimer les clefs ssh enregistrées sur votre compte github afin que quelqu'un d'autre ne puisse pas se connecter à votre compte.

Le tuto complet [ici](https://www.atlassian.com/git/tutorials/git-ssh)

## Première étape : créer une clef ssh

Le tuto long : [ici](https://www.howtogeek.com/762863/how-to-generate-ssh-keys-in-windows-10-and-windows-11/)

Pour créer une clef ssh, il faut :

- ouvrir un terminal (Powershell, WSL, ...)
- lancer la commande "ssh-keygen"
- accepter toutes les questions sans les modifier (En appuyant sur la touche "entrée" à chaque question)

Votre clef sera alors généré à l'emplacement par défaut : C:\Users\*votre User*/.ssh/id_rsa.pub

Affichez là ensuite dans votre terminal avec la commande suivante :

```bash
cat C:\Users\*votre User*/.ssh/id_rsa.pub
```

Vous devrez la copier pour l'étape suivante.

## Seconde étape : ajouter votre clef publique à github

Vous devez ajouter votre clé ssh publique à votre compte github.

Pour faire cela, vous devez :

- Ouvrir votre profil github
- Sélectionnez l'onglet "SSH and GPG Keys"
- Sélectionner "New SSH Key"
- Coller votre clé SSH dans l'emplacement prévu
- Donner un titre à votre clef "projet_POO" par exemple.

Et je répète ici : Il faudra penser en fin de semaine à supprimer votre ou vos clefs ssh enregistrée(s) sur votre compte github.

## Troisième étape : mettre à jour l'url de votre repo git

Vous avez auy début utilisé le lien https de votre repo git, vous devez mettre à jour l'url sur votre ordinateur.

Pour cela :

- récupérer sur git le lien ssh (dans votre repo le bouton "code", puis "ssh")
- depuis un terminal ouvert dans votre repository git, tappez la commande : 

```bash
git remote set-url origin *votre adresse ssh*
```
