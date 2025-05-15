package com.projet.covoiturage.dto;

import com.projet.covoiturage.Entite.Admin;
import com.projet.covoiturage.enums.AdminRole;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class AdminDTO {
    // Getters et Setters
    @Setter
    private Long id;
    @Setter
    private String nom;        // Correspond à username dans UserDTO
    @Setter
    private String prenom;
    @Setter
    private String mail;       // Correspond à email dans UserDTO
    @Setter
    private String password;   // Correspond à pwd dans Admin
    @Setter
    private String image;
    private Set<String> roles = new HashSet<>();

    public AdminDTO() {
        super();
    }

    public AdminDTO(Long id, String nom, String prenom, String mail, Set<String> roles) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.roles = roles;
    }

    public AdminDTO(Admin admin) {
        super();
        this.id = admin.getId();
        this.nom = admin.getNom();
        this.prenom = admin.getPrenom();
        this.mail = admin.getMail();
        this.image = admin.getImage();
        this.setRoles(admin.getRoles());
    }

    public void setRoles(Set<AdminRole> roles) {
        this.roles = roles.stream()
                .map(AdminRole::getDescription)
                .collect(Collectors.toSet());
    }
}