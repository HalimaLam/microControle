package com.example.Commande;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaCommandeProducer {

    private static final String TOPIC = "commande-notification";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaCommandeProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void envoyerNotificationCommande(Long idCommande) {
        String message = "Commande avec ID " + idCommande + " ajoutée avec succès.";
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Message envoyé au topic Kafka : " + message);
    }
}
