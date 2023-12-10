# Application de Portefeuille

Cette application de portefeuille est conçue pour gérer les transactions financières, suivre l'historique des opérations, et inclut des fonctionnalités telles que l'ajout d'argent, le retrait, l'affichage du solde, la consultation de l'historique des transactions, l'ajout de CIN, et le calcul du total des dépenses.

## Langages de Programmation

L'application est implémentée en utilisant plusieurs langages de programmation :

1. **Java**
2. **JavaScript** (Node.js)
3. **Python**
4. **PHP**

## Java

Le code Java est structuré en classes pour représenter les transactions et les CIN. Les fonctionnalités principales incluent l'ajout et le retrait d'argent, l'affichage du solde, l'affichage de l'historique des transactions, l'ajout de CIN, et le calcul du total des dépenses.

## JavaScript (Node.js)

Le code JavaScript utilise Node.js pour l'exécution côté serveur. Il propose des fonctionnalités similaires à la version Java avec une interface en ligne de commande (CLI) pour l'interaction.

## Python

La version Python offre une expérience interactive en ligne de commande avec des fonctionnalités identiques à celles des versions Java et JavaScript. Elle utilise le module `datetime` pour gérer les dates.

## PHP

L'implémentation PHP est également basée sur une interface en ligne de commande (CLI). Elle propose les mêmes fonctionnalités que les autres versions, avec une gestion des transactions et un suivi du solde.

## Utilisation

1. **Ajouter de l'argent :** Permet d'ajouter un montant au solde du portefeuille.
2. **Retirer de l'argent :** Autorise le retrait d'un montant du solde du portefeuille, avec gestion des retraits limités.
3. **Afficher le solde :** Affiche le solde actuel du portefeuille.
4. **Afficher l'historique des transactions :** Liste toutes les transactions effectuées.
5. **Ajouter une CIN :** Enregistre une nouvelle carte d'identité nationale (CIN) avec un numéro et un nom de titulaire.
6. **Afficher la liste des CIN :** Affiche la liste des cartes d'identité nationale enregistrées.
7. **Calculre les dépenses:** Affiche les dépenses au total des retrait qu'on a fait
8. **Au maximum ,3 retrait:** On ne peut pas faire que 3 retrait lors de lancement de application   
9. **Quitter :** Termine l'application.

## Scripts d'Exécution

```bash
# Assurez-vous d'avoir Node.js installé
# Exécutez le script wallet.js avec Node.js

node wallet.js

# Exécutez le script wallet.py avec Python

python wallet.py

# Assurez-vous que PHP est installé
# Exécutez le script wallet.php avec PHP

php wallet.php

# Assurez-vous d'avoir Java JDK installé
# Compilez le fichier Main.java
# pour simplifier l'éxecution de code et la compilation de code  , utilisé des éditeur de code comme IntelliJ, Eclipse sans taper les commandes javac, et  java wallet.js

# Exécutez le programme Java

java Main


