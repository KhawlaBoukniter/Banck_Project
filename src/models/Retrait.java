package models;

public class Retrait extends Operation {
    private String destination;

    public Retrait(Double montant, String destination) {
        super(montant);
        this.destination = destination;
    }

    @Override
    public String getOperation() {
        return "Retrait de: " + getMontant() + " vers " + destination + " le " + getDate();
    }
}
