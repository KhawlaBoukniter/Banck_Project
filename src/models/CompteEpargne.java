package models;

public class CompteEpargne extends Compte {
    private float tauxInteret = 0.02f;

    public float getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(float newTauxInteret) {
        this.tauxInteret = newTauxInteret;
    }



}
