package models;

import java.util.ArrayList;
import java.util.Random;

public abstract class Compte {
    protected Double solde;
    protected String code;
    protected ArrayList<Operation> listeOperations = new ArrayList<>();
    private static Random random = new Random();

    public String getCode() {
        return code;
    }

    public Double getSolde() {
        return solde;
    }

    public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public void setCode(String newCode) {
        this.code = newCode;
    }

    public void setSolde(Double newSolde) {
        this.solde = newSolde;
    }

    public void setListeOperations(ArrayList<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }

    public abstract Boolean retirer(Double montant);
    public abstract Boolean verser(Double montant);
    public abstract Double calculerInteret();

    public boolean afficherDetails() {
        return !listeOperations.isEmpty();
    }

    public String generateCode() {
        Integer randomCode = 10000 + random.nextInt(90000);

        return "CPT-" + randomCode;
    }

}