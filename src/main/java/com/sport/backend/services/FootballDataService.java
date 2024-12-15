package com.sport.backend.services;

import com.sport.backend.models.FootballDataResponse;
import com.sport.backend.models.Competition;
import com.sport.backend.repository.FootballDataResponseRepository;
import com.sport.backend.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FootballDataService {

    @Value("${football.api.base.url}")
    private String baseUrl;

    @Value("${football.api.token}")
    private String apiToken;

    private final RestTemplate restTemplate;
    private final FootballDataResponseRepository footballDataResponseRepository;
    private final CompetitionRepository competitionRepository;

    public FootballDataService(RestTemplate restTemplate, FootballDataResponseRepository footballDataResponseRepository, CompetitionRepository competitionRepository) {
        this.restTemplate = restTemplate;
        this.footballDataResponseRepository = footballDataResponseRepository;
        this.competitionRepository = competitionRepository;
    }

    @Transactional
    public void saveCompetitions() {
        String url = baseUrl + "competitions";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", apiToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Mapper la réponse JSON à un objet FootballDataResponse
        FootballDataResponse footballDataResponse = restTemplate.exchange(url,
                org.springframework.http.HttpMethod.GET,
                entity,
                FootballDataResponse.class).getBody();

        // Sauvegarder les données
        if (footballDataResponse != null) {
            footballDataResponseRepository.save(footballDataResponse);

            // Sauvegarder chaque compétition dans la base de données
            List<Competition> competitions = footballDataResponse.getCompetitions();
            for (Competition competition : competitions) {
                competition.setFootballDataResponse(footballDataResponse);
                competitionRepository.save(competition);
            }
        }
    }
    public List<Competition> getCompetitions() {
        // Récupérer la première instance de FootballDataResponse
        FootballDataResponse footballDataResponse = footballDataResponseRepository.findAll().get(0); // Ceci est un exemple
        return footballDataResponse.getCompetitions();
    }
}
