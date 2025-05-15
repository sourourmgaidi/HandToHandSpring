package com.projet.covoiturage.Repository;

import com.projet.covoiturage.Entite.Orphelin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrphelinRepository extends JpaRepository<Orphelin, Long> {
    List<Orphelin> findByAdopteTrue();
    List<Orphelin> findByAge(Long age);
    List<Orphelin> findByOrigine(String origine);
    List<Orphelin> findBySexe(String sexe);
    Optional<Orphelin> findById(Long id);


}
