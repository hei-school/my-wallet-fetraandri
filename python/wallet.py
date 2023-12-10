import datetime

# Déclaration du portefeuille
portefeuille = {
    'solde': 0,
    'total_depenses': 0,
}

transactions = []
nombre_retraits = 0
cin_list = []

# Ajouter une CIN
def ajouter_cin(numero_cin, nom_titulaire):
    cin = {
        'numero': numero_cin,
        'nom': nom_titulaire,
    }
    cin_list.append(cin)
    print(f"La CIN {numero_cin} de {nom_titulaire} a été ajoutée.")

# Ajouter de l'argent
def ajouter_argent(montant):
    global nombre_retraits
    if montant <= 0:
        print("Le montant doit être supérieur ou égal à 0.")
    else:
        # Augmenter le solde
        portefeuille['solde'] += montant
        enregistrer_transaction("Dépôt", montant)
        print(f"Le solde du portefeuille est maintenant de {portefeuille['solde']} ariary.")

# Retirer de l'argent
def retirer_argent(montant):
    global nombre_retraits
    if montant <= 0:
        print("Le montant doit être supérieur ou égal à 0.")
    elif montant > portefeuille['solde']:
        print("Le montant à retirer est supérieur au solde du portefeuille.")
    elif nombre_retraits >= 3:
        print("Limite de retraits atteinte. Vous ne pouvez pas effectuer plus de 3 retraits.")
    else:
        # enregistrer la transaction et mettre à jour le nombre de retraits
        portefeuille['solde'] -= montant
        enregistrer_transaction("Retrait", montant)
        nombre_retraits += 1
        print(f"Le solde du portefeuille est maintenant de {portefeuille['solde']} ariary.")

# Afficher le solde
def afficher_solde():
    print(f"Le solde du portefeuille est de {portefeuille['solde']} ariary.")

# Afficher l'historique
def afficher_historique():
    print("\nHistorique des transactions :")
    for transaction in transactions:
        print(f"{transaction['type']} de {transaction['montant']} ariary le {transaction['date']}")
    print("\n")

# Enregistrer une transaction dans l'historique
def enregistrer_transaction(type_transaction, montant):
    global portefeuille
    transaction = {
        'type': type_transaction,
        'montant': montant,
        'date': datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
    }
    transactions.append(transaction)

    # Mettre à jour le total des dépenses en fonction du type de transaction
    if type_transaction == "Retrait":
        portefeuille['total_depenses'] += montant

# Afficher la liste des CIN
def afficher_cin_list():
    print("\nListe des CIN enregistrées :")
    for cin in cin_list:
        print(f"CIN {cin['numero']} - Titulaire: {cin['nom']}")
    print("\n")

# Afficher le total des dépenses
def afficher_total_depenses():
    print(f"Le total des dépenses est de {portefeuille['total_depenses']} ariary.")

choix = 0

while choix != 7:
    print("Que voulez-vous faire ?")
    print("1. Ajouter de l'argent")
    print("2. Retirer de l'argent")
    print("3. Afficher le solde")
    print("4. Afficher l'historique des transactions")
    print("5. Ajouter une CIN")
    print("6. Afficher le total des dépenses")
    print("7. Quitter")

    choix = int(input("Votre choix : "))

    if choix == 1:
        montant_ajout = int(input("Montant à ajouter : "))
        ajouter_argent(montant_ajout)
    elif choix == 2:
        montant_retrait = int(input("Montant à retirer : "))
        retirer_argent(montant_retrait)
    elif choix == 3:
        afficher_solde()
    elif choix == 4:
        afficher_historique()
    elif choix == 5:
        numero_cin = input("Numéro de CIN : ")
        nom_titulaire = input("Nom du titulaire : ")
        ajouter_cin(numero_cin, nom_titulaire)
    elif choix == 7:
        print("Au revoir !")
    elif choix == 6:
        afficher_total_depenses()
    else:
        print("Choix incorrect.")