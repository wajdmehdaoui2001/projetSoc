package com.sport.backend.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetCompetitionResponse {

    private String name;
    private String area;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
