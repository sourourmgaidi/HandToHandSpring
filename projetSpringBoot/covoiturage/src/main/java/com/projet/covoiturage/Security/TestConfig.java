package com.projet.covoiturage.Security;

import com.projet.covoiturage.Service.DatabaseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    private final DatabaseService databaseService;

    public TestConfig(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            databaseService.initializeDatabase();
        };
    }
}