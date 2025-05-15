package com.projet.covoiturage.RestController;

import com.projet.covoiturage.Entite.Admin;
import com.projet.covoiturage.Entite.Donation;
import com.projet.covoiturage.Entite.Orphelin;
import com.projet.covoiturage.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin")
public class AdminRestController {

    @Autowired
    private AdminService adminService;

    // Seul SUPER_ADMIN peut créer des admins
    @PostMapping("/ajouterAdmin")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public Admin creerAdmin(@RequestBody Admin admin) {
        return adminService.ajouterAdmin(admin);
    }

    // Permissions pour les opérations sur les orphelins
    @PostMapping("/ajouterOrph")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'SOUS_ADMIN')")
    public Orphelin creerOrphelin(@RequestBody Orphelin orphelin) {
        return adminService.ajouterOrphelin(orphelin);
    }

    @PutMapping("/modifierOrph/{id}")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public Orphelin modifierOrphelin(@PathVariable Long id, @RequestBody Orphelin orphelin) {
        orphelin.setId(id);
        return adminService.ModifierOrphelin(orphelin);
    }

    @DeleteMapping("/supprimerOrph/{id}")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public void supprimerOrphelin(@PathVariable Long id) {
        adminService.SupprimerOrphelin(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'SOUS_ADMIN')")
    public Object listerOrphelins() {
        List<Orphelin> liste = adminService.AfficherOrphelins();
        return liste.isEmpty() ? "Pas d'orphelin" : liste;
    }

    // Permissions pour les opérations sur les dons
    @DeleteMapping("/supprimerDonation/{id}")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public String supprimerDonation(@PathVariable Long id) {
        adminService.supprimerDonation(id);
        return "Le don avec l'ID " + id + " a été supprimé.";
    }

    @GetMapping("/consulterDons")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public List<Donation> consulterDons() {
        return adminService.consulterDons();
    }

    @DeleteMapping("/supprimerOrph")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public String supprimerTousOrphelins() {
        adminService.supprimerTousOrphelins();
        return "Tous les orphelins ont été supprimés.";
    }

    @DeleteMapping("/supprimerDons")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public void supprimerTousDons() {
        adminService.supprimerTousDons();
    }

    // Méthodes accessibles aux deux rôles
    @GetMapping("/adoptes")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'SOUS_ADMIN')")
    public ResponseEntity<List<Orphelin>> getOrphelinsAdoptes() {
        return ResponseEntity.ok(adminService.consulterOrphAdopt());
    }

    @GetMapping("/age/{age}")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'SOUS_ADMIN')")
    public List<Orphelin> chercherParAge(@PathVariable Long age) {
        return adminService.chercherParAge(age);
    }

    @GetMapping("/origine/{origine}")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'SOUS_ADMIN')")
    public List<Orphelin> chercherParOrigine(@PathVariable String origine) {
        return adminService.chercherParOrigine(origine);
    }
}