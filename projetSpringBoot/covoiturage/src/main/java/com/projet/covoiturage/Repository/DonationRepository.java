package com.projet.covoiturage.Repository;

import com.projet.covoiturage.Entite.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository <Donation, Long>{
}
