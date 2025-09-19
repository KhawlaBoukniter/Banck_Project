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

    public Boolean retirer(Double montant) {
        if (solde - montant >= -decouvert && solde > 0) {
            solde -= montant;
            listeOperations.add(new Retrait(montant));
            return true;
        }
        return false;
    }

    public Boolean retirer(Double montant, String destination) {
        if (solde - montant >= -decouvert && solde > 0) {
            solde -= montant;
            listeOperations.add(new Retrait(montant, destination));
            return true;
        }
        return false;
    }

    public Boolean verser(Double montant) {
        if (montant > 0) {
            solde += montant;
            listeOperations.add(new Versement(montant));
            return true;
        }
        return false;
    }

    public Boolean verser(Double montant, String source) {
        if (montant > 0) {
            solde += montant;
            listeOperations.add(new Versement(source, montant));
            return true;
        }
        return false;
    }

    public Double calculerInteret() {
        return 0.0;
    }

}

