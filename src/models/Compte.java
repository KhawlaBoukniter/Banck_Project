package models;

import java.util.ArrayList;
import java.util.Random;

public abstract class Compte {
    protected float solde;
    protected String code;
    protected ArrayList<String> listeOperations = new ArrayList<>(); // ArrayList<Operation> listeOperations
    public static int compteur = 11111;

    public String getCode() {
        return code;
    }

    public float getSolde() {
        return solde;
    }

    public ArrayList<String> getListeOperations() {
        return listeOperations;
    }

    public void setCode(String newCode) {
        this.code = newCode;
    }

    public void setSolde(float newSolde) {
        this.solde = newSolde;
    }

    public void setListeOperations(ArrayList<String> listeOperations) {
        this.listeOperations = listeOperations;
    }

    public abstract boolean retirer(float montant);
    public abstract boolean verser(float montant);
    public abstract float calculerInteret();



}