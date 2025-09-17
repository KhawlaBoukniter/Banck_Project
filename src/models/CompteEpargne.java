package models;

public class CompteEpargne extends Compte {
    private float tauxInteret = 0.02f;

    public float getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(float newTauxInteret) {
        this.tauxInteret = newTauxInteret;
    }

    public boolean retirer(float montant) {
        if (montant <= solde) {
            solde -= montant;
            listeOperations.add("Retrait de: " + montant);
            return true;
        } else {
            return false;
        }
    }

    public boolean verser(float montant) {
        if (montant > 0) {
            solde += montant;
            listeOperations.add("versement de: " + montant);
            return true;
        }
        return false;

    }


}
