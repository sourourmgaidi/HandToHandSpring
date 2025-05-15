package com.projet.covoiturage.dto;

public class AuthReponseDTO {
    private String token;

    public AuthReponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
