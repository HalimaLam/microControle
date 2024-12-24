package com.example.Produit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    // Méthodes supplémentaires (si nécessaire) peuvent être définies ici.
}
