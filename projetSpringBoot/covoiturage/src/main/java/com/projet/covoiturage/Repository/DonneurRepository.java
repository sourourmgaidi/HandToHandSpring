package com.projet.covoiturage.Repository;

import com.projet.covoiturage.Entite.Donneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DonneurRepository extends JpaRepository<Donneur, Long> {
    Optional<Donneur> findByEmail(String email);
    Optional<Donneur> findById(Long id);

}
