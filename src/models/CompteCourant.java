package models;

import java.util.ArrayList;

public class CompteCourant extends Compte {
    private Double decouvert;

    public Double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Double newDecouvert) {
        this.decouvert = newDecouvert;
    }

    public boolean retirer(Double montant) {
        if (solde - montant >= -decouvert) {
            solde -= montant;
            listeOperations.add("retrait de: " + montant); // listeOperations.add(new Retrait(montant, destination));
            return true;
        }
        return false;
    }

    public boolean verser(Double montant) {
        if (montant > 0) {
            solde += montant;
            listeOperations.add("versement de: " + montant); // listeOperations.add(new Versement(montant, source));
            return true;
        }
        return false;
    }

    public Double calculerInteret() {
        listeOperations.add("Calcul d'intérêts.");
        return 0.0;
    }

}

