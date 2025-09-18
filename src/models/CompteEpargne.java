package models;

public class CompteEpargne extends Compte {
    private Double tauxInteret;

    public Double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Double newTauxInteret) {
        this.tauxInteret = newTauxInteret;
    }

    public boolean retirer(Double montant) {
        if (montant <= solde) {
            solde -= montant;
            listeOperations.add("Retrait de: " + montant);
            return true;
        } else {
            return false;
        }
    }

    public boolean verser(Double montant) {
        if (montant > 0) {
            solde += montant;
            listeOperations.add("versement de: " + montant);
            return true;
        }
        return false;

    }

    public Double calculerInteret() {
        return solde * tauxInteret;
    }

}
