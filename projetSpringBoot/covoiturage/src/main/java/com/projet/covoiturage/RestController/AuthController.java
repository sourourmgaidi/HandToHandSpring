package com.projet.covoiturage.RestController;


import com.projet.covoiturage.dto.AuthAdminDTO;
import com.projet.covoiturage.dto.AuthReponseDTO;
import com.projet.covoiturage.dto.RegisterAdminDTO;
import com.projet.covoiturage.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<AuthReponseDTO> registerAdmin(@RequestBody RegisterAdminDTO dto) {
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthReponseDTO> authenticateAdmin(@RequestBody AuthAdminDTO dto) {
        return ResponseEntity.ok(authService.authenticate(dto));
    }
}
