package com.sport.backend.services;

import com.sport.backend.models.Competition;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FootballDataGrapheQlService {

    private final Map<String, Competition> competitions = new HashMap<>();

    public FootballDataGrapheQlService() {
        // Données fictives
        Competition competition = new Competition();
        competition.setId("1");
        competition.setName("Champions League");
        competition.setArea("Europe");
        competitions.put(competition.getId(), competition);
    }

    public Competition getCompetition(String competitionId) {
        return competitions.get(competitionId);
    }
}
