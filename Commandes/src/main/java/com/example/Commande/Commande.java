package com.example.Commande;
import jakarta.persistence.*;
import lombok.*;

import javax.management.Notification;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;

    @Column(nullable = false)
    private LocalDateTime dateCommande;

    @Column(nullable = false, length = 20)
    private String statutCommande;

    @Column(nullable = false)
    private BigDecimal montantTotal;

    @Column(nullable = false)
    private String adresseLivraison;

    @Column(nullable = false, length = 20)
    private String modePaiement;

}



