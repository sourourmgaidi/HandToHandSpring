package com.projet.covoiturage.Service;

import com.projet.covoiturage.Entite.*;
import com.projet.covoiturage.Repository.*;
import com.projet.covoiturage.enums.StatutAdoption;
import com.projet.covoiturage.enums.StatutDemandeAdoption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DemandeAdoptionServiceImpl implements DemandeAdoptionService {

    @Autowired
    private DemandeAdoptionRepository demandeAdoptionRepository;

    @Autowired
    private SuiviAdoptionRepository suiviAdoptionRepository;

    @Autowired
    private OrphelinRepository orphelinRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private DonneurRepository donneurRepository;

    @Override
    public List<DemandeAdoption> getDemandesEnAttente() {
        return demandeAdoptionRepository.findByStatut(StatutDemandeAdoption.EN_ATTENTE);
    }

    @Override
    public Orphelin getOrphelinDetaille(Long orphelinId) {
        return orphelinRepository.findById(orphelinId)
                .orElseThrow(() -> new RuntimeException("Orphelin non trouvé"));
    }

    @Override
    public void soumettreDemande(DemandeAdoption demande) {
        Orphelin orphelin = orphelinRepository.findById(demande.getOrphelin().getId())
                .orElseThrow(() -> new RuntimeException("Orphelin non trouvé"));

        demande.setOrphelin(orphelin);
        demande.setStatut(StatutDemandeAdoption.EN_ATTENTE);
        demandeAdoptionRepository.save(demande);

        createNotificationToAdmin(
                "Une nouvelle demande d'adoption a été soumise pour l'orphelin '" + orphelin.getNom() + "'. Veuillez la traiter.");
    }

    @Override
    public void acceptAll() {
        List<DemandeAdoption> demandesEnAttente = getDemandesEnAttente();
        for (DemandeAdoption demande : demandesEnAttente) {
            try {
                accepterDemande(demande.getId());
                System.out.println("Demande d'adoption acceptée pour l'orphelin ID: " + demande.getOrphelin().getId());
            } catch (Exception e) {
                System.out.println("Erreur lors de l'acceptation de la demande d'adoption ID: " + demande.getId() + " : " + e.getMessage());
            }
        }
    }

    @Override
    public List<SuiviAdoption> getAdoptionsByDonneur(Long donneurId) {
        return suiviAdoptionRepository.findByDonneurId(donneurId);
    }

    @Override
    public List<DemandeAdoption> getAllDemandes() {
        return demandeAdoptionRepository.findAll();
    }

    @Override
    public void accepterDemande(Long demandeId) {
        DemandeAdoption demande = demandeAdoptionRepository.findById(demandeId)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée"));

        demande.setStatut(StatutDemandeAdoption.ACCEPTEE);
        demandeAdoptionRepository.save(demande);

        Orphelin orphelin = demande.getOrphelin();
        orphelin.setAdopte(true);
        orphelinRepository.save(orphelin);

        SuiviAdoption suivi = new SuiviAdoption();
        suivi.setOrphelin(orphelin);
        suivi.setDonneur(demande.getDonneur());
        suivi.setStatutAdoption(StatutAdoption.EN_COURS);
        suivi.setDateAdoption(LocalDateTime.now());
        suivi.setNotesSuivi("Adoption en cours");
        suiviAdoptionRepository.save(suivi);

        demandeAdoptionRepository.delete(demande);

        createNotificationToDonneur(
                "Votre demande d'adoption pour l'orphelin '" + orphelin.getNom() + "' a été acceptée. L'adoption est maintenant en cours.",
                demande.getDonneur());
    }

    @Override
    public void refuserDemande(Long demandeId) {
        DemandeAdoption demande = demandeAdoptionRepository.findById(demandeId)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée"));

        demande.setStatut(StatutDemandeAdoption.REFUSEE);
        demandeAdoptionRepository.save(demande);

        createNotificationToDonneur(
                "Votre demande d'adoption pour l'orphelin '" + demande.getOrphelin().getNom() + "' a été refusée.",
                demande.getDonneur());
    }

    @Override
    public void annulerAdoption(Long suiviId, String raisonAnnulation) {
        SuiviAdoption suivi = suiviAdoptionRepository.findById(suiviId)
                .orElseThrow(() -> new RuntimeException("Suivi d'adoption non trouvé"));

        suivi.setStatutAdoption(StatutAdoption.ANNULEE);
        suivi.setNotesSuivi("Adoption annulée. Raison: " + raisonAnnulation);
        suiviAdoptionRepository.save(suivi);

        Orphelin orphelin = suivi.getOrphelin();
        orphelin.setAdopte(false);
        orphelinRepository.save(orphelin);

        createNotificationToDonneur(
                "Votre adoption de l'orphelin '" + orphelin.getNom() + "' a été annulée. Raison : " + raisonAnnulation,
                suivi.getDonneur());
    }

    private void createNotificationToAdmin(String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setDate(LocalDateTime.now());
        notification.setDestinataireRole("ADMIN");
        notification.setExpediteurRole("ADMIN");
        notificationRepository.save(notification);
    }

    private void createNotificationToDonneur(String message, Donneur donneur) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setDate(LocalDateTime.now());
        notification.setDestinataireRole("DONNEUR");
        notification.setDestinataireId(donneur.getId());
        notification.setExpediteurRole("ADMIN");
        notification.setDonneur(donneur);
        notificationRepository.save(notification);
    }

    @Override
    public void notifierDonneur(Donneur donneur, String message) {
        // Implémentation future
    }

    @Override
    public void notifierAdmin(String message) {
        // Implémentation future
    }
}
