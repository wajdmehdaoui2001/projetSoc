package com.sport.backend.models;

import jakarta.persistence.*;

@Entity
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Clé primaire

    private int competitionId;

    // Relation Many-to-One avec FootballDataResponse
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "football_data_response_id")  // Changer le nom de la colonne de jointure si nécessaire
    private FootballDataResponse footballDataResponse;

    // Relation Many-to-One avec Area
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")  // Nom de la colonne dans la table
    private Area area;

    private String name;

    @Column(name = "code")
    private String code;

    private String type;
    private String emblem;

    // Relation One-to-One avec CurrentSeason
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "current_season_id")  // Nom de la colonne de jointure
    private CurrentSeason currentSeason;

    private int numberOfAvailableSeasons;
    private String lastUpdated;

    // Constructeur sans argument
    public Competition() {
    }

    // Constructeur avec arguments
    public Competition(Long id, int competitionId, FootballDataResponse footballDataResponse, Area area,
                       String name, String code, String type, String emblem, CurrentSeason currentSeason,
                       int numberOfAvailableSeasons, String lastUpdated) {
        this.id = id;
        this.competitionId = competitionId;
        this.footballDataResponse = footballDataResponse;
        this.area = area;
        this.name = name;
        this.code = code;
        this.type = type;
        this.emblem = emblem;
        this.currentSeason = currentSeason;
        this.numberOfAvailableSeasons = numberOfAvailableSeasons;
        this.lastUpdated = lastUpdated;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public FootballDataResponse getFootballDataResponse() {
        return footballDataResponse;
    }

    public void setFootballDataResponse(FootballDataResponse footballDataResponse) {
        this.footballDataResponse = footballDataResponse;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public CurrentSeason getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(CurrentSeason currentSeason) {
        this.currentSeason = currentSeason;
    }

    public int getNumberOfAvailableSeasons() {
        return numberOfAvailableSeasons;
    }

    public void setNumberOfAvailableSeasons(int numberOfAvailableSeasons) {
        this.numberOfAvailableSeasons = numberOfAvailableSeasons;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
