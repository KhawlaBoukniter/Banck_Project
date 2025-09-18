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

}