package com.projet.covoiturage.Entite;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.projet.covoiturage.enums.StatutDemande;

@Entity
public class DemandeDons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String typeDon = "ARGENT";
    private LocalDate dateDemande;
    private BigDecimal montant;

    @Enumerated(EnumType.STRING)
    private StatutDemande statut;

    @ManyToOne
    @JoinColumn(name = "donneur_id")
    private Donneur donneur;

    private String commentaireAdmin;
    private boolean conformeReglement;
    private boolean montantValide;
    private boolean donneurEligible;

    @OneToOne(mappedBy = "demandeDon", cascade = CascadeType.ALL)
    private Notification notification;

    @OneToOne(mappedBy = "demandeDon", cascade = CascadeType.ALL)
    private NotificationDons notificationDons;

    public  DemandeDons() {
        this.dateDemande = LocalDate.now();
        this.statut = StatutDemande.EN_ATTENTE;
    }

    public DemandeDons(Long id, LocalDate dateDemande, BigDecimal montant, StatutDemande statut, Donneur donneur, String commentaireAdmin, boolean conformeReglement, boolean montantValide, boolean donneurEligible, Notification notification) {
        this.id = id;
        this.dateDemande = dateDemande;
        this.montant = montant;
        this.statut = statut;
        this.donneur = donneur;
        this.commentaireAdmin = commentaireAdmin;
        this.conformeReglement = conformeReglement;
        this.montantValide = montantValide;
        this.donneurEligible = donneurEligible;
        this.notification = notification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeDon() {
        return typeDon;
    }

    public LocalDate getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(LocalDate dateDemande) {
        this.dateDemande = dateDemande;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public StatutDemande getStatut() {
        return statut;
    }

    public void setStatut(StatutDemande statut) {
        this.statut = statut;
    }

    public Donneur getDonneur() {
        return donneur;
    }

    public void setDonneur(Donneur donneur) {
        this.donneur = donneur;
    }

    public String getCommentaireAdmin() {
        return commentaireAdmin;
    }

    public void setCommentaireAdmin(String commentaireAdmin) {
        this.commentaireAdmin = commentaireAdmin;
    }

    public boolean isConformeReglement() {
        return conformeReglement;
    }

    public void setConformeReglement(boolean conformeReglement) {
        this.conformeReglement = conformeReglement;
    }

    public boolean isMontantValide() {
        return montantValide;
    }

    public void setMontantValide(boolean montantValide) {
        this.montantValide = montantValide;
    }

    public boolean isDonneurEligible() {
        return donneurEligible;
    }

    public void setDonneurEligible(boolean donneurEligible) {
        this.donneurEligible = donneurEligible;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
