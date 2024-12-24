package com.example.produit;

import com.example.Produit.Produit;
import com.example.Produit.ProduitRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit creerProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> obtenirTousLesProduits() {
        return produitRepository.findAll();
    }

    public Optional<Produit> obtenirProduitParId(Long id) {
        return produitRepository.findById(id);
    }

    public Produit mettreAJourProduit(Long id, Produit produitDetails) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        produit.setNom(produitDetails.getNom());
        produit.setDescription(produitDetails.getDescription());
        produit.setPrix(produitDetails.getPrix());
        produit.setQuantite(produitDetails.getQuantite());

        return produitRepository.save(produit);
    }

    public void supprimerProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
