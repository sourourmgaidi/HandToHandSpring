package com.projet.covoiturage.RestController;

import com.projet.covoiturage.Entite.SuiviAdoption;
import com.projet.covoiturage.Service.suiviAdoptService;
import com.projet.covoiturage.Service.suiviAdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class SuiviAdoptionController {
    @Autowired
    private suiviAdoptService suiviAdoptionService;

    @GetMapping("/allSuivie")
    public List<SuiviAdoption> getAllSuivis() {
        return suiviAdoptionService.getAllSuivis();


    }
}