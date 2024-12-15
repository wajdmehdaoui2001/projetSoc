package com.sport.backend.controllers;

import com.sport.backend.services.FootballDataService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class FootballGraphQLController {

    private final FootballDataService footballDataService;

    public FootballGraphQLController(FootballDataService footballDataService) {
        this.footballDataService = footballDataService;
    }

    @QueryMapping
    public String getCompetitions() {
        return  null ;//footballDataService.getCompetitions();
    }


}
