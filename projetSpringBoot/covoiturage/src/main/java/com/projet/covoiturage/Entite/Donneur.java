package com.projet.covoiturage.Entite;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.processing.Pattern;

import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Donneur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String role = "DONNEUR";
    private String prenom;
    private String email;
    @NotBlank(message = "Le mot de passe est obligatoire")
    private String pwd;

    @NotBlank(message = "La confirmation du mot de passe est obligatoire")
    private String pwdconf;

    private String image;

    @NotBlank(message = "Le CIN est obligatoire")
    private String cin;

    @Min(value = 20, message = "L'âge minimum est 20 ans")
    private int age;

    private String tel;
  private String Nom;




    @OneToMany(mappedBy = "donneur")
    private List<Orphelin> orphelinList;

    @OneToMany(mappedBy = "donneur")
    private List<Message> messagesEnvoyes = new ArrayList<>();

    @OneToMany(mappedBy = "donneur")
    private List<DemandeAdoption> demandesAdoption = new ArrayList<>();



    public Donneur(Long id,String Nom, String prenom, String email, String pwd, String pwdconf, String image, String cin, int age, String tel) {
        this.id = id;
        this.prenom = prenom;
        this.email = email;
        this.pwd = pwd;
        this.pwdconf = pwdconf;
        this.image = image;
        this.cin = cin;
        this.age = age;
        this.tel = tel;
        this.Nom=Nom;
    }
    public Donneur() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public @NotBlank(message = "Le mot de passe est obligatoire") String getPwd() {
        return pwd;
    }

    public void setPwd(@NotBlank(message = "Le mot de passe est obligatoire") String pwd) {
        this.pwd = pwd;
    }

    public @NotBlank(message = "La confirmation du mot de passe est obligatoire") String getPwdconf() {
        return pwdconf;
    }

    public void setPwdconf(@NotBlank(message = "La confirmation du mot de passe est obligatoire") String pwdconf) {
        this.pwdconf = pwdconf;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public @NotBlank(message = "Le CIN est obligatoire") String getCin() {
        return cin;
    }

    public void setCin(@NotBlank(message = "Le CIN est obligatoire") String cin) {
        this.cin = cin;
    }

    @Min(value = 18, message = "L'âge minimum est 18 ans")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 18, message = "L'âge minimum est 18 ans") int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        this.Nom=nom;
    }
}
