package com.projet.covoiturage.Service;

import com.projet.covoiturage.Entite.Admin;
import com.projet.covoiturage.dto.AuthAdminDTO;
import com.projet.covoiturage.dto.AuthReponseDTO;
import com.projet.covoiturage.dto.RegisterAdminDTO;
import com.projet.covoiturage.enums.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AdminService adminService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthReponseDTO register(RegisterAdminDTO dto) {
        if (!dto.getPwd().equals(dto.getPwdconf())) {
            throw new IllegalArgumentException("Le mot de passe ne correspond pas au mot de passe de confirmation");
        }

        // Vérifier si un admin avec ce nom existe déjà
        if (adminService.findByNom(dto.getNom()) != null) {
            throw new IllegalArgumentException("Un admin avec ce nom existe déjà");
        }

        Admin admin = new Admin();
        admin.setImage(dto.getImage());
        admin.setMail(dto.getMail());
        admin.setNom(dto.getNom());
        admin.setPrenom(dto.getPrenom());
        admin.setPwd(passwordEncoder.encode(dto.getPwd()));
        // pwdconf n'est pas stocké en base après vérification

        admin.addRole(AdminRole.SUPER_ADMIN); // ✅ Ajoute automatiquement le rôle SUPER_ADMIN

        admin = adminService.ajouterAdmin(admin); // Hibernate gère l'insertion dans admin_roles aussi
        return new AuthReponseDTO(jwtService.generateToken(admin.getNom()));
    }


    public AuthReponseDTO authenticate(AuthAdminDTO dto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            dto.getNom(),
                            dto.getPwd()
                    )
            );

             Admin admin = adminService.findByNom(dto.getNom());
            if (admin == null) {
                throw new RuntimeException("Admin non trouvé");
            }


            return new AuthReponseDTO(jwtService.generateToken(admin.getNom()));
        } catch (AuthenticationException e) {
            throw new RuntimeException("Authentification échouée: Nom d'admin ou mot de passe incorrect", e);
        }
    }
}