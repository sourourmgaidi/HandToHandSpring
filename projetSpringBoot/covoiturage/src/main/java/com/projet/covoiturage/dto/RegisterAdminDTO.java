package com.projet.covoiturage.dto;

public class RegisterAdminDTO {
    private String nom;
    private String prenom;
    private String pwd;
    private String pwdconf;
    private String image;
    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

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
}
