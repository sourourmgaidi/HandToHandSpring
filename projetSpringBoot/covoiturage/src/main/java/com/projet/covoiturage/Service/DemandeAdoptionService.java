package com.projet.covoiturage.Service;

import com.projet.covoiturage.Entite.DemandeAdoption;
import com.projet.covoiturage.Entite.Donneur;
import com.projet.covoiturage.Entite.Orphelin;
import com.projet.covoiturage.Entite.SuiviAdoption;

import java.util.List;

public interface DemandeAdoptionService {
    List<DemandeAdoption> getDemandesEnAttente();

    List<DemandeAdoption> getAllDemandes();

    void accepterDemande(Long demandeId);

    void refuserDemande(Long demandeId);

    void notifierDonneur(Donneur donneur, String message);

    void notifierAdmin(String message);

    void soumettreDemande(DemandeAdoption demandeAdoption);

    void acceptAll();


    List<SuiviAdoption> getAdoptionsByDonneur(Long donneurId);

    void annulerAdoption(Long suiviId, String raison);

    Orphelin getOrphelinDetaille(Long orphelinId);
}
