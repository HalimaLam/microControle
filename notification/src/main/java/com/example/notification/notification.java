package com.example.notification;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
@Getter
@Setter
public class notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotification;

    @Column(nullable = false, length = 100)
    private String message;

    @Column(nullable = false)
    private LocalDateTime dateNotification;

    @Column(nullable = false)
    private boolean lue;

    @ManyToOne
    @JoinColumn(name = "id_commande", nullable = false)
    private Commande commande;
}
