package com.sport.backend.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CurrentSeason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate startDate;
    private LocalDate endDate;
    private int currentMatchday;
    private String winner;

    // Constructeur par défaut
    public CurrentSeason() {
    }

    // Constructeur avec arguments
    public CurrentSeason(int id, LocalDate startDate, LocalDate endDate, int currentMatchday, String winner) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentMatchday = currentMatchday;
        this.winner = winner;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getCurrentMatchday() {
        return currentMatchday;
    }

    public void setCurrentMatchday(int currentMatchday) {
        this.currentMatchday = currentMatchday;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
