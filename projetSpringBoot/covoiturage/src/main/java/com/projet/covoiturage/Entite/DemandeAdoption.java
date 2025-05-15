package com.projet.covoiturage.Entite;

import com.projet.covoiturage.enums.StatutDemandeAdoption;
import jakarta.persistence.*;

@Entity
public class DemandeAdoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Orphelin orphelin;

    @ManyToOne
    private Donneur donneur;

    @Enumerated(EnumType.STRING) // Cela permet de stocker le nom de l'enum (ex: "EN_ATTENTE") dans la base
    private StatutDemandeAdoption statut = StatutDemandeAdoption.EN_ATTENTE;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    // Constructeurs, getters, setters

    public DemandeAdoption() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orphelin getOrphelin() {
        return orphelin;
    }

    public void setOrphelin(Orphelin orphelin) {
        this.orphelin = orphelin;
    }

    public Donneur getDonneur() {
        return donneur;
    }

    public void setDonneur(Donneur donneur) {
        this.donneur = donneur;
    }

    public StatutDemandeAdoption getStatut() {
        return statut;
    }

    public void setStatut(StatutDemandeAdoption statut) {
        this.statut = statut;
    }
}
