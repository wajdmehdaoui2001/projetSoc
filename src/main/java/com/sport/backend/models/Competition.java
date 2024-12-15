package com.sport.backend.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Competition {
    @Id
    private String id;
    private String name;
    private String area;

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
