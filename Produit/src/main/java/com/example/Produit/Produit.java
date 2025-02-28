package com.example.Produit;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    private Double prix;

    private Integer quantite;
}
