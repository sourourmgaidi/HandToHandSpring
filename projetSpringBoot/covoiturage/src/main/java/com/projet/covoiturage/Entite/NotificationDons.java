package com.projet.covoiturage.Entite;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class NotificationDons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime dateCreation;
    private boolean lue;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    // Relation avec Donneur - déjà correcte
    @ManyToOne
    @JoinColumn(name = "donneur_id")
    private Donneur donneur;

    // Relation avec DemandeDons - déjà correcte
    @OneToOne
    @JoinColumn(name = "demande_id")
    private DemandeDons demandeDon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean isLue() {
        return lue;
    }

    public void setLue(boolean lue) {
        this.lue = lue;
    }

    public Donneur getDonneur() {
        return donneur;
    }

    public void setDonneur(Donneur donneur) {
        this.donneur = donneur;
    }

    public DemandeDons getDemandeDon() {
        return demandeDon;
    }

    public void setDemandeDon(DemandeDons demandeDon) {
        this.demandeDon = demandeDon;
    }
}
