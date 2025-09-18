package models;

import java.util.ArrayList;
import java.util.Random;

public abstract class Compte {
    protected Double solde;
    protected String code;
    protected ArrayList<String> listeOperations = new ArrayList<>(); // ArrayList<Operation> listeOperations

    public String getCode() {
        return code;
    }

    public Double getSolde() {
        return solde;
    }

    public ArrayList<String> getListeOperations() {
        return listeOperations;
    }

    public void setCode(String newCode) {
        this.code = newCode;
    }

    public void setSolde(Double newSolde) {
        this.solde = newSolde;
    }

    public void setListeOperations(ArrayList<String> listeOperations) {
        this.listeOperations = listeOperations;
    }

    public abstract boolean retirer(Double montant);
    public abstract boolean verser(Double montant);
    public abstract Double calculerInteret();

    public boolean afficherDetails() {
        return !listeOperations.isEmpty();
    }

    public String generateCode() {
        Random random = new Random();
        Integer randomCode = 10000 + random.nextInt(90000);

        String codeCompte = String.format("CPT-" + randomCode);

        return codeCompte;
    }

}