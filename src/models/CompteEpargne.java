package models;

public class CompteEpargne extends Compte {
    private Double tauxInteret = 0.02;

    public Double getTauxInteret() {
        return tauxInteret;
    }

//    public void setTauxInteret(Double newTauxInteret) {
//        this.tauxInteret = newTauxInteret;
//    }

    public Boolean retirer(Double montant) {
        if (montant <= solde) {
            solde -= montant;
            listeOperations.add(new Retrait(montant));
            return true;
        } else {
            return false;
        }
    }

    public Boolean retirer(Double montant, String destination) {
        if (montant <= solde) {
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
        return solde * tauxInteret;
    }

}
