package com.projet.covoiturage.Service;

import com.projet.covoiturage.Entite.Admin;
import com.projet.covoiturage.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByNom(nom);
        if (admin == null) {
            throw new UsernameNotFoundException("Admin non trouvé");
        }

        return User.builder()
                .username(admin.getNom())
                .password(admin.getPwd()) // déjà encodé avec BCrypt
                .roles("ADMIN") // tu peux changer ou ajouter des rôles ici
                .build();
    }
}
