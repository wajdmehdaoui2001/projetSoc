package com.sport.backend.models;

import jakarta.persistence.*;

@Entity // Cette classe est utilisée dans une autre entité
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Définir la stratégie de génération de la clé primaire
    private int id;

    @Column(name = "name") // Personnalisation du nom de la colonne si nécessaire
    private String name;

    @Column(name = "code") // Personnalisation du nom de la colonne si nécessaire
    private String code;

    @Column(name = "flag") // Personnalisation du nom de la colonne si nécessaire
    private String flag;

    // Constructeur par défaut
    public Area() {
    }

    // Constructeur avec arguments
    public Area(int id, String name, String code, String flag) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.flag = flag;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
