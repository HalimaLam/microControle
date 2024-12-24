package com.example.Commande;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final KafkaCommandeProducer kafkaCommandeProducer;

    public CommandeService(CommandeRepository commandeRepository, KafkaCommandeProducer kafkaCommandeProducer) {
        this.commandeRepository = commandeRepository;
        this.kafkaCommandeProducer = kafkaCommandeProducer;
    }

    public Commande creerCommande(Commande commande) {
        commande.setDateCommande(LocalDateTime.now());
        Commande savedCommande = commandeRepository.save(commande);

        // Envoyer une notification après ajout
        kafkaCommandeProducer.envoyerNotificationCommande(savedCommande.getIdCommande());
        return savedCommande;
    }
}
