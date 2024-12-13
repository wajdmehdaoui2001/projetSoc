package com.sport.backend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FootballDataService {

    @Value("${football.api.base.url}")
    private String baseUrl;

    @Value("${football.api.token}")
    private String apiToken;

    private final RestTemplate restTemplate;

    public FootballDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCompetitions() {
        String url = baseUrl + "competitions";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", apiToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.getForObject(url, String.class, entity);
    }
}

