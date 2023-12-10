const prompt = require('prompt-sync')();

let portefeuille = {
  solde: 0,
  totalDepenses: 0,
};

let transactions = [];
let nombreRetraits = 0;
let cinList = [];

// Ajouter une CIN
function ajouterCIN(numeroCIN, nomTitulaire) {
  let cin = {
    numero: numeroCIN,
    nom: nomTitulaire,
  };
  cinList.push(cin);
  console.log(`La CIN ${numeroCIN} de ${nomTitulaire} a été ajoutée.`);
}

// ajout de l'argent
function ajouterArgent(montant) {
  if (montant <= 0) {
    console.log("Le montant doit être supérieur ou égal à 0.");
  } else {
    portefeuille.solde += montant;
    enregistrerTransaction("Dépôt", montant);
    console.log("Le solde du portefeuille est maintenant de " + portefeuille.solde + " ariary.");
  }
}

// retirer de l'argent
function retirerArgent(montant) {
  if (montant <= 0) {
    console.log("Le montant doit être supérieur ou égal à 0.");
  } else if (montant > portefeuille.solde) {
    console.log("Le montant à retirer est supérieur au solde du portefeuille.");
  } else if (nombreRetraits >= 3) {
    console.log("Limite de retraits atteinte. Vous ne pouvez pas effectuer plus de 3 retraits.");
  } else {
    portefeuille.solde -= montant;
    enregistrerTransaction("Retrait", montant);
    nombreRetraits++;
    console.log("Le solde du portefeuille est maintenant de " + portefeuille.solde + " ariary.");
  }
}

//afficher les soldes 
function afficherSolde() {
  console.log("Le solde du portefeuille est de " + portefeuille.solde + " ariary.");
}

//afficher l'historique
function afficherHistorique() {
  console.log("\nHistorique des transactions :");
  transactions.forEach((transaction) => {
    console.log(`${transaction.type} de ${transaction.montant} ariary le ${transaction.date}`);
  });
  console.log("\n");
}

function enregistrerTransaction(type, montant) {
  let transaction = {
    type: type,
    montant: montant,
    date: new Date().toLocaleString(),
  };
  transactions.push(transaction);

  if (type === "Dépôt") {
    // portefeuille.solde += montant;
  } else if (type === "Retrait") {
    portefeuille.solde -= montant;
    portefeuille.totalDepenses += montant;
  }
}



function afficherCINList() {
  console.log("\nListe des CIN enregistrées :");
  cinList.forEach((cin) => {
    console.log(`CIN ${cin.numero} - Titulaire: ${cin.nom}`);
  });
  console.log("\n");
}

function afficherTotalDepenses() {
  console.log("Le total des dépenses est de " + portefeuille.totalDepenses + " ariary.");
}

let choix;

do {
  console.log("Que voulez-vous faire ?");
  console.log("1. Ajouter une CIN");
  console.log("2. Ajouter de l'argent");
  console.log("3. Retirer de l'argent");
  console.log("4. Afficher le solde");
  console.log("5. Afficher l'historique des transactions");
  console.log("6. Afficher la liste des CIN");
  console.log("7. Afficher le total des dépenses");
  console.log("8. Quitter");

  choix = prompt("Votre choix : ");
  choix = parseInt(choix);

  if (choix === 1) {
    let numeroCIN = prompt("Numéro de CIN : ");
    let nomTitulaire = prompt("Nom du titulaire : ") ; 
    ajouterCIN(numeroCIN, nomTitulaire);
  } else if (choix === 2) {
    let montantAjout = prompt("Montant à ajouter : ");
    montantAjout = parseInt(montantAjout);
    ajouterArgent(montantAjout);
  } else if (choix === 3) {
    let montantRetrait = prompt("Montant à retirer : ");
    montantRetrait = parseInt(montantRetrait);
    retirerArgent(montantRetrait);
  } else if (choix === 4) {
    afficherSolde();
  } else if (choix === 5) {
    afficherHistorique();
  } else if (choix === 6) {
    afficherCINList();
  } else if (choix === 8) {
    console.log("Au revoir !");
  } else if (choix === 7) {
    afficherTotalDepenses();
  } else {
    console.log("Choix incorrect.");
  }
} while (choix !==8);
