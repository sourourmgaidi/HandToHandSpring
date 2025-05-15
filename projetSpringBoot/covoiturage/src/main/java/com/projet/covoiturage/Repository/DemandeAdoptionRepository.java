package com.projet.covoiturage.Repository;

import com.projet.covoiturage.Entite.DemandeAdoption;
import com.projet.covoiturage.enums.StatutDemandeAdoption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeAdoptionRepository extends JpaRepository<DemandeAdoption, Long> {
    List<DemandeAdoption> findByStatut(StatutDemandeAdoption statutDemandeAdoption);

}
