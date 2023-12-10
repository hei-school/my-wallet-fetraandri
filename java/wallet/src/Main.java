import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    // Représenter une CIN
    static class CIN {
        String numero;
        String nom;

        CIN(String numero, String nom) {
            this.numero = numero;
            this.nom = nom;
        }
    }

    // Représenter une transaction
    static class Transaction {
        String type;
        int montant;
        String date;

        Transaction(String type, int montant) {
            this.type = type;
            this.montant = montant;
            this.date = new Date().toString();
        }
    }

    // Variables globales pour le portefeuille, les transactions, les retraits, les CIN et le total des dépenses
    static int solde = 0;
    static ArrayList<Transaction> transactions = new ArrayList<>();
    static int nombreRetraits = 0;
    static ArrayList<CIN> cinList = new ArrayList<>();
    static int totalDepenses = 0;

    // Ajouter une CIN
    public static void ajouterCIN(String numero, String nom) {
        CIN cin = new CIN(numero, nom);
        cinList.add(cin);
        System.out.println("La CIN " + numero + " de " + nom + " a été ajoutée.");
    }

    // Ajouter de l'argent au portefeuille
    public static void ajouterArgent(int montant) {
        if (montant > 0) {
            solde += montant;
            enregistrerTransaction("Dépôt", montant);
            System.out.println("Le solde du portefeuille est maintenant de " + solde + " ariary.");
        } else {
            System.out.println("Le montant doit être supérieur ou égal à 0.");
        }
    }

    // Retirer de l'argent du portefeuille
    public static void retirerArgent(int montant) {
        if (montant > 0) {
            if (montant <= solde) {
                solde -= montant;
                enregistrerTransaction("Retrait", montant);
                nombreRetraits++;
                totalDepenses += montant; // Mettre à jour le total des dépenses
                System.out.println("Le solde du portefeuille est maintenant de " + solde + " ariary.");
            } else {
                System.out.println("Le montant à retirer est supérieur au solde du portefeuille.");
            }
        } else {
            System.out.println("Le montant doit être supérieur ou égal à 0.");
        }
    }

    // Afficher le solde
    public static void afficherSolde() {
        System.out.println("Le solde du portefeuille est de " + solde + " ariary.");
    }

    // Afficher l'historique des transactions
    public static void afficherHistorique() {
        System.out.println("\nHistorique des transactions :");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.type + " de " + transaction.montant + " ariary le " + transaction.date);
        }
        System.out.println("\n");
    }

    // Enregistrer une transaction dans l'historique
    public static void enregistrerTransaction(String type, int montant) {
        Transaction transaction = new Transaction(type, montant);
        transactions.add(transaction);
    }

    // Afficher la liste des CIN
    public static void afficherCINList() {
        System.out.println("\nListe des CIN enregistrées :");
        for (CIN cin : cinList) {
            System.out.println("CIN " + cin.numero + " - Titulaire: " + cin.nom);
        }
        System.out.println("\n");
    }

    // Afficher le total des dépenses
    public static void afficherTotalDepenses() {
        System.out.println("Le total des dépenses est de " + totalDepenses + " ariary.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        while (choix != 7) {
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Ajouter de l'argent");
            System.out.println("2. Retirer de l'argent");
            System.out.println("3. Afficher le solde");
            System.out.println("4. Afficher l'historique des transactions");
            System.out.println("5. Ajouter une CIN");
            System.out.println("6. Afficher le total des dépenses");
            System.out.println("7. Quitter");

            // Lire le choix
            choix = scanner.nextInt();

            // Les menus
            if (choix == 1) {
                System.out.print("Montant à ajouter : ");
                int montantAjout = scanner.nextInt();
                ajouterArgent(montantAjout);
            } else if (choix == 2) {
                System.out.print("Montant à retirer : ");
                int montantRetrait = scanner.nextInt();
                retirerArgent(montantRetrait);
            } else if (choix == 3) {
                afficherSolde();
            } else if (choix == 4) {
                afficherHistorique();
            } else if (choix == 5) {
                scanner.nextLine(); // Pour consommer la nouvelle ligne restante après le nextInt
                System.out.print("Numéro de CIN : ");
                String numeroCIN = scanner.nextLine();
                System.out.print("Nom du titulaire : ");
                String nomTitulaire = scanner.nextLine();
                ajouterCIN(numeroCIN, nomTitulaire);
            } else if (choix == 7) {
                System.out.println("Au revoir !");
            } else if (choix == 6) {
                afficherTotalDepenses();
            } else {
                System.out.println("Choix incorrect.");
            }
        }
    }
}
