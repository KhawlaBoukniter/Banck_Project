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
}