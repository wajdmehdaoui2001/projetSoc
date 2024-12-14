package com.sport.backend.services;
import com.sport.backend.models.GetCompetitionRequest;
import com.sport.backend.models.GetCompetitionResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FootballSoapEndpoint {

    private final FootballDataService footballDataService;

    public FootballSoapEndpoint(FootballDataService footballDataService) {
        this.footballDataService = footballDataService;
    }

    @PayloadRoot(namespace = "http://example.com/football", localPart = "GetCompetitionRequest")
    @ResponsePayload
    public GetCompetitionResponse GetCompetition(@RequestPayload GetCompetitionRequest request) {
        // Appeler le service FootballData pour obtenir les données
        GetCompetitionResponse response = new GetCompetitionResponse();
        response.setName("Competition Example");
        response.setArea("Europe");
        return response;
    }
}

