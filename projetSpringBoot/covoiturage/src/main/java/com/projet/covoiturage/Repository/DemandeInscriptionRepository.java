package com.projet.covoiturage.Repository;

import com.projet.covoiturage.Entite.DemandeInscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeInscriptionRepository extends JpaRepository<DemandeInscription, Long> {
    DemandeInscription findByEmail(String email);
}
