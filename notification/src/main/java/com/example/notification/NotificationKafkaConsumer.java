package com.example.notification;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationKafkaConsumer {

    @KafkaListener(topics = "commande-notification", groupId = "notification-group")
    public void consommerNotification(String message) {
        System.out.println("Message reçu : " + message);
        // Vous pouvez ajouter ici une logique supplémentaire si nécessaire
    }
}
