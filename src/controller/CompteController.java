package controller;

import models.Compte;
import models.CompteCourant;
import models.CompteEpargne;

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

        Compte compte;
        if (choix == 1) {
            System.out.print("Veuillez entrer la découvert: ");
            Double decouvert = sc.nextDouble();
            sc.nextLine();
            compte = new CompteCourant();
            ((CompteCourant) compte).setDecouvert(decouvert);
        } else {
            System.out.print("Veuillez entrer le taux d'intérêts: ");
            Double taux = sc.nextDouble();
            sc.nextLine();
            compte = new CompteEpargne();
            ((CompteEpargne) compte).setTauxInteret(taux);
        }

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

}