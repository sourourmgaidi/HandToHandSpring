package com.projet.covoiturage.Entite;

import jakarta.persistence.*;

@Entity
public class Orphelin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  Nom;
    private String  Prenom;
    private Long age ;
    private String origine ;
    private String Personnalite ;
    private String Scolarité ;
    private String Passions;
    private String Langues ;
    private String  Situation ;
    private String image;
    private Boolean adopte;
    private String sexe;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "donneur_id")
    private Donneur donneur;
    public Orphelin() {}

    public Orphelin(Long id, String nom, String prenom, Long age, String origine, String personnalite, String scolarité, String passions, String langues, String situation, String image, Boolean adopter, String sexe, Admin admin, Donneur donneur) {
        this.id = id;
        Nom = nom;
        Prenom = prenom;
        this.age = age;
        this.origine = origine;
        Personnalite = personnalite;
        Scolarité = scolarité;
        Passions = passions;
        Langues = langues;
        Situation = situation;
        this.image = image;
        this.adopte = adopter;
        this.sexe = sexe;
        this.admin = admin;
        this.donneur = donneur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getPersonnalite() {
        return Personnalite;
    }

    public void setPersonnalite(String personnalite) {
        Personnalite = personnalite;
    }

    public String getScolarité() {
        return Scolarité;
    }

    public void setScolarité(String scolarité) {
        Scolarité = scolarité;
    }

    public String getPassions() {
        return Passions;
    }

    public void setPassions(String passions) {
        Passions = passions;
    }

    public String getLangues() {
        return Langues;
    }

    public void setLangues(String langues) {
        Langues = langues;
    }

    public String getSituation() {
        return Situation;
    }

    public void setSituation(String situation) {
        Situation = situation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getAdopte() {
        return adopte;
    }

    public void setAdopte(Boolean adopter) {
        this.adopte = adopter;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Donneur getDonneur() {
        return donneur;
    }

    public void setDonneur(Donneur donneur) {
        this.donneur = donneur;
    }
}
