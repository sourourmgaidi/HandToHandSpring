package com.projet.covoiturage.Repository;

import com.projet.covoiturage.Entite.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByNom(String nom);
    Optional<Admin> findByMail(String mail);
}
