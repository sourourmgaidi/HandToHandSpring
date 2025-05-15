package com.projet.covoiturage.dto;

import com.projet.covoiturage.enums.AdminRole;
import java.util.Set;

public class RegisterAdmin {
    private String nom;
    private String prenom;
    private String mail;
    private String pwd;
    private String pwdconf;
    private String image;
    private Set<AdminRole> roles; // Ajout des rôles

    // Constructeurs
    public RegisterAdmin() {
    }

    public RegisterAdmin(String nom, String prenom, String mail, String pwd, String pwdconf, String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.pwd = pwd;
        this.pwdconf = pwdconf;
        this.image = image;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwdconf() {
        return pwdconf;
    }

    public void setPwdconf(String pwdconf) {
        this.pwdconf = pwdconf;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<AdminRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AdminRole> roles) {
        this.roles = roles;
    }

    // Méthode utilitaire
    public boolean passwordsMatch() {
        return pwd != null && pwd.equals(pwdconf);
    }
}
