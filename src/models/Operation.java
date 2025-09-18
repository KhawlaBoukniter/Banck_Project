package models;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {
    private UUID numero;
    private LocalDateTime date;
    private Double montant;

    public Operation(Double montant) {
        this.numero = UUID.randomUUID();
        this.date = LocalDateTime.now();
        this.montant = montant;
    }

    public UUID getNumero() {
        return numero;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setNumero(UUID newNumero) {
        this.numero = newNumero;
    }

    public void setDate(LocalDateTime newDate) {
        this.date = newDate;
    }

    public void setMontant(Double newMontant) {
        this.montant = newMontant;
    }

    public abstract String getOperation();

}