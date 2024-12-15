package com.sport.backend.controllers;

import com.sport.backend.models.Competition;
import com.sport.backend.services.FootballDataGrapheQlService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class FootballGraphQLController {

    private final FootballDataGrapheQlService footballDataService;


    public FootballGraphQLController(FootballDataGrapheQlService footballDataService) {
        this.footballDataService = footballDataService;
    }

    @QueryMapping
    public Competition getCompetition(@Argument String competitionId) {
        return footballDataService.getCompetition(competitionId);
    }
}
