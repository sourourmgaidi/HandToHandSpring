package com.projet.covoiturage.Service;

import com.projet.covoiturage.Entite.Admin;
import com.projet.covoiturage.enums.AdminRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    private final AdminService adminService;
    private final PasswordEncoder passwordEncoder;

    public DatabaseService(AdminService adminService, PasswordEncoder passwordEncoder) {
        this.adminService = adminService;
        this.passwordEncoder = passwordEncoder;
    }

    public void initializeDatabase() {
        System.out.println("Initializing admin database...");

        // Création des admins de test
        final Admin sousAdmin1 = new Admin();
        sousAdmin1.setNom("sousadmin1");
        sousAdmin1.setMail("sousadmin1@mail.com");
        sousAdmin1.setPwd(passwordEncoder.encode("111"));
        sousAdmin1.addRole(AdminRole.SOUS_ADMIN);

        final Admin sousAdmin2 = new Admin();
        sousAdmin2.setNom("sousadmin2");
        sousAdmin2.setMail("sousadmin2@mail.com");
        sousAdmin2.setPwd(passwordEncoder.encode("222"));
        sousAdmin2.addRole(AdminRole.SOUS_ADMIN);

        final Admin superAdmin = new Admin();
        superAdmin.setNom("superadmin");
        superAdmin.setMail("superadmin@mail.com");
        superAdmin.setPwd(passwordEncoder.encode("333"));
        superAdmin.addRole(AdminRole.SUPER_ADMIN);

        // Enregistrement en base
        System.out.println("Creating sous admin 1: " + adminService.ajouterAdmin(sousAdmin1));
        System.out.println("Creating sous admin 2: " + adminService.ajouterAdmin(sousAdmin2));
        System.out.println("Creating super admin: " + adminService.ajouterAdmin(superAdmin));

        System.out.println("Admin database initialized!");
    }
}
