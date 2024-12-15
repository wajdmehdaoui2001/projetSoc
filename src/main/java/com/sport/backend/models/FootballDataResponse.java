package com.sport.backend.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class FootballDataResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int count;

    @Embedded  // The Filters class is embedded within this entity
    private Filters filters;

    @OneToMany(mappedBy = "footballDataResponse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Competition> competitions;  // Relationship with the Competition class

    // Default constructor
    public FootballDataResponse() {
    }

    // Constructor with arguments
    public FootballDataResponse(Long id, int count, Filters filters, List<Competition> competitions) {
        this.id = id;
        this.count = count;
        this.filters = filters;
        this.competitions = competitions;
    }

    // Getter and Setter for 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for 'count'
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // Getter and Setter for 'filters'
    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    // Getter and Setter for 'competitions'
    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    // The Filters class is embedded within FootballDataResponse
    @Embeddable
    public static class Filters {
        private String client;

        // Getter and Setter for 'client'
        public String getClient() {
            return client;
        }

        public void setClient(String client) {
            this.client = client;
        }
    }
}
