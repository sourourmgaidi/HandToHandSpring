package com.projet.covoiturage.Repository;

import com.projet.covoiturage.Entite.DemandeAdoption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DemmandeRepository extends JpaRepository<DemandeAdoption,Long> {
   Optional<DemandeAdoption> findByOrphelinIdAndDonneurIdAndStatut(Long orphelinId, Long donneurId, String etat);

}
