<?php

$portefeuille = [
    'solde' => 0,
    'totalDepenses' => 0,
];

$transactions = [];
$nombreRetraits = 0;
$cinList = [];

function ajouterCIN($numeroCIN, $nomTitulaire) {
    global $cinList;
    $cin = [
        'numero' => $numeroCIN,
        'nom' => $nomTitulaire,
    ];
    $cinList[] = $cin;
    echo "La CIN $numeroCIN de $nomTitulaire a été ajoutée.\n";
}

function ajouterArgent($montant) {
    global $portefeuille, $transactions;
    if ($montant <= 0) {
        echo "Le montant doit être supérieur ou égal à 0.\n";
    } else {
        $portefeuille['solde'] += $montant;
        enregistrerTransaction("Dépôt", $montant);
        echo "Le solde du portefeuille est maintenant de {$portefeuille['solde']} ariary.\n";
    }
}

function retirerArgent($montant) {
    global $portefeuille, $transactions, $nombreRetraits;
    if ($montant <= 0) {
        echo "Le montant doit être supérieur ou égal à 0.\n";
    } elseif ($montant > $portefeuille['solde']) {
        echo "Le montant à retirer est supérieur au solde du portefeuille.\n";
    } elseif ($nombreRetraits >= 3) {
        echo "Limite de retraits atteinte. Vous ne pouvez pas effectuer plus de 3 retraits.\n";
    } else {
        $portefeuille['solde'] -= $montant;
        enregistrerTransaction("Retrait", $montant);
        $nombreRetraits++;
        echo "Le solde du portefeuille est maintenant de {$portefeuille['solde']} ariary.\n";
    }
}

function afficherSolde() {
    global $portefeuille;
    echo "Le solde du portefeuille est de {$portefeuille['solde']} ariary.\n";
}

function afficherHistorique() {
    global $transactions;
    echo "\nHistorique des transactions :\n";
    foreach ($transactions as $transaction) {
        echo "{$transaction['type']} de {$transaction['montant']} ariary le {$transaction['date']}\n";
    }
    echo "\n";
}

function enregistrerTransaction($type, $montant) {
    global $transactions, $portefeuille;
    $transaction = [
        'type' => $type,
        'montant' => $montant,
        'date' => date("Y-m-d H:i:s"),
    ];
    $transactions[] = $transaction;

    if ($type === "Retrait") {
        $portefeuille['totalDepenses'] += $montant;
    }
}

function afficherCINList() {
    global $cinList;
    echo "\nListe des CIN enregistrées :\n";
    foreach ($cinList as $cin) {
        echo "CIN {$cin['numero']} - Titulaire: {$cin['nom']}\n";
    }
    echo "\n";
}

function afficherTotalDepenses() {
    global $portefeuille;
    echo "Le total des dépenses est de {$portefeuille['totalDepenses']} ariary.\n";
}

$choix = 0;

while ($choix !== 7) {
    echo "Que voulez-vous faire ?\n";
    echo "1. Ajouter de l'argent\n";
    echo "2. Retirer de l'argent\n";
    echo "3. Afficher le solde\n";
    echo "4. Afficher l'historique des transactions\n";
    echo "5. Ajouter une CIN\n";
    echo "6. Afficher le total des dépenses\n";
    echo "7. Quitter\n";

    $choix = (int) readline("Votre choix : ");

    switch ($choix) {
        case 1:
            $montantAjout = (int) readline("Montant à ajouter : ");
            ajouterArgent($montantAjout);
            break;
        case 2:
            $montantRetrait = (int) readline("Montant à retirer : ");
            retirerArgent($montantRetrait);
            break;
        case 3:
            afficherSolde();
            break;
        case 4:
            afficherHistorique();
            break;
        case 5:
            $numeroCIN = readline("Numéro de CIN : ");
            $nomTitulaire = readline("Nom du titulaire : ");
            ajouterCIN($numeroCIN, $nomTitulaire);
            break;
        case 6:
            afficherTotalDepenses();
            break;
        case 7:
            echo "Au revoir !\n";
            break;
        default:
            echo "Choix incorrect.\n";
    }
}
?>
