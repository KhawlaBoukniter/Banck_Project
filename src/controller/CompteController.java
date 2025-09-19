package controller;

import models.Compte;
import models.CompteCourant;
import models.CompteEpargne;
import models.Operation;

import java.util.HashMap;
import java.util.Scanner;

public class CompteController {

    private Compte compteModel;
    private static HashMap<String, CompteController> comptes = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public CompteController(Compte compteModel) {
        this.compteModel = compteModel;
    }

    public static CompteController askAccountType() {
        System.out.println("Choisissez le type de votre compte ?");
        System.out.println("1. Compte courant");
        System.out.println("2. Compte épargne");

        Integer choix = sc.nextInt();
        sc.nextLine();

        System.out.println("Veuillez entrer votre solde: ");
        Double solde = sc.nextDouble();
        sc.nextLine();

        Compte compte;
        if (choix == 1) {
            System.out.print("Veuillez entrer la découvert: ");
            Double decouvert = sc.nextDouble();
            sc.nextLine();
            compte = new CompteCourant();
            ((CompteCourant) compte).setDecouvert(decouvert);
        } else {
            compte = new CompteEpargne();

        }
        compte.setSolde(solde);

        compte.setCode(compte.generateCode());
        CompteController compteController = new CompteController(compte);
        comptes.put(compte.getCode(), compteController);

        System.out.println("Compte créé avec succès ! Votre code compte est  : " + compte.getCode());
        return compteController;
    }

    public void fstMenu() {
        askAccountType();
        System.out.println("\nChoisissez votre action");
        System.out.println("1. Créer un nouveau compte");
        System.out.println("2. Gérer un compte existant");
        System.out.print("Votre choix: ");

        Integer fstChoice = sc.nextInt();
        sc.nextLine();

        if (fstChoice == 1) {
            askAccountType();
        } else {
            menu();
        }
    }

    public void menu() {
        Integer choix = 0;
        do {
            System.out.println("\nMENU COMPTE " + compteModel.getCode());
            System.out.println("1. Effectuer un versement");
            System.out.println("2. Effectuer un retrait");
            System.out.println("3. Effectuer un virement vers un autre compte");
            System.out.println("4. Consulter votre solde");
            System.out.println("5. Afficher les détails du compte");
            System.out.println("6. Consulter les opérations");
            System.out.println("7. Calculer intérêts");
            System.out.println("8. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    verserMenu();
                    break;
                case 2:
                    retirerMenu();
                    break;
                case 3:
                    virementMenu();
                    break;
                case 4:
                    System.out.println("Solde actuel : " + compteModel.getSolde());
                    break;
                case 5:
                    afficherDetails();
                    break;
                case 6:
                    afficherOperations();
                    break;
                case 7:
                    System.out.println("Intérêts : " + compteModel.calculerInteret());
                    break;
                case 8:
                    System.out.println("Merci d'avoir utilisé notre application");
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (choix != 8);
    }

    private void verserMenu() {
        System.out.print("Veuillez entrer le montant à verser : ");
        Double montant = sc.nextDouble();
        sc.nextLine();

        if (montant <= 0) {
            System.out.println("Montant invalide !");
            return;
        }

        if (compteModel instanceof CompteCourant) {
            ((CompteCourant) compteModel).verser(montant);
        } else if (compteModel instanceof CompteEpargne) {
            ((CompteEpargne) compteModel).verser(montant);
        }

        System.out.println("Versement effectué. Votre solde est: " + compteModel.getSolde());
    }

    private void retirerMenu() {
        System.out.print("Montant à retirer : ");
        Double montant = sc.nextDouble();
        sc.nextLine();

        if (montant <= 0) {
            System.out.println("Montant invalide !");
            return;
        }

        boolean success = false;
        if (compteModel instanceof CompteCourant) {
            success = ((CompteCourant) compteModel).retirer(montant);
        } else if (compteModel instanceof CompteEpargne) {
            success = ((CompteEpargne) compteModel).retirer(montant);
        }

        if (success) {
            System.out.println("Retrait effectué. Votre nouveau solde est: " + compteModel.getSolde());
        } else {
            System.out.println("Opération refusée.");
        }
    }

    private void virementMenu() {
        System.out.print("Veuillez entrer le montant à virer: ");
        Double montant = sc.nextDouble();
        sc.nextLine();

        System.out.print("Veuillez entrer le code du compte destinataire : ");
        String codeDest = sc.nextLine();

        if (!comptes.containsKey(codeDest)) {
            System.out.println("Compte destinataire introuvable.");
            return;
        }

        System.out.println("Veullez entrer la destination (ex: 'Distributeur ATM', 'Chèque', 'Virement sortant')");
        String destination = sc.nextLine();

        System.out.println("Veuillez entrez la source (ex: 'Virement externe', 'Dépôt espèces', 'Salaire')");
        String source = sc.nextLine();

        CompteController dest = comptes.get(codeDest);
        boolean success = false;

        if (compteModel instanceof CompteCourant) {
            success = ((CompteCourant) compteModel).retirer(montant, destination);
        } else if (compteModel instanceof CompteEpargne) {
            success = ((CompteEpargne) compteModel).retirer(montant, destination);
        }

        if (success) {
            if (dest.compteModel instanceof CompteCourant) {
                ((CompteCourant) dest.compteModel).verser(montant, source);
            } else if (dest.compteModel instanceof CompteEpargne) {
                ((CompteEpargne) dest.compteModel).verser(montant, source);
            }
            System.out.println("Virement effectué");
        } else {
            System.out.println("Solde insuffisant.");
        }
    }

    public void afficherDetails() {
        System.out.println("\nDétails du compte");
        System.out.println("Code : " + compteModel.getCode());
        System.out.println("Solde : " + compteModel.getSolde());

        if (compteModel instanceof CompteEpargne) {
            System.out.println("Votre taux d'intérêts est: " + ((CompteEpargne) compteModel).getTauxInteret());
        } else {
            System.out.println("Votre decouvert est: " + ((CompteCourant) compteModel).getDecouvert());
        }
    }

    public void afficherOperations() {
        System.out.println("Les opérations effectuées sur ce compte:");
        for (Operation op: compteModel.getListeOperations()) {
            System.out.println(op.getOperation());
        }
    }
}