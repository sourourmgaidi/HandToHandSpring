package com.projet.covoiturage.Service;



import com.projet.covoiturage.Entite.Admin;
import com.projet.covoiturage.Entite.Donation;
import com.projet.covoiturage.Entite.Orphelin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Orphelin ajouterOrphelin(Orphelin orphelin);
    Orphelin ModifierOrphelin(Orphelin orphelin) ;
    void SupprimerOrphelin(Long id) ;
    List<Orphelin> AfficherOrphelins() ;
    void supprimerTousOrphelins();

    void supprimerDonation(Long id) ;
    void supprimerTousDons();
    List<Donation> consulterDons();

    List<Orphelin>consulterOrphAdopt();

    Admin ajouterAdmin(Admin admin);
    Admin ModifierAdmin(Admin admin) ;

    List<Orphelin> chercherParOrigine(String origine);
    List<Orphelin> chercherParAge(Long age);
    Admin findByNom(String nom);
    Optional<Admin> findByMail(String mail);
    List<Orphelin> findOrphelinBySexe(String sexe);
}
