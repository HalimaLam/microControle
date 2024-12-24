package com.example.Produit;

import com.example.Produit.Produit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final com.example.produit.ProduitService produitService;

    public ProduitController(com.example.produit.ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping
    public ResponseEntity<Produit> creerProduit(@RequestBody Produit produit) {
        Produit nouveauProduit = produitService.creerProduit(produit);
        return ResponseEntity.ok(nouveauProduit);
    }

    @GetMapping
    public ResponseEntity<List<Produit>> obtenirTousLesProduits() {
        List<Produit> produits = produitService.obtenirTousLesProduits();
        return ResponseEntity.ok(produits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> obtenirProduitParId(@PathVariable Long id) {
        return produitService.obtenirProduitParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> mettreAJourProduit(@PathVariable Long id, @RequestBody Produit produit) {
        Produit produitMisAJour = produitService.mettreAJourProduit(id, produit);
        return ResponseEntity.ok(produitMisAJour);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
        return ResponseEntity.noContent().build();
    }
}
