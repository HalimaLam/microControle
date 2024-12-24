package com.example.notification;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class commande {
    private Long idCommande;

    private LocalDateTime dateCommande;

    private String statutCommande;

    private BigDecimal montantTotal;

    private String adresseLivraison;


    private String modePaiement;


}