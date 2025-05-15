package com.projet.covoiturage.enums;

import lombok.Getter;

@Getter
public enum AdminRole {
    SUPER_ADMIN(1, "SUPER_ADMIN"),
    SOUS_ADMIN(2, "SOUS_ADMIN");

    private final int id;
    private final String description;

    AdminRole(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static AdminRole fromId(int id) {
        for (AdminRole role : values()) {
            if (role.id == id) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role id: " + id);
    }

    public static AdminRole fromDescription(String description) {
        for (AdminRole role : values()) {
            if (role.description.equalsIgnoreCase(description)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role description: " + description);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}