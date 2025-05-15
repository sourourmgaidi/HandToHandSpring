package com.projet.covoiturage.Entite;

import jakarta.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;


    @ManyToOne
    @JoinColumn(name = "donneur_id")
    private Donneur donneur;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    public Message(){}

    public Message(Long id, String contenu, Donneur donneur, Admin admin) {
        this.id = id;
        this.contenu = contenu;
        this.donneur = donneur;
        this.admin=admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Donneur getDonneur() {
        return donneur;
    }

    public void setDonneur(Donneur donneur) {
        this.donneur = donneur;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
