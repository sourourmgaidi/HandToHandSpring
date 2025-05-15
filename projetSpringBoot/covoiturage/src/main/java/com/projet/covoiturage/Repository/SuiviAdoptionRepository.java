package com.projet.covoiturage.Repository;

import com.projet.covoiturage.Entite.SuiviAdoption;
import com.projet.covoiturage.enums.StatutAdoption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuiviAdoptionRepository extends JpaRepository<SuiviAdoption, Long> {
    // Méthode pour récupérer les suivis d'adoption par Orphelin
    List<SuiviAdoption> findByOrphelinId(Long Id);

    // Méthode pour récupérer les suivis d'adoption par Donneur
    List<SuiviAdoption> findByDonneurId(Long donneurId);

    List<SuiviAdoption> findByDonneurIdAndStatutAdoptionNot(Long donneurId, StatutAdoption statutAdoption);
}
