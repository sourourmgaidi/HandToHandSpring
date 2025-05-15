package com.projet.covoiturage.Entite;

import com.projet.covoiturage.enums.AdminRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
public class Admin implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;  // Correspond à username dans User

    private String prenom;

    @Column(nullable = false)
    private String pwd;  // Correspond à password dans User

    private String pwdconf;  // Conservé mais non utilisé pour UserDetails

    private String image;

    @Column(nullable = false, unique = true)
    private String mail;  // Correspond à email dans User

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "admin_roles")
    private Set<Integer> roles = new HashSet<>();

    @OneToMany(mappedBy = "admin")
    private List<Orphelin> orphelinList = new ArrayList<>();

    @OneToMany(mappedBy = "admin")
    private List<Donation> donationList = new ArrayList<>();

    @OneToMany(mappedBy = "admin")
    private List<Message> messagesRecus = new ArrayList<>();


    @OneToMany(mappedBy = "admin")
    private List<DemandeAdoption> demandesAdoption;

    // Méthodes pour gérer les rôles
    public Set<AdminRole> getRoles() {
        return roles.stream().map(AdminRole::fromId).collect(Collectors.toSet());
    }

    public void setRoles(Set<AdminRole> roles) {
        if (roles == null || roles.isEmpty()) {
            this.roles.clear();
        } else {
            this.roles = roles.stream().map(AdminRole::getId).collect(Collectors.toSet());
        }
    }

    public void addRole(AdminRole role) {
        this.roles.add(role.getId());
    }

    // Implémentation de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
