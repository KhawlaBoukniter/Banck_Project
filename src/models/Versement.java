package models;

public class Versement extends Operation {
    private String source;

    public Versement (String source, Double montant) {
        super(montant);
        this.source = source;
    }

    public Versement(Double montant) {
        super(montant);
    }

    @Override
    public String getOperation() {
        if (source == null) {
            return getNumero() + " : Versement de " + getMontant();
        } else {
            return getNumero() + " : Versement de " + getMontant() + " depuis " + source + " le " + getDate();
        }

    }
}
