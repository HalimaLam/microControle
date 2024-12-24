package com.example.notification;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<notification, Integer> {
    List<notification> findAllByCommandeId(Integer schoolId);
}
