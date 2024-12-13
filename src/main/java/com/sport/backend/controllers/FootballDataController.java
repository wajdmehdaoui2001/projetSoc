package com.sport.backend.controllers;

import com.sport.backend.services.FootballDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/football")
public class FootballDataController {

    private final FootballDataService footballDataService;

    public FootballDataController(FootballDataService footballDataService) {
        this.footballDataService = footballDataService;
    }

    @GetMapping("/competitions")
    public ResponseEntity<?> getCompetitions() {
        try {
            String competitions = footballDataService.getCompetitions();
            return ResponseEntity.ok(competitions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur : " + e.getMessage());
        }
    }
}
