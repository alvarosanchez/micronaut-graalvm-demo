package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String stadium;

    public Team(String name, String stadium) {
        this.name = name;
        this.stadium = stadium;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getStadium() {
        return stadium;
    }
}
