package com.projet.covoiturage.exceptions;

public class DuplicationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DuplicationException(String message) {
        super(message);
    }

}
