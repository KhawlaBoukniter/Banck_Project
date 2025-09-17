package models;

import java.util.ArrayList;

public class CompteCourant extends Compte {
    private double decouvert;

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double newDecouvert) {
        this.decouvert = newDecouvert;
    }

    public boolean retirer(float montant) {
        if (solde - montant >= -decouvert) {
            solde -= montant;
            listeOperations.add("retrait de: " + montant); // listeOperations.add(new Retrait(montant, destination));
            return true;
        }
        return false;
    }

}

