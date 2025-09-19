package models;

public class Retrait extends Operation {
    private String destination;

    public Retrait(Double montant, String destination) {
        super(montant);
        this.destination = destination;
    }

    public Retrait(Double montant) {
        super(montant);
    }

    @Override
    public String getOperation() {
        if (destination == null) {
            return getNumero() + " : Retrait de: " + getMontant();
        } else {
            return getNumero() + " : Retrait de: " + getMontant() + " vers " + destination + " le " + getDate();
        }

    }
}
