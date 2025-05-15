package com.projet.covoiturage.Service;

import com.projet.covoiturage.Entite.Donneur;
import com.projet.covoiturage.Entite.Notification;
import com.projet.covoiturage.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
    public Notification saveNotification(Notification notification) {
        if (notification.getDonneur() == null) {
            notification.setDonneur(new Donneur());  // Crée un nouvel objet Donneur si c'est nécessaire
        }
        return notificationRepository.save(notification);
    }

}
