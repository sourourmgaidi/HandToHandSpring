package com.projet.covoiturage.Service;
import com.projet.covoiturage.Entite.Admin;
import com.projet.covoiturage.Entite.Donation;
import com.projet.covoiturage.Entite.Orphelin;
import com.projet.covoiturage.Repository.AdminRepository;
import com.projet.covoiturage.Repository.DemmandeRepository;
import com.projet.covoiturage.Repository.DonationRepository;
import com.projet.covoiturage.Repository.OrphelinRepository;
import com.projet.covoiturage.enums.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceEmpl implements  AdminService{
    @Autowired
    DonationRepository donationRepository;
    @Autowired
    OrphelinRepository orphelinRepository ;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    DemmandeRepository demmandeRepository;

    @Override
    public Orphelin ajouterOrphelin(Orphelin orphelin) {
        return orphelinRepository .save(orphelin) ;

    }
    @Override
    public Orphelin ModifierOrphelin(Orphelin orphelin) {

        return orphelinRepository.save(orphelin);
    }

    @Override
    public void SupprimerOrphelin(Long id) {
        orphelinRepository.deleteById(id);

    }
    @Override
    public List<Orphelin> AfficherOrphelins() {

        return orphelinRepository.findAll();
    }
    @Override
    public void supprimerDonation(Long id) {
        donationRepository.deleteById(id);
    }
    @Override
    public List<Donation> consulterDons() {
        return donationRepository.findAll();
    }

    @Override
    public List<Orphelin> consulterOrphAdopt() {
        return orphelinRepository.findByAdopteTrue();
    }

    @Override

    public Admin ajouterAdmin(Admin admin) {
        // Si l'admin n'a pas de rôle défini, on lui attribue le rôle 'SOUS_ADMIN' par défaut
        if (admin.getRoles() == null || admin.getRoles().isEmpty()) {
            admin.addRole(AdminRole.SOUS_ADMIN);  // Attribue le rôle SOUS_ADMIN
        }
        return adminRepository.save(admin);  // Sauvegarde l'admin dans la base de données
    }

    @Override
    public void supprimerTousOrphelins(){

        orphelinRepository.deleteAll();
    }
    @Override
    public void supprimerTousDons(){

        donationRepository.deleteAll();
    }
    @Override
    public List<Orphelin> chercherParAge(Long age) {

        return orphelinRepository.findByAge(age);
    }

    @Override
    public Admin findByNom(String nom) {
        return adminRepository.findByNom(nom);
    }

    @Override
    public Optional<Admin> findByMail(String mail) {
        return adminRepository.findByMail(mail);
    }

    @Override
    public List<Orphelin> findOrphelinBySexe(String sexe) {
        return orphelinRepository.findBySexe(sexe);
    }


    @Override
    public List<Orphelin> chercherParOrigine(String origine) {

        return orphelinRepository.findByOrigine(origine);
    }
    @Override
    public Admin ModifierAdmin(Admin admin){
        return adminRepository.save(admin);
    }
}
